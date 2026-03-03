package com.example.rxjava.chapter05.filter;

import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableDistinctExample02 {
    public static void main(String[] args){
        Observable.fromArray(SampleData.carMakersDuplicated).distinct()
                .filter(carMaker -> carMaker== CarMaker.SSANGYOUNG)
                .subscribe(carMaker -> Logger.log(LogType.ON_NEXT, carMaker));
    }
}
