<<<<<<< HEAD
package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverComposite implements Job2dDriver {
    private List<Job2dDriver> driverList;

    public DriverComposite(List<Job2dDriver> driverList) {
        this.driverList = driverList;
    }

    public DriverComposite(){
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
        for (Job2dDriver job2dDriver : driverList) {
            job2dDriver.setPosition(x, y);
        }
    }

    @Override
    public void operateTo(int x, int y) {
        for (Job2dDriver job2dDriver : driverList) {
            job2dDriver.operateTo(x, y);
        }
    }

    public List<Job2dDriver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Job2dDriver> driverList) {
        this.driverList = driverList;
    }
}
=======
package edu.kis.powp.jobs2d.drivers;

import edu.kis.powp.jobs2d.Job2dDriver;

import java.util.ArrayList;
import java.util.List;

public class DriverComposite implements Job2dDriver {
    private List<Job2dDriver> driverList;

    public DriverComposite(List<Job2dDriver> driverList) {
        this.driverList = driverList;
    }

    public DriverComposite(){
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
        for (Job2dDriver job2dDriver : driverList) {
            job2dDriver.setPosition(x, y);
        }
    }

    @Override
    public void operateTo(int x, int y) {
        for (Job2dDriver job2dDriver : driverList) {
            job2dDriver.operateTo(x, y);
        }
    }

    public List<Job2dDriver> getDriverList() {
        return driverList;
    }

    public void setDriverList(List<Job2dDriver> driverList) {
        this.driverList = driverList;
    }
}
>>>>>>> origin/rafiti12
