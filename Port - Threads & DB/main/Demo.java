package main;

public class Demo {
    public static void main(String[] args) {
        Port port=new Port();
        Crane.port=port;
        Distributor.port=port;
        Ship.port=port;

        for (int i = 0; i < 20; i++) {
            Ship ship=new Ship("Ship "+(i+1));
            ship.start();
        }
        for (int i = 0; i < 2; i++) {
            Crane crane=new Crane();
            crane.start();
        }
        for (int i = 0; i < 2; i++) {
            Distributor distributor=new Distributor();
            distributor.start();
        }
        Reporter reporter=new Reporter();
        reporter.setDaemon(true);
        reporter.start();
    }
}
