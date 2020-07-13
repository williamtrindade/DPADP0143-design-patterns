package io.github.williamtrindade.class6.exercice1;

import io.github.williamtrindade.class6.exercice1.shapes.contracts.I2DShape;
import io.github.williamtrindade.class6.exercice1.shapes.contracts.I3DShape;

import java.util.List;

public class Room implements I3DShape, I2DShape {
    private String identification;
    private List<I2DShape> shapes;
    private Double rightFoot;

    public Room(String identification, List<I2DShape> shapes, Double rightFoot) {
        this.identification = identification;
        this.shapes = shapes;
        this.rightFoot = rightFoot;
    }

    public List<I2DShape> getShapes() {
        return shapes;
    }

    public void setShapes(List<I2DShape> shapes) {
        this.shapes = shapes;
    }

    public Double getRightFoot() {
        return rightFoot;
    }

    public void setRightFoot(Double rightFoot) {
        this.rightFoot = rightFoot;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    @Override
    public Double getVolume() {
        double volume = 0.0;
        for (I2DShape shape : this.shapes) volume += shape.getArea() * this.rightFoot;
        return volume;
    }

    @Override
    public Double getArea() {
        double area = 0.0;
        for (I2DShape shape : this.shapes) area += shape.getArea();
        return area;
    }
}
