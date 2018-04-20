package Homework.LevelOne.LessonFive;

public class Dog extends Animal {

    public Dog(String name, String color, int birth, int price) {
        super(name, color, birth, price);
    }

    public void swim(int value) {
        if (value >= 0 && value <= 10) System.out.println(this.getName() + " проплыл " + value + " м!");
        else System.out.println(this.getName() + " не может проплыть такую дистанцию!");
    }

    @Override
    public void run(int value) {
        if (value >= 0 && value <= 500) System.out.println(this.getName() + " пробежал " + value + " м!");
        else System.out.println(this.getName() + " не может пробежать такую дистанцию!");
    }

    @Override
    protected void jump(float value) {
        if (value >= 0.0f && value <= 0.5f) System.out.println(this.getName() + " прыгнул на " + value + " м!");
        else System.out.println(this.getName() + " не может прыгнуть на такую высоту!");
    }
}
