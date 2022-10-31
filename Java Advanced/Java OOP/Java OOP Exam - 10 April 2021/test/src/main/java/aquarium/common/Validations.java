package aquarium.common;

public class Validations {

    public static void validateNotNullOrEmptyString(String str, String message) {
        if (str == null || str.trim().isEmpty()) {
            throw new NullPointerException(message);
        }
    }
}
