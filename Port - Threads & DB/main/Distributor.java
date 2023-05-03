package main;

public class Distributor extends Thread{
    public static Port port;
    @Override
    public void run() {
        while (true){
            port.removeFromStorage();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("oh");
            }
        }
    }
}
