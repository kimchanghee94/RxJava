package com.example.rxjava.chapter01;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class ToDoSample {
    public static void main(String[] args) throws InterruptedException{
        Observable.just(100, 200, 300, 400, 500)    //데이터를 발행한다.
                .doOnNext(data -> System.out.println(getThreadName() + " : #doOnNext() : " + data))
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .filter(n->n>300)   //데이터를 가공하고
                .subscribe(num -> System.out.println(getThreadName() + " : result : " + num)); //데이터를 구독해서 결과를 처리한다

        Thread.sleep(500);
    }

    public static String getThreadName(){
        return Thread.currentThread().getName();
    }
}
