package io.github.williamtrindade.unity2.class6.exercise1;

import io.github.williamtrindade.unity2.class6.exercise1.shapes.contracts.I2DShape;
import io.github.williamtrindade.unity2.class6.exercise1.shapes.contracts.I3DShape;

import java.util.List;

public class Property implements I2DShape, I3DShape {
    private List<Room> rooms;
    private String identification;
    private String owner;
    private String address;
    private Type type;

    public Property(List<Room> rooms, String identification, String owner, String address, Type type) {
        this.rooms = rooms;
        this.identification = identification;
        this.owner = owner;
        this.address = address;
        this.type = type;
    }

    /**
     * Aplicação de Accessor Methods
     * @return List<Room>
     */
    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public Double getArea() {
        Double area = 0.0;
        for (Room room: this.rooms) {
            area += room.getArea();
        }
        return area;
    }

    @Override
    public Double getVolume() {
        Double volume = 0.0;
        for (Room room: this.rooms) {
            volume += room.getVolume();
        }
        return volume;
    }

    public enum Type {
        COMMERCIAL("Commercial"), RESIDENTIAL("Residential");
        private String type;
        Type(String type) {
            this.type = type;
        }
        public String getType() {
            return type;
        }
    }
}