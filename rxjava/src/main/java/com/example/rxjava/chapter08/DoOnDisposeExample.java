package com.example.rxjava.chapter08;

import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class DoOnDisposeExample {
    public static void main(String[] args){
        Observable.fromArray(SampleData.carMakers)
                .zipWith(Observable.interval(300L, TimeUnit.MILLISECONDS), (carMaker, num) -> carMaker)
                .doOnDispose(() -> Logger.log(LogType.DO_ON_DISPOSE, "#생산자: 구독 해지 완료"))
                .subscribe(new Observer<CarMaker>() {
                    private Disposable disposable;
                    private long startTime;
                    @Override
                    public void onSubscribe(@NonNull Disposable disposable) {
                        this.disposable = disposable;
                        this.startTime = TimeUtil.start();
                    }

                    @Override
                    public void onNext(@NonNull CarMaker carMaker) {
                        Logger.log(LogType.ON_NEXT, carMaker);
                        if(TimeUtil.getCurrentTime() - startTime > 1000L){
                            Logger.log(LogType.PRINT,"#소비자 :  구독해지, 1000L 초과");
                            disposable.dispose();
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable throwable) {
                        Logger.log(LogType.ON_ERROR, throwable);
                    }

                    @Override
                    public void onComplete() {
                        Logger.log(LogType.ON_COMPLETE);
                    }
                });
        TimeUtil.sleep(2000L);
    }
}
