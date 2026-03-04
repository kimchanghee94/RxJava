package com.example.rxjava.chapter05.error;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class ObservableOnErrorReturnExample {
    public static void main(String[] args){
        Observable.just(5)
                .flatMap(num ->
                        Observable.interval(200L, TimeUnit.MILLISECONDS)
                                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                                .take(5)
                                .map(i -> num/i)
                                .onErrorReturn(e -> {
                                    if(e instanceof ArithmeticException){
                                        Logger.log(LogType.PRINT,"#계산 처리 에러 발생: " + e.getMessage());
                                    }
                                    return -1L;
                                })
                ).subscribe(
                        data->{
                            if(data<0)
                                Logger.log(LogType.PRINT,"# 예외를 알리는 데이터: " + data);
                            else
                                Logger.log(LogType.ON_NEXT, data);
                        },
                        error->Logger.log(LogType.ON_ERROR, error),
                        ()->Logger.log(LogType.ON_COMPLETE)
                );
        TimeUtil.sleep(5000L);
    }
}
