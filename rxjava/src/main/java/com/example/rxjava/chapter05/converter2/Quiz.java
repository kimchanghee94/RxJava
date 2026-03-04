package com.example.rxjava.chapter05.converter2;

import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;
import io.reactivex.Single;

public class Quiz {
    public static void main(String[] args){
        Observable.fromIterable(SampleData.carList)
                .toMap(data -> data.getCarName(), data->data.getCarMaker())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
