package ru.JavaLevel2.lesson1;

public class Cat implements ModelArray {
    private String name;
    private int MaxRun;
    private int MaxJump;

    public Cat(String name, int MaxRun, int MaxJump) {

        this.name = name;
        this.MaxRun = MaxRun;
        this.MaxJump = MaxJump;
    }

    @Override
    public boolean run(int let) {
        if (let < MaxRun) {
            System.out.printf("Кот по имени %s пробежал по дрожке\n",name);
            return true;
        }
        else {
            System.out.println("Кто не справился с препядствием: дорожка");
            return false;
        }
    }
    @Override
    public boolean jump(int let){
        if (let < MaxJump) {
            System.out.printf("Кот по имени %s перепрыгнул стену\n",name);
            return true;
        }
        else {
            System.out.println("Кто не справился с препядствием: стена");
            return false;
        }
    }
}
