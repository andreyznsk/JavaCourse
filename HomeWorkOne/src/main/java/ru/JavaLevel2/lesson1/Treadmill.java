package ru.JavaLevel2.lesson1;

public class Treadmill implements Obstacle{
    private int dist;

    public Treadmill(int dist) {
        this.dist = dist;
    }

    @Override
    public int getLet() {
        return dist;
    }
}