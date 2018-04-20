package Homework.LevelOne;

public class LessonOne {
    public static void main(String[] args) {
        System.out.println("===================");

        System.out.println(math(10, 1, 5, 3));
        System.out.println(math(5, 3, 17, 13));

        System.out.println("===================");

        System.out.println(compareSum(10, 1));
        System.out.println(compareSum(15, 12));

        System.out.println("===================");

        compareNumber(10);
        compareNumber(0);
        compareNumber(-10);

        System.out.println("===================");

        System.out.println(greeting("Степан"));
        System.out.println(greeting("Иван"));

        System.out.println("===================");

        leapYear(20);
        leapYear(400);
        leapYear(100);
        leapYear(47);

        System.out.println("===================");
    }

//    Написать метод вычисляющий выражение a * (b + (c / d)) и
//    возвращающий результат с плавающей точкой, где a, b, c, d –
//    целочисленные входные параметры этого метода;
    private static double math(int a, int b, int c, int d) {
        return a * (b + ((double) c / d));
    }

//    Написать метод, принимающий на вход два целых числа,
//    и проверяющий что их   сумма лежит в пределах от 10 до 20(включительно),
//    если да – вернуть true, в противном случае – false;
    private static boolean compareSum(int firstNumber, int secondNumber) {
        int sum = firstNumber + secondNumber;
        if (10 <= sum && sum <= 20)
        {
            return true;
        } else {
            return false;
        }
    }

//    Написать метод, которому в качестве параметра передается целое число,
//    метод должен проверить положительное ли число передали, или отрицательное.
//    Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль
    private static void compareNumber(int number) {
        if (number < 0) {
            System.out.println("Число отрицательное!");
        } else {
            System.out.println("Число положительное!");
        }
    }

//    Написать метод, которому в качестве параметра передается строка, обозначающая имя,
//    метод должен вернуть приветственное сообщение «Привет, переданное_имя!»;
//    Вывести приветствие в консоль.
    private static String greeting(String name){
        return "Привет, " + name + "!";
    }

//    * Написать метод, который определяет является ли год високосным.
//    Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
//    Для проверки работы вывести результаты  работы метода в консоль
    private static void leapYear(int year) {
        if (year < 0) {
            System.out.println("Значение года не может быть отрицательным!");
            return;
        }
        if (((year % 4) == 0 && (year % 100) != 0) || (year % 400) == 0) {
            System.out.println("Год високосный");
        } else {
            System.out.println("Год не високосный");
        }
    }
}
