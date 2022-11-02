package CounterStriker.utils;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_NAME;
import static CounterStriker.common.ExceptionMessages.INVALID_PLAYER_NAME;

public class CheckStringValidity {

    public static void isValid(String str, String entity) {

        if (str == null || str.trim().isEmpty()) {

            throw new NullPointerException(entity.equals("gun")
                    ? INVALID_GUN_NAME
                    : INVALID_PLAYER_NAME);
        }
    }
}
