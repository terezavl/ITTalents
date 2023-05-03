package main;

import java.sql.*;

public class DBManager {
    private static DBManager instance=new DBManager();
    private Connection connection;
    private DBManager(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/port_table",
                    "root",
                    "");
        }
        catch (ClassNotFoundException e){
            System.out.println("Problem with the driver "+e.getMessage());
        }
        catch (SQLException e){
            System.out.println("Could not make connection");
        }
    }

    public static DBManager getInstance(){
        return instance;
    }

    public void getOffloadedPackages() {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT dock_id, package_id, ship_name,crane_id,uploading_time FROM port_shipments GROUP BY dock_id ORDER BY uploading_time;");
            ResultSet rs=ps.executeQuery();
            while (rs.next()) {
                System.out.print(rs.getInt("dock_id"));
                System.out.print(rs.getInt("package_id"));
                System.out.print(rs.getString("ship_name"));
                System.out.print(rs.getInt("crane_id"));
                System.out.print(rs.getDate("uploading_time"));
            }

        }catch (SQLException e){
            System.out.println("ah");
        }
    }

    public void totalShipsForTheDay() {
        try {

        PreparedStatement ps= connection.prepareStatement(
                "SELECT dock_id, COUNT(ship_names) AS total FROM port_shipments GROUP BY dock_id HAVING uploading_date>CURRENT_DATE()-1;");

        ResultSet rs =ps.executeQuery();

        }catch (SQLException e){
            System.out.println("ah");
        }
    }

    public void getPackagesSortedByCrane() {
        try {
            PreparedStatement ps=connection.prepareStatement(
                "SELECT crane_id,COUNT(package_id) AS total FROM port_shipments GROUP BY crane_id ORDER BY crane_id;");
            ResultSet rs=ps.executeQuery();

        }catch (SQLException e){
            System.out.println("ah");
        }
    }

    public void getMostLoadedShip() {
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "SELECT ship_name,COUNT(package_id) AS total  FROM port_shipments GROUP BY ship_name ORDER BY total DESC LIMIT 1;");
            ResultSet rs= ps.getResultSet();
        }catch (SQLException e){
            System.out.println("ah");
        }
    }

    public void savePackage(Package p){
        try {
            PreparedStatement ps = connection.prepareStatement(
                    "INSERT INTO port_shipments (boat_name,dock_id,crane_id,unloading_time,package_id) VALUES (?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, p.getShip().getName());
            ps.setInt(2,p.getDock().getId());
            ps.setInt(3, (int) p.getCrane().getId());
            ps.setDate(4,Date.valueOf(p.getOffLoadTime().toLocalDate()));
            ps.setInt(5,p.getId());
            int rows=ps.executeUpdate();
            if(rows>0){
                System.out.println("Well done");
            }
            ResultSet rs= ps.getGeneratedKeys();
            rs.next();
            int idx=rs.getInt(1);
            p.setId(idx);
        }
        catch (SQLException e){
        System.out.println("ah");
        }
    }


}
