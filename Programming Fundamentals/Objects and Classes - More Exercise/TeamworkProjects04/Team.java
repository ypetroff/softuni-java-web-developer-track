package TeamworkProjects04;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private String creator;
    private List<String> members;

    public Team() {
        setMembers(new ArrayList<>());
    }

    public String getName() {
        return name;
    }

    public String getCreator() {
        return creator;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setName(String value) {
        name = value;
    }

    public void setCreator(String value) {
        creator = value;
    }

    public void setMembers(List<String> value) {
        members = value;
    }

    public int countOfMembers() {
        return members.size();
    }
}
