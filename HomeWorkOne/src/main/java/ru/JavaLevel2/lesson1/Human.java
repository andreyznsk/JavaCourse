package ru.JavaLevel2.lesson1;

public class Human implements ModelArray {
    private String name;
    private int MaxRun = 10;
    private int MaxJump = 10;

    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.MaxJump = maxJump;
        this.MaxRun = maxRun;

    }
    @Override
    public boolean run(int let) {
        if (let < MaxRun) {
            System.out.printf("Человек по имени %s пробежал по дрожке\n",name);
            return true;
        }
        else {
            System.out.println("Челоек не справился с препядствием: дорожка");
            return false;
        }
    }
    @Override
    public boolean jump(int let){
        if (let < MaxJump) {
            System.out.printf("Человек по имени %s перепрыгнул стену\n",name);
            return true;
        }
        else {
            System.out.println("Члоек не справился с препядствием: стена");
            return false;
        }
    }
}