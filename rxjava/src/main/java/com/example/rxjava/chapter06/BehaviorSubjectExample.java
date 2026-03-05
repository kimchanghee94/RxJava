package com.example.rxjava.chapter06;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;

public class BehaviorSubjectExample {
    public static void main(String[] args){
        //구독 시점 중 이전에 마지막데이터를 포함해서 발행받는다
        BehaviorSubject<Integer> subject = BehaviorSubject.createDefault(3000);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT,"#소비자 1 : " + price));
        subject.onNext(3500);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT,"#소비자 2 : " + price));
        subject.onNext(3300);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT,"#소비자 3 : " + price));
        subject.onNext(3400);
    }
}
