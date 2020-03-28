package class1.exercice1.shapes;

import class1.exercice1.shapes.contracts.I2DShape;

public class Square implements I2DShape {
    private Double side;

    Square(Double side) {
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


