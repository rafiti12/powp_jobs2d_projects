package edu.kis.powp.jobs2d.events;

import edu.kis.powp.jobs2d.features.RecordingMacro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectRecorderOptionListener implements ActionListener {

	RecordingMacro.RecordingOperation operation;
	RecordingMacro recordingMacro;

	public SelectRecorderOptionListener(RecordingMacro.RecordingOperation operation) {
		this.operation = operation;
		recordingMacro = RecordingMacro.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (operation) {
			case START: {
				recordingMacro.start();
				break;
			}
			case STOP: {
				recordingMacro.stop();
				break;
			}
			case DRAW: {
				recordingMacro.draw();
				break;
			}
			case CLEAR: {
				recordingMacro.clear();
				break;
			}
		}
	}
}
