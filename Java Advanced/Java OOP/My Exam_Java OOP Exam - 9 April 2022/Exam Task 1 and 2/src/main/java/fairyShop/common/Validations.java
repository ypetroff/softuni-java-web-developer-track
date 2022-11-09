package fairyShop.common;

public class Validations {

    public static void validateNullOrEmpty(String str, String exceptionMessage) {
        if(str == null || str.trim().isEmpty()) {
            throw new NullPointerException(exceptionMessage);
        }
    }

    public static void validateNumberIsBelowZero(int number, String exceptionMessage) {
        if(number < 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
