package com.example.rxjava.chapter08;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class DoOnCompleteExample {
    public static void main(String[] args){
        Observable.range(1,5)
                //onComplete 이벤트 발생 전에 호출되는 doOnComplete
                .doOnComplete(() -> Logger.log(LogType.DO_ON_COMPLETE,"#생산자: 데이터 통지 완료"))
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }
}
