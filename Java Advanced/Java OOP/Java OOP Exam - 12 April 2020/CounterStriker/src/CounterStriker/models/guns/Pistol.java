package CounterStriker.models.guns;

public class Pistol extends GunImpl {

    private static final int FIRED_BULLETS = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {

        if (this.getBulletsCount() < FIRED_BULLETS) {
            return super.fire();
        }

        this.setBulletsCount(getBulletsCount() - FIRED_BULLETS);

        return FIRED_BULLETS;
    }
}
