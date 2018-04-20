package Homework.LevelOne.LessonFive;

public class Bird extends Animal {

    public Bird(String name, String color, int birth, int price) {
        super(name, color, birth, price);
    }

    @Override
    public void swim(int value) {
        System.out.println(this.getName() + " не умеет плавать!");
    }

    @Override
    public void run(int value) {
        if (value >= 0 && value <= 5) System.out.println(this.getName() + " пробежал " + value + " м!");
        else System.out.println(this.getName() + " не может пробежать такую дистанцию!");
    }

    @Override
    protected void jump(float value) {
        if (value >= 0.0f && value <= 0.2f) System.out.println(this.getName() + " прыгнул на " + value + " м!");
        else System.out.println(this.getName() + " не может прыгнуть на такую высоту!");
    }
}
