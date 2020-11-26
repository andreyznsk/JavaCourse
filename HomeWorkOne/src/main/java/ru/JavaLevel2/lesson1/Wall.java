package ru.JavaLevel2.lesson1;

public class Wall implements Obstacle {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public int getLet() {
        return height;
    }
}
