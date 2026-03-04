package com.example.rxjava.chapter05.error;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class GeneralErrorHandleExample {
    public static void main(String[] args){
        Observable.just(5)
                .flatMap(num ->
                        Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                                .take(5)
                                .map(i -> num/i)
                ).subscribe(
                        data->Logger.log(LogType.ON_NEXT, data),
                        error->Logger.log(LogType.ON_ERROR, error),
                        ()->Logger.log(LogType.ON_COMPLETE)
                );
        TimeUtil.sleep(1000L);
    }
}
