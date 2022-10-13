package barracksWars.interfaces;
//created by J.M.

public interface CommandInterpreter {

	Executable interpretCommand(String[] data, String commandName);
}
