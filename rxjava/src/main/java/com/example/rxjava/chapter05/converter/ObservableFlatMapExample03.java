package com.example.rxjava.chapter05.converter;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableFlatMapExample03 {
    public static void main(String[] args){
        Observable.range(2,1)
                .flatMap(
                        data -> Observable.range(1,9),
                        (sourceData, transformedData) ->
                                sourceData + "* " + transformedData + " = " + sourceData*transformedData
                )
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
