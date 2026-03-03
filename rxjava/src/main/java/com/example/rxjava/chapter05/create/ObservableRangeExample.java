package com.example.rxjava.chapter05.create;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableRangeExample {
    public static void main(String[] args){
        Observable<Integer> source = Observable.range(0,5);
        source.subscribe(num-> Logger.log(LogType.ON_NEXT, num));
    }
}
