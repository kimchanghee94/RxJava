package com.example.rxjava.chapter05.condition;

import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableContainsExample {
    public static void main(String[] args){
        Observable.fromArray(SampleData.carMakersDuplicated)
                .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, data))
                .contains(CarMaker.SAMSUNG)
                .subscribe(data->Logger.log(LogType.ON_NEXT,data));
    }
}
