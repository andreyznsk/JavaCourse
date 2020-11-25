package ru.geekbrains.Lesson6;

public class Cat extends Animal {

    private boolean falagSwimig;

    public Cat(int age, String name){
        super(age,name);

        this.falagSwimig = false;
    }

    public void setFalagSwimig(boolean falagSwimig) {
        this.falagSwimig = falagSwimig;
    }

    //Переопредеяем методы для своего класса
    @Override
    public void run(double  let) {
        if (let >= 0 && let <= 200) super.run(let);
        else System.out.println(getType() + " не может выполнить команду Бег на " + let +" м");
    }

    @Override
    public String getType() {
        return "КОТ";
    }

    @Override
    public void swim(double  let) {
        if(!this.falagSwimig)
        System.out.println(getType() + " не умеет плавать!!");
        else if (let >= 0 && let <= 2) super.swim(let);
        else System.out.println(getType() + " может выполнить команду плыть, но не на: " + let +" м");
    }

    @Override
    public void jump(double  let) {
        if (let >= 0 && let <= 2) super.jump(let);
        else System.out.println(getType() + " не может выполнить команду Прыгуть на " + let +" м");
    }

}
