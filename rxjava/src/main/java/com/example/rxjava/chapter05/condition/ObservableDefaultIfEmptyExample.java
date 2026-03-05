package com.example.rxjava.chapter05.condition;

import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableDefaultIfEmptyExample {
    public static void main(String[] args){
        Observable.just(1,2,3,4,5).filter(num -> num>10)
                .defaultIfEmpty(10)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
