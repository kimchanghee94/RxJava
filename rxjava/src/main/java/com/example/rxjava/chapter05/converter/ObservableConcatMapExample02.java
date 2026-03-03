package com.example.rxjava.chapter05.converter;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableConcatMapExample02 {
    public static void main(String[] args){
        TimeUtil.start();
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .skip(2)
                .flatMap(
                    num -> Observable.interval(200L, TimeUnit.MILLISECONDS)
                            .take(10)
                            .skip(1)
                            .map(row -> num + " * " + row + " = " + num*row)
                ).subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> {},
                        () -> {
                            TimeUtil.end();
                            TimeUtil.takeTime();
                        }
                );
        
        TimeUtil.sleep(5000L);
    }
}
