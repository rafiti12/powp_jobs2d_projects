package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.gui.CommandManagerWindow;

import java.util.ArrayList;
import java.util.List;

public final class RecordingMacro {

	private static RecordingMacro instance;
	private final List<DriverCommand> commandList;


	public synchronized static RecordingMacro getInstance() {
		if (instance == null) {
			instance = new RecordingMacro();
		}
		return instance;
	}

	private RecordingMacro() {
		commandList = new ArrayList<>();
	}

	public void save(DriverCommand driver) {
		commandList.add(driver);

	}

	public List<DriverCommand> getCommandList() {
		return commandList;
	}

}
