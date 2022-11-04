package onlineShop.core;

import onlineShop.common.Validations;
import onlineShop.core.interfaces.Controller;
import onlineShop.models.products.components.*;
import onlineShop.models.products.computers.Computer;
import onlineShop.models.products.computers.DesktopComputer;
import onlineShop.models.products.computers.Laptop;
import onlineShop.models.products.peripherals.*;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import static onlineShop.common.constants.ExceptionMessages.*;
import static onlineShop.common.constants.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Map<Integer, Computer> computers;
    private Map<Integer, Component> components;
    private Map<Integer, Peripheral> peripherals;

    public ControllerImpl() {
        computers = new HashMap<>();
        components = new HashMap<>();
        peripherals = new HashMap<>();

    }

    @Override
    public String addComputer(String computerType, int id, String manufacturer, String model, double price) {
        Validations.ValidateThisComputerIsNotPresentInCollection(this.computers, id);
        Validations.ValidateComputerType(computerType);

        computers.put(id, computerType.equals("Laptop")
                ? new Laptop(id, manufacturer, model, price)
                : new DesktopComputer(id, manufacturer, model, price));
        return String.format(ADDED_COMPUTER, id);
    }

    @Override
    public String addPeripheral(int computerId, int id, String peripheralType, String manufacturer,
                                String model, double price, double overallPerformance, String connectionType) {
        Validations.ValidateThisComputerIsPresentInCollection(this.computers, computerId);
        Validations.ValidateThisPeripheralIsNotPresentInCollection(this.peripherals, id);

        Peripheral peripheral;

        switch (peripheralType) {
            case "Headset":
                peripheral = new Headset(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "KeyBoard":
                peripheral = new Keyboard(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Monitor":
                peripheral = new Monitor(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            case "Mouse":
                peripheral = new Mouse(id, manufacturer, model, price, overallPerformance, connectionType);
                break;
            default:
                throw new IllegalArgumentException(INVALID_PERIPHERAL_TYPE);
        }

        this.peripherals.put(id, peripheral);
        this.computers.get(computerId).addPeripheral(peripheral);


        return String.format(ADDED_PERIPHERAL, peripheralType, id, computerId);
    }

    @Override
    public String removePeripheral(String peripheralType, int computerId) {
        Validations.ValidateThisComputerIsPresentInCollection(this.computers, computerId);

        Peripheral peripheral = this.computers.get(computerId).removePeripheral(peripheralType);

      //  this.computers.get(computerId).removePeripheral(peripheralType);
        this.peripherals.remove(peripheral.getId());

        return String.format(REMOVED_PERIPHERAL, peripheralType, peripheral.getId());
    }

    @Override
    public String addComponent(
            int computerId,
            int id,
            String componentType,
            String manufacturer,
            String model,
            double price,
            double overallPerformance,
            int generation) {

        Validations.ValidateThisComputerIsPresentInCollection(this.computers, computerId);
        Validations.ValidateThisComponentIsNotPresentInCollection(this.components, id);

        Component component;

        switch (componentType) {
            case "CentralProcessingUnit":
                component = new CentralProcessingUnit(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "Motherboard":
                component = new Motherboard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "PowerSupply":
                component = new PowerSupply(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "RandomAccessMemory":
                component = new RandomAccessMemory(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "SolidStateDrive":
                component = new SolidStateDrive(id, manufacturer, model, price, overallPerformance, generation);
                break;
            case "VideoCard":
                component = new VideoCard(id, manufacturer, model, price, overallPerformance, generation);
                break;
            default:
                throw new IllegalArgumentException(INVALID_COMPONENT_TYPE);
        }

        this.computers.get(computerId).addComponent(component);
        this.components.put(id, component);
        return String.format(ADDED_COMPONENT, componentType, id, computerId);
    }

    @Override
    public String removeComponent(String componentType, int computerId) {
        Validations.ValidateThisComputerIsPresentInCollection(this.computers, computerId);

        Component component = this.computers.get(computerId).removeComponent(componentType);
        this.components.remove(component.getId());
        return String.format(REMOVED_COMPONENT, componentType, component.getId());
    }

    @Override //TODO: validate if the computer exists!
    public String buyComputer(int id) {

        Validations.ValidateThisComputerIsPresentInCollection(this.computers, id);

        String computerMessage = this.computers.get(id).toString();
        this.computers.remove(id);
        return computerMessage;
    }

    @Override
    public String BuyBestComputer(double budget) {

        Computer bestBuy = this.computers.values().stream()
                .filter(c -> c.getPrice() <= budget)
                .max(Comparator.comparingDouble(Computer::getOverallPerformance)).orElse(null);

        if(bestBuy == null) {
           throw new IllegalArgumentException(String.format(CAN_NOT_BUY_COMPUTER, budget));
        }

        this.computers.remove(bestBuy.getId());
        return bestBuy.toString();
    }

    @Override //TODO: validate if the computer exists!
    public String getComputerData(int id) {
        Validations.ValidateThisComputerIsPresentInCollection(this.computers, id);
        return this.computers.get(id).toString();
    }
}
