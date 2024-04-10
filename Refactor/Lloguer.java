package Refactor;

import javax.swing.*;

public class Lloguer {
    public Lloguer() {
    }

    public Lloguer(String data, int dies, Vehicle vehicle) {
        this.data = data;
        this.dies = dies;
        this.vehicle = vehicle;
    }

    private String data;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    private int dies;

    public int getDies() {
        return dies;
    }

    public void setDies(int dies) {
        this.dies = dies;
    }

    private Vehicle vehicle;

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }



}
