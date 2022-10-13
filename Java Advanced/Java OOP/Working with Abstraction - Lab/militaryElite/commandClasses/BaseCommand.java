package militaryElite.commandClasses;
//created by J.M.

import militaryElite.interfaces.Command;
import militaryElite.interfaces.Soldier;

import java.util.List;

public abstract class BaseCommand implements Command {

    private final List<Soldier> soldiers;

    protected BaseCommand(List<Soldier> soldiers) {
        this.soldiers = soldiers;
    }

    protected List<Soldier> getSoldier() {
        return this.soldiers;
    }

    public void add(Soldier soldier) {
        this.soldiers.add(soldier);
    }
}
