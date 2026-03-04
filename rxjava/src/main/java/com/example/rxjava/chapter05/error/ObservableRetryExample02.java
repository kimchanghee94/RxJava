package com.example.rxjava.chapter05.error;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableRetryExample02 {
    private final static int RETRY_MAX=5;
    public static void main(String[] args){
        Observable.just(5)
                    .flatMap(num -> Observable
                            .interval(200L, TimeUnit.MILLISECONDS)
                            .map(i -> {
                                Logger.log(LogType.PRINT, "# 시도중");
                                throw new ArithmeticException();
                            })
                            .retry((retryCount, ex) ->{
                                Logger.log(LogType.PRINT, "#재시도 횟수: " + retryCount);
                                TimeUtil.sleep(1000L);
                                return retryCount < RETRY_MAX ? true : false;
                            })
                            .onErrorReturn(throwable -> -1L)
                    ).subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                    );

        TimeUtil.sleep(6000L);
    }
}
