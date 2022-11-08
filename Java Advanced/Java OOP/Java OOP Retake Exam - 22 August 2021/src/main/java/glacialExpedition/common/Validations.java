package glacialExpedition.common;

public class Validations {

    public static void nullOrEmpty(String str, String exceptionMessage) {
        if(str == null || str.trim().isEmpty()) {
            throw new NullPointerException(exceptionMessage);
        }
    }

    public static void negativeNumber(double number, String exceptionMessage) {
        if(number < 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }
}
