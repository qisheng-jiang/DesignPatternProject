package farm.command;

/*
 * Command Pattern
 * Owner command employees(farmers) to buy,sell or sow plants etc.
 */
public interface Command {

	//execute command
	void execute();
}
