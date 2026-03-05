package com.example.rxjava.chapter06;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.subjects.ReplaySubject;

public class ReplaySubjectExample01 {
    public static void main(String[] args){
        ReplaySubject<Integer> subject = ReplaySubject.create();
        subject.onNext(3000);
        subject.onNext(2500);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT,"# 소비자 1 : " + price));
        subject.onNext(3500);

        subject.subscribe(price -> Logger.log(LogType.ON_NEXT,"# 소비자 2 : " + price));
        subject.onNext(3300);

        //완료가 처리된 시점 이후에도 소비자3은 이전의 데이터들을 모두 전달받는다.
        subject.onComplete();
        subject.subscribe(price -> Logger.log(LogType.ON_NEXT,"# 소비자 3 : " + price));
    }
}
