package io.github.williamtrindade.class6.exercice1.exercice1.shapes;

import io.github.williamtrindade.class6.exercice1.exercice1.shapes.contracts.I2DShape;

public class Square implements I2DShape {
    private Double side;

    public Square(Double side) {
        this.side = side;
    }

    public Double getSide() {
        return this.side;
    }

    public void setSide(Double side) {
        this.side = side;
    }

    @Override
    public Double getArea() {
        return this.getSide() * this.getSide();
    }
}


