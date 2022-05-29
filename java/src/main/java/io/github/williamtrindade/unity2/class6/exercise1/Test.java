package io.github.williamtrindade.unity2.class6.exercise1;

import io.github.williamtrindade.unity2.class6.exercise1.shapes.Circle;
import io.github.williamtrindade.unity2.class6.exercise1.shapes.Square;
import io.github.williamtrindade.unity2.class6.exercise1.shapes.contracts.I2DShape;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementação do seguintes padrões de projeto básicos:
 * - Private Methods:
 * see Circle.getPI()
 * - Interface:
 * see I2DShape
 */
public class Test {
    private static void makeTest(Double radius, Double side, Double roomRightFoot, Double kitchenRightFoot) {
        I2DShape circle = new Circle(radius);
        I2DShape square = new Square(side);

        List<I2DShape> shapes = new ArrayList<>();
        shapes.add(circle);
        shapes.add(square);

        Room room1 = new Room("Quarto", shapes, roomRightFoot);
        Room kitchen = new Room("Cozinha", shapes, kitchenRightFoot);
        List<Room> rooms = new ArrayList<>();
        rooms.add(room1);
        rooms.add(kitchen);

        Property property = new Property(
                rooms,
                "Ap. em MV CA",
                "Mark Zuck",
                "Facebook street",
                Property.Type.RESIDENTIAL
        );

        System.out.println("Peças do imovel");
        for (Room room: property.getRooms()) {
            System.out.println("I: " + room.getIdentification() + " V: " + room.getVolume() + "\n");
        }

        System.out.println("Imovel -> Volume: " + property.getVolume() + "\n" + "Area: " + property.getArea());
    }

    public static void main(String[] args) {
        makeTest(10.0, 11.5, 10.1, 11.0);
    }
}
