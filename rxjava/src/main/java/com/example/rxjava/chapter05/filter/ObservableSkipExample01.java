package com.example.rxjava.chapter05.filter;

import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableSkipExample01 {
    public static void main(String[] args){
        Observable.range(1,15).skip(3)
                .subscribe(data->Logger.log(LogType.ON_NEXT,data));
    }
}
