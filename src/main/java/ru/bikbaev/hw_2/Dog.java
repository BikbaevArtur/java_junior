package ru.bikbaev.hw_2;

import java.util.UUID;

public class Dog extends Animal {
    private final UUID id;

    public Dog(String name, String age) {
        super(name, age);
        this.id = UUID.randomUUID();
    }

    public void makeSound(){
        System.out.println("Gav");
    }

    @Override
    public String toString() {
        return super.toString();
    }
}


