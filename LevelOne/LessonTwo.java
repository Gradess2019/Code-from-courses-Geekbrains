package Homework.LevelOne;

import java.util.Arrays;
import java.util.Scanner;

public class LessonTwo {
    public static void main(String[] args) {

//        1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
//                Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;

        int[] arrayOne = {1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0};
        System.out.println("1. Normal array: " + (Arrays.toString(arrayOne)) + "\nModified array: "
                + (Arrays.toString(replacementDigits(arrayOne))));

//        2 Задать пустой целочисленный массив размером 8. Написать метод,
//                который помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;

        int[] arrayTwo = new int[8];
        System.out.println("2. Result array: " + Arrays.toString(fillArray(arrayTwo, 3)));

//        3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,
//                принимающий на вход массив и умножающий числа меньше 6 на 2;

        int[] arrayThree = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("3. Normal array: " + (Arrays.toString(arrayThree)) + "\nModified array: "
                + (Arrays.toString(increaseNumbers(arrayThree))));

//        4 Задать одномерный массив. Написать методы поиска
//                в нём минимального и максимального элемента;
        Scanner scanner = new Scanner(System.in);
        System.out.print("4. Input array size: ");
        int size = scanner.nextInt();
        int[] arrayFour = new int[size];
        System.out.print("Input numbers for array: ");
        for (int i = 0; i < arrayFour.length; i++) arrayFour[i] = scanner.nextInt();
        System.out.println("Minimum number: " + minNumber(arrayFour) + "\nMaximum number: " + maxNumber(arrayFour));

//        5 * Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
//                заполнить его диагональные элементы единицами, используя цикл(ы);
        System.out.print("5. Input array size: ");
        size = scanner.nextInt();
        int[][] arrayFive = new int[size][size];
        fillArray(arrayFive);
        System.out.println("Result arrray: ");
        for (int i = 0; i < arrayFive.length; i++) {
            System.out.println(Arrays.toString(arrayFive[i]));
        }

//        6 ** Написать метод, в который передается не пустой одномерный целочисленный массив,
//                метод должен вернуть true если в массиве есть место, в котором сумма левой и правой части массива равны.
//                Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
//                checkBalance ([10, || 1, 2, 3, 4]) → true. Абстрактная граница показана символами ||,
//                эти символы в массив не входят.
        System.out.print("6. Input array size: ");
        size = scanner.nextInt();
        int[] arraySix = new int[size];
        System.out.print("Input numbers for array: ");
        for (int i = 0; i < size; i++) arraySix[i] = scanner.nextInt();
        System.out.println("Result: checkBalance = " + checkBalance(arraySix));
    }

    private static int[] replacementDigits(int[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i] = (arr[i] == 0) ? 1 : 0;
        return arr;
    }

    private static int[] fillArray(int[] arr, int increaseNumber) {
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) arr[i] = arr[i - 1] + increaseNumber;
        return arr;
    }

    private static int[] increaseNumbers(int[] arr) {
        for (int i = 0; i < arr.length; i++) arr[i] = (arr[i] < 6) ? arr[i] * 2 : arr[i];
        return arr;
    }

    private static int minNumber(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) min = (arr[i] < min) ? arr[i] : min;
        return min;
    }

    private static int maxNumber(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) max = (arr[i] > max) ? arr[i] : max;
        return max;
    }

    private static int[][] fillArray(int[][] arr) {
        int fillIndex = arr.length - 1;
        for (int i = 0; i < arr.length; i++, fillIndex--)
            for (int j = 0; j < arr.length - i; j++) arr[i][j] = (j == fillIndex) ? 1 : 0;
        return arr;
    }

    private static boolean checkBalance(int[] arr) {
        int sumLeft = arr[0], sumRight = 0;
        for (int i = 1; i < arr.length; i++, sumRight = 0) {
            for (int j = i; j < arr.length; j++) sumRight += arr[j];
            if (sumLeft == sumRight) return true;
            sumLeft += arr[i];
        }
        return false;
    }
}
