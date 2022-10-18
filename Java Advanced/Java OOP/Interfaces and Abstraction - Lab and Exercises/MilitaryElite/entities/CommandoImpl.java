package MilitaryElite.entities;

import MilitaryElite.enums.Corps;
import MilitaryElite.interfaces.Commando;
import MilitaryElite.interfaces.Mission;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private List<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new ArrayList<>();
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public Collection<Mission> getMissions() {
        return Collections.unmodifiableCollection(this.missions);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(super.toString());
        out.append(System.lineSeparator()).append("Missions:").append(System.lineSeparator());
        for (Mission mission : this.missions) {
            out.append("  ").append(mission.toString()).append(System.lineSeparator());
        }
        return out.toString().trim();
    }
}
