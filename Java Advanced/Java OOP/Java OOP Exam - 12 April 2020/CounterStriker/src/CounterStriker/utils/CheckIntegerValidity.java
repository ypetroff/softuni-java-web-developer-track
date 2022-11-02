package CounterStriker.utils;

import static CounterStriker.common.ExceptionMessages.*;

public class CheckIntegerValidity {

    public static void isNotNegative(int n) {
        if (n < 0) {
            throw new IllegalArgumentException(INVALID_GUN_BULLETS_COUNT);
        }
    }

    public static void isNotNegative(int n, String attribute) {
        if (n < 0) {
            throw new IllegalArgumentException(
                    attribute.equals("health")
                            ? INVALID_PLAYER_HEALTH
                            : INVALID_PLAYER_ARMOR);
        }
    }
}
