package com.example.rxjava.chapter05.group;

import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

import java.util.Arrays;

public class ObservableCountExample02 {
    public static void main(String[] args){
        Observable.concat(
                Arrays.asList(
                        Observable.fromIterable(SampleData.seoulPM10List),
                        Observable.fromIterable(SampleData.busanPM10List),
                        Observable.fromIterable(SampleData.incheonPM10List)
                )
        )
        .count()
        .subscribe(data -> Logger.log(LogType.ON_NEXT, data));
    }
}
