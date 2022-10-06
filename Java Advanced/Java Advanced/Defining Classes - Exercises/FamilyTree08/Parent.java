package FamilyTree08;

import java.util.List;


public class Parent {
private final String identifier;
private final List<String> children;

    public Parent(String identifier, List<String> children) {
        this.identifier = identifier;
        this.children = children;
    }

    public String getIdentifier() {
        return identifier;
    }

    public List<String> getChildren() {
        return children;
    }

}
