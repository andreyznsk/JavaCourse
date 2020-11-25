package ru.JavaLevel2.lesson1;

public class Human implements Models {
    private String name;
    private int MAX_RUN = 10;
    private int MAX_JUMP = 10;

    public Human(String name) {
        this.name = name;
    }

    public void run(int let) {
        if (let < MAX_RUN) System.out.printf("Человек по имени %s пробежал", name);
        else System.out.println("Препядствие не пройдено");
    }

    public void jump(int let){
        if (let < MAX_RUN) System.out.printf("Человек по имени %s пробежал", name);
        else System.out.println("Препядствие не пройдено");
    }
}