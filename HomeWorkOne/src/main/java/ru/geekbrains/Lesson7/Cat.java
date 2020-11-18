package ru.geekbrains.Lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety; // Поле сытость

    public Cat(){
        this.name = "Unknown";
        this.appetite = 0;
        this.satiety = false;// По умлочанию Кот голодный
    }


    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = false;// По умлочанию Кот голодный
    }
    public void eat(Plate p) {
       if(this.satiety) {
           System.out.println("Кот не стал есть, он сытый");
           return;
       }
        if(p.decreaseFood(appetite)) {
           this.satiety = true;
           System.out.println("Кот поел");
       }
       else {
           System.out.print("Не хватает еды, кот не поел! У него аппетит: " + this.appetite);
            System.out.println(" ,а тарелке осталось: " + p.getFood());
       }


    }

    public void printInfo() {
        System.out.print("У кота по имени " + this.name + " Апетит: " + this.appetite);
        if(this.satiety) System.out.println("  Кот сытый!");
        else System.out.println("  Кот голодный!");

    }

    public boolean isSatiety() {
        return satiety;
    }
}

