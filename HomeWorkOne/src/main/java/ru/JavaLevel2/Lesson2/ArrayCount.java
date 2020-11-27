package ru.JavaLevel2.Lesson2;

import java.util.Arrays;

public class ArrayCount {

    private static final int SIZE = 4;//Жесткая длинна в соотвествии с заданием

   public static int arrCount(String[][] s) throws RuntimeException{ //Метод подсчтеа массива
    if(s.length!=SIZE) throw new MyArraySizeException(s.length);//выброс исключения по длинне 1 уровня
    for (String[] strings : s) if (strings.length != SIZE) throw new MyArraySizeException(s.length);//выброс исключения по длинне второго уровня
    for (int i = 0; i < SIZE; i++) //Двойной цикл проверки числовых значений в массиве
        for (int j = 0; j < SIZE; j++)
            try {
                Integer.parseInt(s[i][j]);
            } catch(NumberFormatException e) {
                s[i][j] = "0";//Принудительное исправление ошибки
                System.err.println("Принудительно заменяем элемент: " + i + ',' + j + " на 0");
                System.err.println("Исключительная сумма без String = "  + arrCount(s));//Рекурсивный вызов метода для подсчеты суммы с ошибкой
                throw new MyArrayDataException(i,j);//выброс ошибки с информацией по последнему элементу
            }

    int summ = 0;//Стандартная реализация, если ошибок нет
    for (int i = 0; i < SIZE; i++) {
        for (int j = 0; j < SIZE; j++) {
            summ += Integer.parseInt(s[i][j]);

        }
    }
    return summ;
}

public static void printStringArray(String[][] s) throws MyArraySizeException {
    if(s.length!=SIZE) throw new MyArraySizeException(s.length);
    for (String[] strings : s) if (strings.length != SIZE) throw new MyArraySizeException(s.length);

    System.out.println();
    System.out.print("  ");

    // Верхняя "Легенда"
    for (int i = 0; i < SIZE; i++) {
        System.out.printf("%2d", i);
    }
    System.out.println();

    for (int i = 0; i < SIZE; i++) {
        System.out.printf("%2d ",(i));
        for (int j = 0; j < SIZE; j++) {
            System.out.print(s[i][j] + " ");
        }
        System.out.println();
    }

    // Дополнительный отступ
    System.out.println();
}


    public static void main(String[] args) {
        String[][] smallStringArray = new String[2][2];//Массив меньшего размера
        try {
            printStringArray(smallStringArray);
            } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        }

        String[][] string = new String[SIZE][SIZE];//Не числовой массив
        for (int i = 0; i < SIZE; i++) {
            //string[i][j] = Integer.toString(random.nextInt(100));
            Arrays.fill(string[i], "1");
        }
        string[3][1] = "a";
        string[2][1] = "a";

        try {
            printStringArray(string);
            System.out.println("Сумма массива = " + arrCount(string));
        } catch (MyArraySizeException e){
            System.err.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
        System.out.println("Еще раз Считаем сумму массива без исключений:");
        try {
            printStringArray(string);
            } catch (MyArraySizeException e) {
            System.err.println(e.getMessage());
        }

        try {
             System.out.println("Сумма массива = " + arrCount(string));
        } catch (MyArraySizeException e){
            System.err.println(e.getMessage());
        } catch (MyArrayDataException e) {
            System.err.println(e.getMessage());
        }
   }

}
