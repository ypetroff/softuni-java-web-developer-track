package FamilyTree08;

import java.util.List;

public class Child {
    private final String identifier;
    private final List<String> parents;

    public Child(String identifier, List<String> parents) {
        this.identifier = identifier;
        this.parents = parents;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<String> getParents() {
        return parents;
    }
}
