package com.example.rxjava.chapter03;

import com.example.rxjava.utils.DateUtil;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.*;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MaybeCreateExample {
    public static void main(String[] args){
        Maybe<String> maybe = Maybe.create(new MaybeOnSubscribe<String>(){
            @Override
            public void subscribe(MaybeEmitter<String> emitter) throws Exception{
//                emitter.onSuccess(DateUtil.getNowDate());
                emitter.onComplete();
            }
        });

        maybe.subscribe(new MaybeObserver<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable disposable) {
                //아무것도 하지 않음
            }
            @Override
            public void onSuccess(@NonNull String s) {
                Logger.log(LogType.ON_SUCCESS, "#날짜 시각 : " + s);
            }

            @Override
            public void onError(@NonNull Throwable throwable) {
                Logger.log(LogType.ON_ERROR, throwable);
            }

            @Override
            public void onComplete(){
                Logger.log(LogType.ON_COMPLETE);
            }
        });
    }
}
