package com.example.rxjava.chapter05.filter;

import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableDistinctExample03 {
    public static void main(String[] args){
        Observable.fromIterable(SampleData.carList)
                .distinct(car->car.getCarMaker())
                .subscribe(car->Logger.log(LogType.ON_NEXT, car.getCarName()));
    }
}
