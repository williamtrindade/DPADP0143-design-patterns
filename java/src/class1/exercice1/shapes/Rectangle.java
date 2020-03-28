package class1.exercice1.shapes;

import class1.exercice1.shapes.contracts.ShapeInterface;

public class Rectangle implements ShapeInterface {
    private Double base;
    private Double height;

    public Rectangle(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public Double getArea() {
        return this.base * this.height;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }
}
