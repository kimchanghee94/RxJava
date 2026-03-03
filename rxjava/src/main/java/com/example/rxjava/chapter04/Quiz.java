package com.example.rxjava.chapter04;

import com.example.rxjava.common.Car;
import com.example.rxjava.common.CarType;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;

public class Quiz {
    public static void main(String[] args){
        Predicate<String> p = String::isEmpty;
        System.out.println(p.test("hello"));

        Function<Integer, String> f = String::valueOf;
        System.out.println(f.apply(10));

        BiPredicate<List<Integer>,Integer> p2 = List::contains;
        System.out.println(p2.test(Arrays.asList(1,2,3), 3));

        Consumer<String> c = System.out::println;
        c.accept("hi");

        BiFunction<String, CarType, Car> f2 = Car::new;
        Car car = f2.apply("K5",CarType.SUV);
        System.out.println(car.getCarName() + ", " + car.getCarType());
    }
}
