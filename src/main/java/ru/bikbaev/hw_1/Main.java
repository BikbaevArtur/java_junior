package ru.bikbaev.hw_1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(2,5,3,3,2,1,5,7,8,10,22);

        System.out.println(list.stream().filter(x -> x % 2 == 0).mapToInt(e -> e).average().getAsDouble());


    }


}