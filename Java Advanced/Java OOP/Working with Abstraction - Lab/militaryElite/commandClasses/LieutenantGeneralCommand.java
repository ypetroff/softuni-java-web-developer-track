package militaryElite.commandClasses;
//created by J.M.

import militaryElite.factoryClasses.SoldierFactory;
import militaryElite.interfaces.Soldier;

import java.util.List;

public class LieutenantGeneralCommand extends BaseCommand {

    public LieutenantGeneralCommand(List<Soldier> soldiers) {
        super(soldiers);
    }

    @Override
    public void execute(List<String> args) {
        super.add(SoldierFactory.produceLieutenantGeneral(args, this.getSoldier()));
    }
}
