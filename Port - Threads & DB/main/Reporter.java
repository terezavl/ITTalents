package main;

public class Reporter extends Thread{

    @Override
    public void run() {
        try {
            Thread.sleep(24*60*60*1000);
            report1();
            report2();
            report3();
            report4();
        } catch (InterruptedException e) {
            System.out.println("opa");
        }
    }

    private void report4() {
        DBManager.getInstance().getMostLoadedShip();
    }

    private void report3() {
        DBManager.getInstance().getPackagesSortedByCrane();
    }
    private void report2() {
        DBManager.getInstance().totalShipsForTheDay();
    }
    private void report1() {
        DBManager.getInstance().getOffloadedPackages();
    }
}
