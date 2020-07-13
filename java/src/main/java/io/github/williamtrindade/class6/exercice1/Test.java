package io.github.williamtrindade.class6.exercice1;

import io.github.williamtrindade.class6.exercice1.shapes.Circle;
import io.github.williamtrindade.class6.exercice1.shapes.Square;
import io.github.williamtrindade.class6.exercice1.shapes.contracts.I2DShape;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        I2DShape circle = new Circle(10.0);
        I2DShape square = new Square(2.0);
        List<I2DShape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(square);

        Room room1 = new Room("Quarto", shapes, 10.0);
        Room kitchen = new Room("Cozinha", shapes, 10.0);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(kitchen);

        Property property = new Property(
                rooms, "Ap. em MV CA", "Mark Zuck", "Facebook street", Property.Type.RESIDENTIAL
        );

        System.out.println("Peças do imovel");
        for (Room room: property.getRooms()) {
            System.out.println("I: " + room.getIdentification() + " V: " + room.getVolume() + "\n");
        }

        System.out.println("Imovel -> Volume: " + property.getVolume() + "\n" + "Area: " + property.getArea());
    }
}
