package Homework.LevelOne.LessonFive;

public abstract class Animal {

    private String name;
    private String color;
    private int birth;
    private int price;

    protected Animal(String name, String color, int birth, int price) {
        this.name = name;
        this.color = color;
        this.birth = birth;
        this.price = price;
    }

    protected abstract void swim(int value);
    protected abstract void run(int value);
    protected abstract void jump(float value);

    public String getName() {
        return name;
    }
}
