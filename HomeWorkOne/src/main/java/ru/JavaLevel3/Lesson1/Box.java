package ru.JavaLevel3.Lesson1;

import java.util.ArrayList;

public class Box <T extends Fruit> {
    private ArrayList<T> box;

    public Box(){
        box = new ArrayList<>();
    }

    public void addFruit(Fruit a){
        box.add((T) a);
    }

    public float getWeight (){
        if(this.box == null)
            return 0;


       // System.out.println("Вес одного фрукта в коробке: " + box.get(0).getWEIGHT());
        return  box.size() * box.get(0).getWEIGHT() ;
    }

    public boolean compare (Box<?> second){
        if(Math.abs(this.getWeight() - second.getWeight()) < 0.0001) return true;
        else return false;
    }

    public void intersperse(Box<T> source){

        for (int i = 0; i < source.box.size(); i++) {
            this.addFruit(source.box.get(i));
        }

        source.box = null;

    }


}
