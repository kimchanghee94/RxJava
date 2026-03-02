package com.example.rxjava.chapter03;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Completable;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableObserver;
import io.reactivex.CompletableOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class CompletableLamdaExample {
    public static void main(String[] args) throws InterruptedException{
        Completable completable = Completable.create(emitter -> {
            int sum = 0;
            for(int i=0;i<100;i++) sum+=i;
            Logger.log(LogType.PRINT, "# 합계: " + sum);
            emitter.onComplete();
        });

        completable.subscribeOn(Schedulers.computation())
                .subscribe(() -> Logger.log(LogType.ON_COMPLETE),
                        error -> Logger.log(LogType.ON_ERROR, error));

        TimeUtil.sleep(100L);
    }
}
