package onlineShop.common;

import onlineShop.models.products.components.Component;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.*;

public class Validations {

    public static void ValidateNotZeroOrNegative(double number, String exceptionMessage) {

        if(number <= 0) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void ValidateNotNullOrWhitespace(String str, String exceptionMessage) {

        if(str == null || str.trim().isEmpty()) {
            throw new IllegalArgumentException(exceptionMessage);
        }
    }

    public static void ValidateThisComputerIsNotPresentInCollection(Map<Integer, Computer>computers, int id) {
        if (computers.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPUTER_ID);
        }
    }

    public static void ValidateComputerType(String computerType) {
        if(!computerType.equals("Laptop") && !computerType.equals("DesktopComputer")) {
            throw new IllegalArgumentException(INVALID_COMPUTER_TYPE);
        }
    }

    public static void ValidateThisComputerIsPresentInCollection(Map<Integer, Computer>computers, int id) {
        if(!computers.containsKey(id)) {
            throw new IllegalArgumentException(NOT_EXISTING_COMPUTER_ID);
        }
    }

    public static void ValidateThisPeripheralIsNotPresentInCollection(Map<Integer, Peripheral>peripherals, int id) {
        if(peripherals.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_PERIPHERAL_ID);
        }
    }

    public static void ValidateThisComponentIsNotPresentInCollection(Map<Integer, Component>components, int id) {
        if(components.containsKey(id)) {
            throw new IllegalArgumentException(EXISTING_COMPONENT_ID);
        }
    }
}
