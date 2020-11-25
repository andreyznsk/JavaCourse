package ru.JavaLevel2.lesson1;

public class Robot implements Models {
    private String name;
    private int MAX_RUN = 100;
    private int MAX_JUMP = 1;

    public Robot(String name) {
        this.name = name;
    }

    public void run(int let) {
        if (let < MAX_RUN) System.out.println("Робот пробежал");
        else System.out.println("Препядствие не пройдено");
    }

    public void jump(int let){
        if (let < MAX_RUN) System.out.println("Робот перепрыгнул");
        else System.out.println("Препядствие не пройдено");
    }
}
