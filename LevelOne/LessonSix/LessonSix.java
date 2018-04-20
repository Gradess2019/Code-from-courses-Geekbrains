package Homework.LevelOne.LessonSix;

import java.io.*;
import java.util.Scanner;

public class LessonSix {
    public static void main(String[] args) {
        glueFiles("text1.txt", "text2.txt");
        String word = "постоянное";
        System.out.println("Word \"" + word +"\" was founded: "  + findWord("text1.txt", word));
    }

    //        Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
    //        Написать программу, «склеивающую» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
    private static void glueFiles(String firstFileName, String secondFileName) {
        try {
            PrintStream printStream = new PrintStream(new FileOutputStream(firstFileName, true));
            Scanner scanner = new Scanner(new FileInputStream(secondFileName));

            while (scanner.hasNext()) {
                printStream.println(scanner.nextLine());
            }
            printStream.flush();
            printStream.close();
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    //   * Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
    private static boolean findWord(String fileName, String word) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(fileName));
            while (scanner.hasNext()) {
                if (scanner.next().equals(word)) return true;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
