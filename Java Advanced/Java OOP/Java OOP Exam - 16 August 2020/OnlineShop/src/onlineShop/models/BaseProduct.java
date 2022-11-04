package onlineShop.models;

import static onlineShop.common.Validations.ValidateNotNullOrWhitespace;
import static onlineShop.common.Validations.ValidateNotZeroOrNegative;
import static onlineShop.common.constants.ExceptionMessages.*;

public abstract class BaseProduct implements Product {

    private int id;
    private String manufacturer;
    private String model;
    private double price;
    private double overallPerformance;


    protected BaseProduct(int id, String manufacturer, String model, double price, double overallPerformance) {
        setId(id);
        setManufacturer(manufacturer);
        setModel(model);
        setPrice(price);
        setOverallPerformance(overallPerformance);
    }

    private void setId(int id) {
        ValidateNotZeroOrNegative(id, INVALID_PRODUCT_ID);
        this.id = id;
    }

    private void setManufacturer(String manufacturer) {
        ValidateNotNullOrWhitespace(manufacturer, INVALID_MANUFACTURER);
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        ValidateNotNullOrWhitespace(model, INVALID_MODEL);
        this.model = model;
    }

    public void setPrice(double price) {
        ValidateNotZeroOrNegative(price, INVALID_PRICE);
        this.price = price;
    }

    public void setOverallPerformance(double overallPerformance) {
        ValidateNotZeroOrNegative(overallPerformance, INVALID_OVERALL_PERFORMANCE);
        this.overallPerformance = overallPerformance;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    @Override
    public double getOverallPerformance() {
        return this.overallPerformance;
    }

    @Override
    public String toString() {
        return String.format(
                "Overall Performance: %.2f. Price: %.2f - %s: %s %s (Id: %d)",
                this.getOverallPerformance(),
                this.getPrice(),
                this.getClass().getSimpleName(),
                this.getManufacturer(),
                this.getModel(),
                this.getId());
    }
}
