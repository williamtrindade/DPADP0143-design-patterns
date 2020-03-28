package class1.exercice1.shapes;

import class1.exercice1.shapes.contracts.ShapeInterface;

public class Square implements ShapeInterface {
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


