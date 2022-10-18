package MilitaryElite.entities;

import MilitaryElite.enums.Corps;
import MilitaryElite.interfaces.SpecialisedSoldier;

public abstract class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private final Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }


    public Corps getCorps() {
        return corps;
    }

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), this.getCorps());
    }
}
