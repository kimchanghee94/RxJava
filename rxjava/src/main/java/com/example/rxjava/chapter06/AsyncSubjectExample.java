package com.example.rxjava.chapter06;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.subjects.AsyncSubject;
import io.reactivex.subjects.PublishSubject;

public class AsyncSubjectExample {
    public static void main(String[] args){
        //async는 특이하게 모든 구독자들이 마지막 데이터를 받는다 시점이 지난 이후에 구독해도 마지막 데이터를 받는다
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.onNext(1000);

        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "#소비자 1 : " + price))
                        .subscribe(price -> Logger.log(LogType.ON_NEXT,"#소비자 1 : " + price));
        subject.onNext(2000);

        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "#소비자 2 : " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT,"#소비자 2 : " + price));
        subject.onNext(3000);

        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "#소비자 3 : " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT,"#소비자 3 : " + price));
        subject.onNext(4000);

        subject.onComplete();

        subject.doOnNext(price -> Logger.log(LogType.DO_ON_NEXT, "#소비자 4 : " + price))
                .subscribe(price -> Logger.log(LogType.ON_NEXT,"#소비자 4 : " + price));
    }
}
