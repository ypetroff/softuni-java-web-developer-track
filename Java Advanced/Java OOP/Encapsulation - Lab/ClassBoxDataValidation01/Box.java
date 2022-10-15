package ClassBoxDataValidation01;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {

        if (validateSideLength(length, "Length")) {

            this.length = length;
        }
    }

    private void setWidth(double width) {

        if (validateSideLength(width, "Width")) {
            this.width = width;
        }

    }

    private void setHeight(double height) {

        if (validateSideLength(height, "Height")) {
            this.height = height;
        }

    }

    private boolean validateSideLength(double side, String name) { //it was void
        if (side <= 0) {

            throw new IllegalArgumentException(String.format("%s cannot be zero or negative.", name));
        }
        return side > 0;
    }

    public double calculateSurfaceArea() {

        return 2 * this.length * this.width + 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {

        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume() {

        return this.length * this.height * this.width;
    }
}
