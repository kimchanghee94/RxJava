package com.example.rxjava.chapter04;

import java.util.function.Function;

public class ClassNameStaticMethodExample {
    public static void main(String[] args){
        Function<String, Integer> f1 = (String s) -> Integer.parseInt(s);
        Integer result1 = f1.apply("3");
        System.out.println(result1);

        Function<String, Integer> f2 = s -> Integer.parseInt(s);
        Integer result2 = f2.apply("3");
        System.out.println(result2);

        Function<String, Integer> f3 = Integer::parseInt;
        Integer result3 = f3.apply("3");
        System.out.println(result3);
    }
}
