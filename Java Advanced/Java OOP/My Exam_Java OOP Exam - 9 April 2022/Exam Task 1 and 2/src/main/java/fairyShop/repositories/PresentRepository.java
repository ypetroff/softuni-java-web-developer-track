package fairyShop.repositories;

import fairyShop.models.Present;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class PresentRepository implements Repository<Present> {

    Map<String, Present> presents;

    public PresentRepository() {
        presents = new LinkedHashMap<>();
    }

    @Override
    public Collection<Present> getModels() {
        return Collections.unmodifiableCollection(presents.values());
    }

    @Override
    public void add(Present preset) {
        presents.put(preset.getName(), preset);
    }

    @Override
    public boolean remove(Present preset) {
        return presents.remove(preset.getName()) != null;
    }

    @Override
    public Present findByName(String name) {
        return presents.get(name);
    }
}
