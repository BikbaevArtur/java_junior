package ru.bikbaev.hw_2;


import java.util.UUID;

public class Cat extends Animal{
    private final UUID id;

    public Cat(String name, String age) {
        super(name, age);
        this.id = UUID.randomUUID();
    }

    public void sayMew(){
        System.out.println("Mew");
    }


    @Override
    public String toString() {
        return super.toString();
    }
}
