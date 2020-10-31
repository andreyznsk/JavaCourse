package ru.geekbrains.HW2;

import org.omg.PortableInterceptor.ServerRequestInfo;

import java.util.Random;

public class Lession3 {


    public static void printArry(int[] array){
        for (int j : array) {
            System.out.print(j + " ");
        }
        System.out.println();
    }

    public static void print2dArr(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            int[] a = matrix[i];
            printArry(a);
        }
    }

    public static int sumarry(int[] a){
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
                    sum+=a[i];
        }
        return sum;
    }

    public static void printData(int age, String name, double avag) {
        System.out.printf("Age: %5d, Name: %1s, Avage: %1f\n", age, name, avag);

    }

    public static void StringEquality(String string) {

    }


    public static void main(String[] args) {
        /*int[] arry = {1,2,3,4,6,56};
        int[][] array2d = {{1,3,4,5,},{4,5,6,7},{8,9,10,11}};
        printArry(arry);
        print2dArr(array2d);
        System.out.println("Сумма массива = " + sumarry(arry));*/
        // Генератор случайных чисел
        /*Random random = new Random();
        for (int i = 0; i < 50; i++) {
            int randInt = random.nextInt(10);// Присвает рандомное число в диапазоне от 0 до 10
            System.out.println("Следующий значение:" + randInt);
        }*/
        printData(36, "Andreyz", 34.123);
        String myName = "Andreyz";
        String myName2 = "Andreyz";
        System.out.println(myName.equals(myName2));


    }

}
