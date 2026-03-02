package com.example.rxjava.chapter03;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class HelloRxJavaObservableCreateLamdaExample {
    public static void main(String[] args) throws InterruptedException{
        Observable<String> observable =
                Observable.create(emitter->{
                    String[] datas = {"Hello", "RxJava!"};
                    for(String data : datas){
                        //구독이 해지되면 중단
                        if(emitter.isDisposed()) return;

                        //데이터 발행
                        emitter.onNext(data);
                    }

                    //데이터 발행 완료를 알린다
                    emitter.onComplete();
                });

        observable.observeOn(Schedulers.computation())
                .subscribe(data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE),
                        disposable -> {});

        Thread.sleep(500L);
    }
}
