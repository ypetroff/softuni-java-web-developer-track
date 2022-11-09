package fairyShop.models;

import fairyShop.common.ExceptionMessages;
import fairyShop.common.Validations;

public class InstrumentImpl implements Instrument{

    private final static int DEFAULT_DECREASE_UNITS = 10;

    private int power;

    public InstrumentImpl(int power) {
       this.setPower(power);
    }

    private void setPower(int power) {
        Validations.validateNumberIsBelowZero(power, ExceptionMessages.INSTRUMENT_POWER_LESS_THAN_ZERO);
        this.power = power;
    }

    @Override
    public int getPower() {
        return this.power;
    }

    @Override
    public void use() {
        this.power = Math.max(0, this.power - DEFAULT_DECREASE_UNITS);
    }

    @Override
    public boolean isBroken() {
        return this.power == 0;
    }
}
