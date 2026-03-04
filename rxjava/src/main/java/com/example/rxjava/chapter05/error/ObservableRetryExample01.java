package com.example.rxjava.chapter05.error;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableRetryExample01 {
    public static void main(String[] args){
        Observable.just(5)
                    .flatMap(num -> Observable
                            .interval(200L, TimeUnit.MILLISECONDS)
                            .map(i -> {
                                Logger.log(LogType.PRINT, "# 시도중");
                                throw new ArithmeticException();
//                                return result;
                            })
                            .retry(5)
                            .onErrorReturn(throwable -> -1L)
                    ).subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                    );

        TimeUtil.sleep(5000L);
    }
}
