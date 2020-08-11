package io.github.williamtrindade.unity2.class6.exercice1.shapes;

import io.github.williamtrindade.unity2.class6.exercice1.shapes.contracts.I2DShape;

public class Triangle implements I2DShape {
    private Double base;
    private Double height;

    public Triangle(Double base, Double height) {
        this.base = base;
        this.height = height;
    }

    @Override
    public Double getArea() {
        return (base * height) / 2;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getBase() {
        return base;
    }

    public void setBase(Double base) {
        this.base = base;
    }
}
