package com.example.rxjava.chapter05.condition;

import com.example.rxjava.common.Car;
import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableAllExample {
    public static void main(String[] args){
        Observable.fromIterable(SampleData.carList)
                .doOnNext(car -> Logger.log(LogType.DO_ON_NEXT, "Car Maker : " + car.getCarMaker()
                        + "\tCar Name: " + car.getCarName()))
                .map(Car::getCarMaker)
//                .all(carMaker -> carMaker.equals(CarMaker.CHEVROLET))
                .all(CarMaker.CHEVROLET::equals)
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
