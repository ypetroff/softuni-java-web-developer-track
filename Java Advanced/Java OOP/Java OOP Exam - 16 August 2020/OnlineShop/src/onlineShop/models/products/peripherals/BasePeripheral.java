package onlineShop.models.products.peripherals;

import onlineShop.models.BaseProduct;

public abstract class BasePeripheral extends BaseProduct implements Peripheral {

    private String connectionType;

    protected BasePeripheral(
            int id, String manufacturer, String model, double price, double overallPerformance, String connectionType) {
        super(id, manufacturer, model, price, overallPerformance);
        this.connectionType = connectionType;
    }

    @Override
    public String toString() {
        return String.format("%s Connection Type: %s", super.toString(), this.connectionType);
    }

    @Override
    public String getConnectionType() {
        return this.connectionType;
    }
}





