package com.example.rxjava.chapter04;

import com.example.rxjava.common.Car;

import java.util.function.Function;
import java.util.function.Supplier;

public class ConstructorReferenceExample {
    public static void main(String[] args){
        Function<String, Car> f1 = s->new Car(s);
        Car car1 = f1.apply("k5");
        System.out.println(car1.getCarName());

        Function<String, Car> f2 = Car::new;
        Car car2 = f2.apply("카니발");
        System.out.println(car2.getCarName());

        Supplier<Car> f3 = Car::new;
        Car car3 = f3.get();
        System.out.println(car3.getCarName());
    }
}
