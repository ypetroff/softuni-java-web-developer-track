package onlineShop.models.products.computers;

import onlineShop.models.BaseProduct;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseComputer extends BaseProduct implements Computer{

    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        this.components = new ArrayList<>();
        this.peripherals = new ArrayList<>();
    }

    @Override
    public double getPrice() {
        double peripheralsSum = this.peripherals.stream().mapToDouble(Peripheral::getPrice).sum();
        double componentsSum = this.components.stream().mapToDouble(Component::getPrice).sum();
        return super.getPrice() + peripheralsSum + componentsSum;
    }

    @Override
    public double getOverallPerformance() {
        return this.components.isEmpty()
                ? super.getOverallPerformance()
                : super.getOverallPerformance() + getComponentsAveragePerformance();
    }


    @Override
    public void addComponent(Component component) {
       if(this.components.stream().
               anyMatch(c -> c.getClass().getSimpleName().equals(component.getClass().getSimpleName()))) {
           String exceptionMessage = String.format(
                   EXISTING_COMPONENT,
                   component.getClass().getSimpleName(),
                   this.getClass().getSimpleName(),
                   this.getId());
           throw new IllegalArgumentException(exceptionMessage);
       }

        this.components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {

            Component exist = components.stream().filter(e -> e.getClass().getSimpleName()
                    .equals(componentType)).findFirst().orElse(null);

            if (exist == null) {
                throw new IllegalArgumentException(String.format(NOT_EXISTING_COMPONENT,
                        componentType, this.getClass().getSimpleName(), this.getId()));
            }
            components.remove(exist);
            return exist;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {
        if(this.peripherals.stream()
                .anyMatch(p -> p.getClass().getSimpleName().equals(peripheral.getClass().getSimpleName()))) {
            String exceptionMessage = String.format(
                    EXISTING_PERIPHERAL,
                    peripheral.getClass().getSimpleName(),
                    this.getClass().getSimpleName(), this.getId());
            throw new IllegalArgumentException(exceptionMessage);
        }

        this.peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        Peripheral exist = this.peripherals.stream()
                .filter(p -> p.getClass().getSimpleName().equals(peripheralType))
                .findFirst().orElse(null);

        if(exist == null) {
            throw new IllegalArgumentException(String.format(
                    NOT_EXISTING_PERIPHERAL, peripheralType, this.getClass().getSimpleName(), this.getId()));
        }
        this.peripherals.remove(exist);
        return exist;
    }

    @Override
    public String toString() {
        return String.format("%s%n %s%n %s",
                super.toString(),
                appendComponents(this.components),
        appendPeripherals(this.peripherals));
    }


    @Override
    public List<Component> getComponents() {

        return this.components;
    }

    @Override
    public List<Peripheral> getPeripherals() {

        return this.peripherals;
    }

    private String appendComponents(List<Component> components) {
        StringBuilder sb = new StringBuilder(
                String.format(" Components (%d):", components.size())).append(System.lineSeparator());

        components.forEach( c -> sb.append(String.format("  %s", c.toString())).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    private String appendPeripherals(List<Peripheral> peripherals) {

        double overallAverage = gerPeripheralAveragePerformance(peripherals);

        StringBuilder sb = new StringBuilder(
                String.format(" Peripherals (%d); Average Overall Performance (%.2f):",
                        peripherals.size(), overallAverage)).append(System.lineSeparator()); //

        peripherals.forEach( p -> sb.append(String.format("  %s", p.toString())).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    private double gerPeripheralAveragePerformance(List<Peripheral> peripherals) {
        return peripherals.stream().mapToDouble(Peripheral::getOverallPerformance).average().orElse(0)

               /* peripherals.stream()
                .collect(Collectors.averagingDouble(Peripheral::getOverallPerformance)) */;
    }

    private double getComponentsAveragePerformance() {
        return components.stream().mapToDouble(Component::getOverallPerformance).average().orElse(0);
    }

}
