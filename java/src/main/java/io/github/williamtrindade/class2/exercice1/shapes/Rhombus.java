package io.github.williamtrindade.class2.exercice1.shapes;

import io.github.williamtrindade.class2.exercice1.shapes.contracts.I2DShape;

public class Rhombus implements I2DShape {
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
