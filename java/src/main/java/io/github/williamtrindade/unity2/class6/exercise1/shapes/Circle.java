package io.github.williamtrindade.unity2.class6.exercise1.shapes;

import io.github.williamtrindade.unity2.class6.exercise1.shapes.contracts.I2DShape;

public class Circle implements I2DShape {

    private Double radius;
    
    private Double angle;

    public Circle(Double radius) {
        this.radius = radius;
        this.angle = 360.0;
    }

    public Circle(Double radius, Double angle) {
       this.radius = radius;
       this.angle = angle;
    }

    @Override
    public Double getArea() {
        return (this.getPI() * (Math.pow(this.getRadius(), 2.0)) * this.getAngle()) / 360.0;
    }

    /**
     * Utilização de Private methods
     * @return Double
     */
    private Double getPI() {
        // Utilização de Constant data manager no PI
        return Math.PI;
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
