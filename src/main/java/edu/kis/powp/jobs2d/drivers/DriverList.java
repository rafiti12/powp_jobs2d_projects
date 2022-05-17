package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverList implements Job2dDriver {
    private List<Job2dDriver> driverList;
    private int currentDriverIndex = -1;

    public DriverList(List<Job2dDriver> driverList) {
        this.driverList = driverList;
    }

    public DriverList(){
        List<Job2dDriver> driverList = new ArrayList<Job2dDriver>();
    }

    public void addDriver(Job2dDriver driver){
        driverList.add(driver);
    }

    public void removeDriver(Job2dDriver driver){
        driverList.remove(driver);
    }

    @Override
    public void setPosition(int x, int y) {
        if(currentDriverIndex < 0)
            System.out.println("Current driver not selected.");
        else
            driverList.get(currentDriverIndex).setPosition(x, y);
    }

    @Override
    public void operateTo(int x, int y) {
        if(currentDriverIndex < 0)
            System.out.println("Current driver not selected.");
        else
            driverList.get(currentDriverIndex).operateTo(x, y);
    }

    public List<Job2dDriver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Job2dDriver> driverList) {
        this.driverList = driverList;
    }

    public int getCurrentDriverIndex() {
        return currentDriverIndex;
    }

    public void setCurrentDriverIndex(int currentDriverIndex) {
        if(currentDriverIndex >= driverList.size())
            System.out.println("Driver doesn't exist.");
        else
            this.currentDriverIndex = currentDriverIndex;
    }
}
