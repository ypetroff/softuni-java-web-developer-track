package MilitaryElite.entities;

import MilitaryElite.interfaces.Repair;

public class RepairImpl implements Repair {

    private final String partName;
    private final int hoursWorked;

    public RepairImpl(String partName, int hoursWorked) {
        this.partName = partName;
        this.hoursWorked = hoursWorked;
    }

    public String getPartName() {
        return partName;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d", this.getPartName(), this.getHoursWorked());
    }
}
