package edu.kis.powp.jobs2d.command.visitor;

import edu.kis.powp.jobs2d.command.ICompoundCommand;
import edu.kis.powp.jobs2d.command.OperateToCommand;
import edu.kis.powp.jobs2d.command.SetPositionCommand;

public interface IDriverCommandsVisitor {
	void doForOperateToCommand(OperateToCommand command);

	void doForSetPositionCommand(SetPositionCommand command);

	void doForCompoundCommand(ICompoundCommand command);
}
