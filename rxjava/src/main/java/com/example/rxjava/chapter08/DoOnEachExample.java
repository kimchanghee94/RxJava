package com.example.rxjava.chapter08;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class DoOnEachExample {
    public static void main(String[] args){
        Observable.range(1,5)
                //map에러 발생이 doOnEach밑에서 터지면 doOnEach의 noti.isError 안탄다
//                .map(data -> data/0)
                .doOnEach(noti -> {
                    if(noti.isOnNext()) Logger.log(LogType.DO_ON_NEXT,"#생산자: 데이터 통지 - " + noti.getValue());
                    else if(noti.isOnError()) Logger.log(LogType.DO_ON_ERROR,"#생산자: 에러 발생 - " + noti.getError());
                    else Logger.log(LogType.DO_ON_COMPLETE,"#생산자: 데이터 통지 완료");
                })
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );
    }
}
