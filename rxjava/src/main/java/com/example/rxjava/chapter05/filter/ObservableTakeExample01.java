package com.example.rxjava.chapter05.filter;

import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableTakeExample01 {
    public static void main(String[] args){
        Observable.just("a","b","c","d").take(2)
                .subscribe(data->Logger.log(LogType.ON_NEXT, data));
    }
}
