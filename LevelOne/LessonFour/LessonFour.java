package Homework.LevelOne.LessonFour;

public class LessonFour {
    private static float averageAge = 0.0f, averageSalary = 0.0f;
    public static void main(String[] args) {
        Employee employee1 = new Employee("Steven Paul Jobs", "CEO", "8(800)555-35-35", 99999999, 55);
        System.out.println("Full name: " + employee1.getFullName() + "\nPosition: " + employee1.getPosition());

        Employee[] employees = new Employee[5];
        employees[0] = new Employee("William Henry Gates", "CEO of Microsoft", "+1(345)223-23-23", 25000, 62);
        employees[1] = new Employee("Mark Elliot Zuckerberg", "CEO of Facebook Inc.", "+1(123)123-56-56", 20000, 33);
        employees[2] = new Employee("Elon Reeve Musk", "CEO CEO CEO", "+1(987)521-61-32", 22500, 46);
        employees[3] = new Employee("John O’Sullivan", "Engineer", "+1(345)223-42-23", 5000, 65);
        employees[4] = new Employee("Lawrence Joseph Ellison", "Also CEO", "+9999(345)421-23-23", 50000, 73);

        for (int i = 0; i < employees.length; i++)
            System.out.println("Full name: " + employees[i].getFullName() +
                    " => Position: " + employees[i].getPosition());

        System.out.println("===============================");
        for (int i = 0; i < employees.length; i++)
            System.out.println("Full name: " + employees[i].getFullName() +
                    " => Salary before: " + employees[i].getSalary());
        raiseSalary(employees);
        System.out.println();
        for (int i = 0; i < employees.length; i++)
            System.out.println("Full name: " + employees[i].getFullName() +
                    " => Salary after: " + employees[i].getSalary());
        System.out.println("===============================");


        getAverageValue(employees, averageAge, averageSalary);
        System.out.println("Average age: " + averageAge + "\nAverage salary: " + averageSalary);
    }

    private static void raiseSalary(Employee[] arr) {
        for (int i = 0; i < arr.length; i++) if (arr[i].getAge() > 45) arr[i].setSalary(arr[i].getSalary() + 5000);
    }

    private static void getAverageValue(Employee[] arr, float averageAge, float averageSalary) {
        for (int i = 0; i < arr.length; i++) {
            averageAge += arr[i].getAge();
            averageSalary += arr[i].getSalary();
        }
        LessonFour.averageAge = averageAge / arr.length;
        LessonFour.averageSalary = averageSalary / arr.length;
    }
}