package MilitaryElite.entities;

import MilitaryElite.interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {

    private final String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    public String getCodeNumber() {
        return codeNumber;
    }

    @Override
    public String toString() {
        return String.format("%s%nCode Number: %s", super.toString(), this.getCodeNumber());
    }
}
