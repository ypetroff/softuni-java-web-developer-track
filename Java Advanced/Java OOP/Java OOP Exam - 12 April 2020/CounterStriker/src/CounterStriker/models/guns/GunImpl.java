package CounterStriker.models.guns;


import CounterStriker.utils.CheckStringValidity;

import static CounterStriker.utils.CheckIntegerValidity.isNotNegative;
import static CounterStriker.utils.CheckStringValidity.isValid;

public abstract class GunImpl implements Gun{

    private String name;
    private int bulletsCount;

    protected GunImpl(String name, int bulletsCount) {
        setName(name);
        setBulletsCount(bulletsCount);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getBulletsCount() {
        return this.bulletsCount;
    }

    @Override
    public int fire() {
        return 0;
    }

    private void setName(String name) {
        isValid(name, "gun");
        this.name = name;
    }

    protected void setBulletsCount(int bulletsCount) {
        isNotNegative(bulletsCount);
        this.bulletsCount = bulletsCount;
    }
}
