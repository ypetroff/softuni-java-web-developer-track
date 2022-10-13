package barracksWars.core.commands;
//created by J.M.

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

public class Fight extends Command{

    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        return "fight";
    }
}
