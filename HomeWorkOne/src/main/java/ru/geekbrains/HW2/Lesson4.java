package ru.geekbrains.HW2;

import java.util.Random;
import java.util.Scanner;

/**
 * Created by geekbrains on 11/3/20
 */
public class Lesson4 {

    // Переменные - параметры игры
    public static int SIZE = 3;
    public static int DOTS_TO_WIN = 3;
    public static final int LINE_LIMIT = 15;

    // Константы • X O
    public static final char DOT_EMPTY = '•';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';

    // Переменные - игровое поле, работа с клавиатурой, случайные числа
    public static char[][] map;
    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    // Основной метод
    public static void main(String[] args) {

        //Запрос у игрока размера поля и количества выиграшных фишек.
        setGameLevel();
        System.out.println(SIZE + " " + DOTS_TO_WIN);
        // Инициализация игрового поля


        // Вывод игрового поля


        // Главный игровой цикл

            // Ход игрока

            // Печать игрового поля

            // Проверка победителя

            // Проверка полностью заполненного поля

            // Ход ИИ

            // Вывод игрового поля

            // Проверка победителя

            // Проверка заполненности карты



        // Игра закончена


        // Закрываем консоль
        scanner.close();
    }

    private static void setGameLevel() {// Метод установки размера поля и длинны выиграшной комбинации
        switch (getNumberFromScanner("Введите размер поля\n1 - 3 X 3\n2 - 5 X 5\n3 - 10 x 10", 1,3)){
            case 1: SIZE = 3;
                    break;
            case 2: SIZE = 5;
                    break;
            default: SIZE = 10;
                    break;
        }

        boolean wrong = false;

    do {
        if(wrong) System.out.println("Количество фишек должнго быть больше 3 и меньше размера поля"); //
        DOTS_TO_WIN = getNumberFromScanner("Введите длинну фишек для победы от 3 до " + SIZE, 3, 10);
        wrong = true;//если введено неправильное значение установить флаг ошибки
    } while (DOTS_TO_WIN > SIZE);//Проверка соответствия размера поля и длинны выиграшной комбинации
    }

    public static int getNumberFromScanner(String message, int min, int max) {// запрашивает у пользователя число в заданных пределах
        int x;
        do {
            System.out.println(message);
            x = scanner.nextInt();
        } while (x < min || x > max);
        return x;
    }

   /* private static boolean mapIsFull() {
    return false;
    }

    private static boolean checkWin(char symbol) {
        // Первая строка


        // Вторая строка


        // Третья строка


        // Первый столбец


        // Первый столбец


        // третий столбец


        // 1 Диагональ


        // 2 Диагональ


        return false;
    }

    private static void aiTurn() {

    }

    /**
     * Предоставляем ход игроку
     */
    /*private static void humanTurn() {

    }

    private static boolean isCellValid(int x, int y) {
        return false;
    }

    private static void printMap() {
        // Сделали отступ


        // Верхняя "Легенда"


        // Выводим игровое поле

        // Дополнительный отступ

    }

    private static void initMap() {

    }*/

}