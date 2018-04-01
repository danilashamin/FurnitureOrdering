package ru.mail.danilashamin.furnitureordering.mvp.model;

public class Furniture {
    private FurnitureType type;
    private int ID;

    public Furniture(FurnitureType type, int ID) {
        this.type = type;
        this.ID = ID;
    }

    public FurnitureType getType() {
        return type;
    }

    public int getID() {
        return ID;
    }
}
