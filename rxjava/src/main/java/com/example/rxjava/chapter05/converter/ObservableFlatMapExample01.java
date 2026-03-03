package com.example.rxjava.chapter05.converter;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableFlatMapExample01 {
    public static void main(String[] args){
        Observable.just("Hello")
                .flatMap(hello -> Observable.just("자바","파이썬","안드로이드").map(lang->hello + "," + lang))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
