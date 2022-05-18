package edu.kis.powp.jobs2d.command.manager;

import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.ICompoundCommand;
import edu.kis.powp.jobs2d.command.visitor.IDriverCommandsVisitor;
import edu.kis.powp.observer.Publisher;

import java.util.Iterator;
import java.util.List;

/**
 * Driver command Manager.
 */
public class DriverCommandManager {
	private DriverCommand currentCommand = null;

	private Publisher changePublisher = new Publisher();

	/**
	 * Set current command.
	 *
	 * @param commandList Set the command as current.
	 */
	public synchronized void setCurrentCommand(DriverCommand commandList) {
		this.currentCommand = commandList;
		changePublisher.notifyObservers();
	}

	/**
	 * Set current command.
	 *
	 * @param commandList list of commands representing a compound command.
	 * @param name        name of the command.
	 */
	public synchronized void setCurrentCommand(List<DriverCommand> commandList, String name) {
		setCurrentCommand(new ICompoundCommand() {

			List<DriverCommand> driverCommands = commandList;

			@Override
			public void execute(Job2dDriver driver) {
				driverCommands.forEach((c) -> c.execute(driver));
			}

			@Override
			public Iterator<DriverCommand> iterator() {
				return driverCommands.iterator();
			}

			@Override
			public String toString() {
				StringBuilder stringBuilder = new StringBuilder(name + '\n');
				for (DriverCommand dc : commandList) {
					stringBuilder.append(dc.toString()).append("\n");
				}
				return stringBuilder.toString();
			}

			@Override
			public void accept(IDriverCommandsVisitor visitor) {
				visitor.doForCompoundCommand(this);
			}
		});

	}

	/**
	 * Return current command.
	 *
	 * @return Current command.
	 */
	public synchronized DriverCommand getCurrentCommand() {
		return currentCommand;
	}

	public synchronized void clearCurrentCommand() {
		currentCommand = null;
	}

	public synchronized String getCurrentCommandString() {
		if (getCurrentCommand() == null) {
			return "No command loaded";
		} else
			return getCurrentCommand().toString();
	}

	public Publisher getChangePublisher() {
		return changePublisher;
	}

}