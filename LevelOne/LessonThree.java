package Homework.LevelOne;

import java.util.Random;
import java.util.Scanner;
public class LessonThree {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final Random RANDOM = new Random();
    private static final char HUMAN_DOT = 'X';
    private static final char AI_DOT = 'O';
    private static final char EMPTY_DOT = '_';
    private static int fieldSizeY;
    private static int fieldSizeX;
    private static char[][] field;
    private static int numOfChipsForWin;//Число фишек для выигрывша

    private static void initField() {
        do {
            System.out.print("Введите размер поля Х и Y (от 3 ячеек каждое) через пробел >>> ");
            fieldSizeX = SCANNER.nextInt();
            fieldSizeY = SCANNER.nextInt();
        } while (fieldSizeX < 3 || fieldSizeY < 3);

        do {
            System.out.print("Введите число фишек для победы >>> ");
            numOfChipsForWin = SCANNER.nextInt();
        } while (numOfChipsForWin > fieldSizeX && numOfChipsForWin > fieldSizeY);


        field = new char[fieldSizeY][fieldSizeX];
        for (int y = 0; y < fieldSizeY; y++)
            for (int x = 0; x < fieldSizeX; x++)
                field[y][x] = EMPTY_DOT;
    }

    private static void printField() {
        System.out.print(' ');
        for (int i = 0; i < fieldSizeY; i++) System.out.print("_x");
        System.out.println('_');
        for (int y = 0; y < fieldSizeY; y++) {
            System.out.print("y|");
            for (int x = 0; x < fieldSizeX; x++)
                System.out.print(field[y][x] + "|");
            System.out.println();
        }
    }

    private static void humanTurn() {
        int x, y;
        do {
            System.out.print("Введите координаты Х и Y (1 до 3) через пробел >>> ");
            x = SCANNER.nextInt() - 1;
            y = SCANNER.nextInt() - 1;
        } while (!isEmptyCell(x, y) || !isValidCell(x, y));
        field[y][x] = HUMAN_DOT;
    }

    private static boolean isValidCell(int x, int y) {
        return x >= 0 && x < fieldSizeX && y >= 0 && y < fieldSizeY;
    }

    private static boolean isEmptyCell(int x, int y) {
        return field[y][x] == EMPTY_DOT;
    }

    private static void aiTurn() {
        int x, y;
        do {
            x = RANDOM.nextInt(fieldSizeX);
            y = RANDOM.nextInt(fieldSizeY);
        } while (!isEmptyCell(x, y));
        field[y][x] = AI_DOT;
    }

//        1. Переделать проверку победы, чтобы она не была реализована просто набором условий.
//        2. * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и количества фишек 4.
    private static boolean checkWin(char c) {
        int numOfChips;
        for (int y = 0; y < fieldSizeY; y++) {
            numOfChips = 0;
            for (int x = 0; x < fieldSizeX; x++) {

                for (int i = 0; i < fieldSizeX; i++) { //Проходим по X
                    if ((x + i) < fieldSizeX && field[y][x + i] == c) {
                        numOfChips++;
                        if (isEnoughChips(numOfChips)) return true;
                    } else break;
                }
                numOfChips = 0;

                for (int i = 0; i < fieldSizeY; i++) {//Проходим по Y
                    if ((y + i) < fieldSizeY && field[y + i][x] == c) {
                        numOfChips++;
                        if (isEnoughChips(numOfChips)) return true;
                    } else break;
                }
                numOfChips = 0;

                for (int i = 0; i < fieldSizeY && i < fieldSizeX; i++) { //Проходим по диагоналям
                    if ((y + i) < fieldSizeY && (x + i) < fieldSizeX && field[y + i][x + i] == c) {
                        numOfChips++;
                        if (isEnoughChips(numOfChips)) return true;
                    } else if ((y + i) < fieldSizeY && (x - i) > 0 && field[y + i][x - i] == c) {
                        numOfChips++;
                        if (isEnoughChips(numOfChips)) return true;
                    }  else break;
                }
                numOfChips = 0;
            }
        }

        return false;
    }

    private static boolean isEnoughChips(int numOfChips) {
        return numOfChips >= numOfChipsForWin;
    }

    private static boolean isFieldFull() {
        for (int y = 0; y < fieldSizeY; y++) {
            for (int x = 0; x < fieldSizeX; x++) {
                if (field[y][x] == EMPTY_DOT)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        initField();
        printField();

        while (true) {
            humanTurn();
            printField();
            if (checkWin(HUMAN_DOT)) {
                System.out.println("Выиграл Игрок!");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            System.out.println("Ход Кампухтера: ");
            printField();
            if (checkWin(AI_DOT)) {
                System.out.println("Выиграл Кампухтер");
                break;
            }
            if (isFieldFull()) {
                System.out.println("Ничья");
                break;
            }

        }
    }

}