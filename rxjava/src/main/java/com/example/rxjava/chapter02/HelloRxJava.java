package com.example.rxjava.chapter02;

import io.reactivex.rxjava3.core.Observable;

public class HelloRxJava {
    public static void main(String[] args){
        Observable<String> observable = Observable.just("Hello", "RxJava");
        observable.subscribe(data -> System.out.println(data));

    }
}
