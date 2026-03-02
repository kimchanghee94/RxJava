package com.example.rxjava.chapter03;

import com.example.rxjava.utils.DateUtil;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Single;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleObserver;
import io.reactivex.SingleOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class SingleCreateExample {
    public static void main(String[] args){
        Single<String> single = Single.create(new SingleOnSubscribe<String>(){
            @Override
            public void subscribe(SingleEmitter<String> emitter) throws Exception{
                emitter.onSuccess(DateUtil.getNowDate());
            }
        });

        single.subscribe(new SingleObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {

            }

            @Override
            public void onSuccess(@NonNull String s) {
                Logger.log(LogType.ON_SUCCESS, "#날짜 시각 : " + s);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                Logger.log(LogType.ON_ERROR, throwable);
            }
        });
    }
}
