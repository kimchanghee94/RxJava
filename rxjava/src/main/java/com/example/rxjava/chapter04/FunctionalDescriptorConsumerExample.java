package com.example.rxjava.chapter04;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class FunctionalDescriptorConsumerExample {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,6,10,30,65,79,102);
        forEachPrint(numbers, n -> System.out.println(n));
    }

    private static <T> void forEachPrint(List<T> numbers, Consumer<T> c){
        for(T number : numbers){
            c.accept(number);
        }
    }
}
