package edu.kis.powp.jobs2d.factories;

import edu.kis.powp.jobs2d.command.ComplexCommand;
import edu.kis.powp.jobs2d.command.DriverCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public class ComplexCommandFactory {

	private ComplexCommandFactory(){}

	public enum TestShape {
		FIGURE1, FIGURE2 ,RECTANGLE, STAR
	}

	public static DriverCommand getRectangle()
	{
		ComplexCommand command = new ComplexCommand();
		command.appendCommand(new SetPositionCommand(10, 10));
		command.appendCommand(new OperateToCommand(20, 10));
		command.appendCommand(new OperateToCommand(20, 20));
		command.appendCommand(new OperateToCommand(10, 20));
		command.appendCommand(new OperateToCommand(10, 10));
		return command;
	}
	public static DriverCommand getStar()
	{
		ComplexCommand command = new ComplexCommand();
		command.appendCommand(new SetPositionCommand(60, 20));
		command.appendCommand(new OperateToCommand(100, 110));
		command.appendCommand(new OperateToCommand(10, 50));
		command.appendCommand(new OperateToCommand(110, 50));
		command.appendCommand(new OperateToCommand(20, 110));
		command.appendCommand(new OperateToCommand(60, 20));
		return command;
	}
}
