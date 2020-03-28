package class1.exercice1.shapes;

import class1.exercice1.shapes.contracts.ShapeInterface;

public class Circle implements ShapeInterface {

    private Double radius;
    
    private Double angle;

    Circle(Double radius) {
        this.radius = radius;
        this.angle = 360.0;
    }

    Circle(Double radius, Double angle) {
       this.radius = radius;
       this.angle = angle;
    }

    @Override
    public Double getArea() {
        return (3.14 * (Math.pow(this.getRadius(), 2.0)) * this.getAngle()) / 360.0;
    }
    
    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    public Double getAngle() {
        return angle;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }
}
