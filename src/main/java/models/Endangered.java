package models;

public class Endangered{

    private int age;
    private String health;

    public Endangered(int id, String name, int age, String health) {
        super(id, name);
        this.age = age;
        this.health = health;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }
}