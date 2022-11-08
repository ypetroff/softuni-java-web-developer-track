package glacialExpedition.models.states;

import glacialExpedition.common.ExceptionMessages;
import glacialExpedition.common.Validations;

import java.util.ArrayList;
import java.util.Collection;

public class StateImpl implements State{

    private String name;
    private Collection<String> exhibits;

    public StateImpl(String name) {
        this.setName(name);
        exhibits = new ArrayList<>();
    }

    private void setName(String name) {
        Validations.nullOrEmpty(name, ExceptionMessages.STATE_NAME_NULL_OR_EMPTY);
        this.name = name;
    }

    @Override
    public Collection<String> getExhibits() {
        return this.exhibits;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
