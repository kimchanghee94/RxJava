package com.example.rxjava.chapter08;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class DoOnSubscribeExample {
    public static void main(String[] args){
        Observable.just(1,2,3,4,5,6,7)
                .doOnSubscribe(disposable -> Logger.log(LogType.DO_ON_SUBSCRIBE,"# 생산자: 구독 처리 준비 완료"))
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE),
                        disposable -> Logger.log(LogType.ON_SUBSCRIBE, "# 소비자: 구독 처리 준비 완료 알림 받음")
                );
    }
}
