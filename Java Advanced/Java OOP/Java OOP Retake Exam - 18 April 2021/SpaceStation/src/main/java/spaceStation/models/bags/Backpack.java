package spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;

public class Backpack implements Bag{

    private Collection<String> items;

    public Backpack() {
        this.items = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.items;
    }

    public void setItems(Collection<String> items) {
        this.items = items;
    }
}
