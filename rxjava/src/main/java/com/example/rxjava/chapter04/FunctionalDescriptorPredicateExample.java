package com.example.rxjava.chapter04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalDescriptorPredicateExample {
    public static void main(String[] args){
        List<Integer> numbers = Arrays.asList(1,6,10,30,65,79,102);
        List<Integer> result = filter(numbers, n->n>30);

        for(int num : numbers) System.out.println(num);
    }

    private static <T> List<T> filter(List<T> numbers, Predicate<T> p){
        List<T> result = new ArrayList<>();
        for(T num : numbers){
            if(p.test(num)) result.add(num);
        }
        return result;
    }
}
