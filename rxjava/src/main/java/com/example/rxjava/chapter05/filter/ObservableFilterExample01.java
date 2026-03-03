package com.example.rxjava.chapter05.filter;

import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableFilterExample01 {
    public static void main(String[] args){
        Observable.fromIterable(SampleData.carList)
                .filter(car->car.getCarMaker()== CarMaker.CHEVROLET)
                .subscribe(car-> Logger.log(LogType.ON_NEXT,car.getCarMaker() + " : " + car.getCarName()));
    }
}
