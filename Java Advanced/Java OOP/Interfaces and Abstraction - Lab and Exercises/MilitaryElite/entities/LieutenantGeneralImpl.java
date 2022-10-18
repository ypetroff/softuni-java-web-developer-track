package MilitaryElite.entities;

import MilitaryElite.interfaces.LieutenantGeneral;
import MilitaryElite.interfaces.Private;

import java.util.ArrayList;
import java.util.List;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private int id;
    private String firstName;
    private String lastName;
    private double salary;
    private List<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        privates = new ArrayList<>();
    }

    @Override
    public void addPrivate(Private priv) {
        this.privates.add(priv);
    }

    @Override
    public double getSalary() {
        return this.salary;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String firstName() {
        return this.firstName;
    }

    @Override
    public String lastName() {
        return this.lastName;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder(super.toString());
        output.append(System.lineSeparator()).append("Privates:").append(System.lineSeparator());
        for (Private soldier : this.privates) {
            output.append("  ").append(soldier.toString()).append(System.lineSeparator());
        }
        return String.format("%s",output.toString().trim());
    }
}
