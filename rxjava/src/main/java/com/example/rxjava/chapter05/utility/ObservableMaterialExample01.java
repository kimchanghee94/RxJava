package com.example.rxjava.chapter05.utility;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class ObservableMaterialExample01 {
    public static void main(String[] args){
        Observable.just(1,2,3,4,5,6)
                .materialize()
                .subscribe(noti -> {
                    String notiType = noti.isOnNext() ? "onNext()" : (noti.isOnError() ? "onError()" : "onComplete()");
                    Logger.log(LogType.PRINT, "notification 타입: " + notiType);
                    Logger.log(LogType.ON_NEXT, noti.getValue());
                });
    }
}
