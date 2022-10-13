package militaryElite.factoryClasses;
//created by J.M.

import militaryElite.enumeration.Corps;
import militaryElite.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private final Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps.getCorps();
    }

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), this.getCorps());
    }
}
