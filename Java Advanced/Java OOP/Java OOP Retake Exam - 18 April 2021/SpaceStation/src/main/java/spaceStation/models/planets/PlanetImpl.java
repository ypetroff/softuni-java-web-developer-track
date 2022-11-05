package spaceStation.models.planets;

import spaceStation.common.ExceptionMessages;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PlanetImpl implements Planet{

    private String name;
    private Collection<String> items;


    public PlanetImpl(String name) {
        this.name = name;
        items = new ArrayList<>();

    }

    public void setName(String name) {
        if(name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.PLANET_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

    public void setItems(Collection<String> items) {
        this.items = items;
    }
}
