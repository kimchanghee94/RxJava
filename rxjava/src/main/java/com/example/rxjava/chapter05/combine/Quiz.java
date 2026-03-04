package com.example.rxjava.chapter05.combine;

import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;

public class Quiz {
    public static void main(String[] args){
//        Observable<Integer> observable1 = Observable.fromIterable(SampleData.salesOfBranchA);
//        Observable<Integer> observable2 = Observable.fromIterable(SampleData.salesOfBranchB);
//        Observable<Integer> observable3 = Observable.fromIterable(SampleData.salesOfBranchC);
//
//        Observable.zip(observable1, observable2, observable3,
//                (data1, data2, data3)->data1+data2+data3)
//                .subscribe(data->Logger.log(LogType.ON_NEXT, data));

        List<Observable<Integer>> list = Arrays.asList(
                Observable.fromIterable(SampleData.salesOfBranchA),
                Observable.fromIterable(SampleData.salesOfBranchB),
                Observable.fromIterable(SampleData.salesOfBranchC)
        );

        Observable.zip(list, data->(int)data[0]+(int)data[1]+(int)data[2])
                .subscribe(data->Logger.log(LogType.ON_NEXT, data));
    }
}
