package ru.bikbaev.hw_2;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InvocationTargetException {
        Animal cat1 = new Cat("Барсилион", "5");
        Cat cat2 = new Cat("Мышелов", "2");
        Cat cat3 = new Cat("Крысохват", "6");
        Dog dog1 = new Dog("Волкогрыз", "8");
        Dog dog2 = new Dog("Овцепас", "3");
        Dog dog3 = new Dog("Сурколов", "1");


        Animal[] animals = {cat1,cat2,cat3,dog1,dog2,dog3};

        for(Animal animal : animals){
            info(animal);
        }



    }

//    public static  void  info(Object obj){
//
//        Class<?>  animalClass = obj.getClass().getSuperclass();
//        Field[]fieldsAnimal = animalClass.getDeclaredFields();
//
//        Class<?>  extendAnimalClass = obj.getClass();
//        for (Field field : fieldsAnimal){
//            System.out.print(" ");
//            System.out.println(field.getName());
//        }
//    }

    public static void info(Object o) throws IllegalAccessException, InvocationTargetException {
        System.out.println("{");
        System.out.println("Animal type: " + o.getClass().getSimpleName());
        Field[] fieldsAnimals = o.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldsExtendAnimals = o.getClass().getDeclaredFields();

        for (Field fieldAnimal : fieldsAnimals) {
            fieldAnimal.setAccessible(true);
            System.out.println("       "+fieldAnimal.getName() + " :" + fieldAnimal.get(o));
        }

        for(Field fieldExtendAnimal: fieldsExtendAnimals ){
            fieldExtendAnimal.setAccessible(true);
            System.out.println("       "+fieldExtendAnimal.getName() +" :"+fieldExtendAnimal.get(o));
        }

        Method[]methods = o.getClass().getDeclaredMethods();
        for (Method method: methods){
            if("makeSound".equals(method.getName())){
                System.out.println("       Method :"+method.getName());
                method.invoke(o);

            }

        }
        System.out.println("}");
    }
}
