package com.example.rxjava.chapter08;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class DoOnErrorExample {
    public static void main(String[] args){
        Observable.just(3,6,9,12,15,20)
                .zipWith(Observable.just(1,2,3,4,0,5),(a,b)->a/b)
                .doOnError(error -> Logger.log(LogType.DO_ON_ERROR,"# 생산자: 에러 발생 - " + error.getMessage()))
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }
}
