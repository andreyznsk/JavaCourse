package ru.JavaLevel2.lesson1;

public class Robot implements ModelArray {
    private String name;
    private int MaxRun = 100;
    private int MaxJump = 1;

    public Robot(String name, int MaxRun, int MaxJump) {
        this.name = name;
        this.MaxJump = MaxJump;
        this.MaxRun = MaxRun;
    }


    @Override
    public boolean run(int let) {
        if (let < MaxRun) {
            System.out.printf("Робот по имени %s пробежал по дрожке\n",name);
            return true;
        }
        else {
            System.out.println("Робот не справился с препядчтвием: дорожка");
            return false;
        }
    }
    @Override
    public boolean jump(int let){
        if (let < MaxJump) {
            System.out.printf("Робот по имени %s перепрыгнул стену\n",name);
            return true;
        }
        else {
            System.out.println("Робот не справился с препядчтвием: стена");
            return false;
        }
    }
}
