package class1.exercice1.shapes;

import class1.exercice1.shapes.contracts.ShapeInterface;

public class Rhombus implements ShapeInterface {
    private Double height;
    private Double length;

    public Rhombus(Double height, Double length) {
        this.height = height;
        this.length = length;
    }

    public Double getLength() {
        return length;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    @Override
    public Double getArea() {
        return (this.getHeight() * this.getLength()) / 2;
    }
}
