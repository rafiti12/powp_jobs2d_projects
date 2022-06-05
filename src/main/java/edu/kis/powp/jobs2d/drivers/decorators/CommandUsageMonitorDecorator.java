package edu.kis.powp.jobs2d.drivers.decorators;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;
import edu.kis.powp.jobs2d.features.RecordingMacro;

public class CommandUsageMonitorDecorator extends BaseJob2dDriverDecorator {

	RecordingMacro recordingMacro = RecordingMacro.getInstance();

	public CommandUsageMonitorDecorator(Job2dDriver wrappedDriver) {
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
