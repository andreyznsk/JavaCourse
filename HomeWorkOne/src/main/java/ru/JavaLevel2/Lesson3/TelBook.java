package ru.JavaLevel2.Lesson3;

import java.util.*;

public class TelBook {

    Map<Person, Set<Integer>> telBook = new TreeMap<>();

    public TelBook(){

    }

    public void add(String name, int tel){
       Person person = new Person(name);
       if(!telBook.containsKey(person)) telBook.put(person,new HashSet<>());
       telBook.get(person).add(tel);
    }

    public void printAll(){
        if (telBook.isEmpty()) System.out.println("Справочник пуст");
        for (Map.Entry<Person, Set<Integer>> o : telBook.entrySet()) {

            System.out.println(o.getKey() + ": " + o.getValue());

        }
    }

    public void get(String name){

        if (!telBook.containsKey(new Person(name))) System.out.println("Такого имени нет");
        for (Map.Entry<Person, Set<Integer>> o : telBook.entrySet()) {
            if(name.equals(o.getKey().getName()))
            System.out.println(o.getKey() + ": " + o.getValue());

        }
    }
}

