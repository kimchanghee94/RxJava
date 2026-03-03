package com.example.rxjava.chapter05.filter;

import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableFilterExample02 {
    public static void main(String[] args){
        Observable.fromIterable(SampleData.carList)
                .filter(car->car.getCarMaker()== CarMaker.CHEVROLET)
                .filter(car->car.getCarPrice()>30000000)
                .subscribe(car-> Logger.log(LogType.ON_NEXT,car.getCarMaker() + " : " + car.getCarName()));
    }
}
