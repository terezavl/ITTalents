package main;

import java.time.LocalDateTime;

public class Package {
    private int id;
    private Dock dock;
    private Ship ship;
    private Crane crane;
    private LocalDateTime offLoadTime;

    public void setId(int id) {
        this.id = id;
    }

    public void setCrane(Crane crane) {
        this.crane = crane;
    }

    public void setDock(Dock dock) {
        this.dock = dock;
    }

    public void setOffLoadTime(LocalDateTime offLoadTime) {
        this.offLoadTime = offLoadTime;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public Crane getCrane() {
        return crane;
    }

    public Dock getDock() {
        return dock;
    }

    public Ship getShip() {
        return ship;
    }

    public LocalDateTime getOffLoadTime() {
        return offLoadTime;
    }

    public int getId() {
        return this.id;
    }
}
