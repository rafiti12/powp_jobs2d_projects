package edu.kis.powp.jobs2d.features;

import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.gui.CommandManagerWindow;

import java.util.ArrayList;
import java.util.List;

public final class RecordingMacro {

	private static RecordingMacro instance;

	public static RecordingMacro getInstance() {
		if (instance == null) {
			instance = new RecordingMacro();
		}
		return instance;
	}

	private RecordingMacro() {
	}

	public enum RecordingOperation {
		START, STOP, CLEAR, DRAW
	}

	private final List<DriverCommand> commandList = new ArrayList<>();
	private boolean isRecording = false;

	public void start() {
		isRecording = true;
	}

	public void stop() {
		isRecording = false;
	}

	public void clear() {
		commandList.clear();
	}

	public void save(DriverCommand driver) {
		if (isRecording) {
			commandList.add(driver);
		}
	}

	public void draw() {
		CommandManagerWindow commandManager = new CommandManagerWindow(CommandsFeature.getDriverCommandManager());
		commandManager.importSavedCommands(commandList);
	}
}
