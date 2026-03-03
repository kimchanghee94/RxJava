package com.example.rxjava.chapter05.create;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

import java.time.LocalTime;

public class ObservableDeferExample {
    public static void main(String[] args) throws InterruptedException{
        Observable<LocalTime> observable = Observable.defer(()->{
            LocalTime curTime = LocalTime.now();
            return Observable.just(curTime);
        });

        Observable<LocalTime> observableJust = Observable.just(LocalTime.now());

        observable.subscribe(time->Logger.log(LogType.PRINT, " # defer() 구독1의 구독시간: " + time));
        observableJust.subscribe(time->Logger.log(LogType.PRINT, " # just() 구독1의 구독시간: "+ time));
        Thread.sleep(3000);

        observable.subscribe(time->Logger.log(LogType.PRINT, " # defer() 구독2의 구독시간: " + time));
        observableJust.subscribe(time->Logger.log(LogType.PRINT, " # just() 구독2의 구독시간: "+ time));
    }
}
