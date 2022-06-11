package edu.kis.powp.jobs2d.drivers.decorators;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.features.RecordingMacro;

public class CommandRecorderDriverDecorator extends BaseJob2dDriverDecorator {

    private RecordingMacro recordingMacro = RecordingMacro.getInstance();

    public CommandRecorderDriverDecorator(Job2dDriver wrappedDriver) {
        super(wrappedDriver);
    }

    @Override
    public void operateTo(int x, int y) {
        wrappedDriver.operateTo(x, y);
        recordingMacro.save(new OperateToCommand(x, y));
    }

    @Override
    public void setPosition(int x, int y) {
        wrappedDriver.setPosition(x, y);
        recordingMacro.save(new SetPositionCommand(x, y));
    }
}