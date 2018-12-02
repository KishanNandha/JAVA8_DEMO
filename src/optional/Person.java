package optional;

import java.util.Optional;

public class Person {
    private int id;
    private String name;
    private int age;
    //private Car car;
    private Optional<Car> car;

    public Person() {
    }

    public Person(int id, String name, int age, Optional<Car> car) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
