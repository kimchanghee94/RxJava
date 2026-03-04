package com.example.rxjava.chapter05.combine;

import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class ObservableZipExample02 {
    public static void main(String[] args){
        Observable<Integer> observable1 = Observable.fromIterable(SampleData.seoulPM10List);
        Observable<Integer> observable2 = Observable.fromIterable(SampleData.busanPM10List);
        Observable<Integer> observable3 = Observable.fromIterable(SampleData.incheonPM10List);

        Observable<Integer> observable4 = Observable.range(1,24);

        Observable.zip(observable1, observable2, observable3, observable4,
                (data1, data2, data3, hour) -> hour + "시: " + Collections.max(Arrays.asList(data1, data2, data3)))
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
