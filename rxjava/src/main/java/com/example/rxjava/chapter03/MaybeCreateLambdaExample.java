package com.example.rxjava.chapter03;

import com.example.rxjava.utils.DateUtil;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Maybe;
import io.reactivex.MaybeEmitter;
import io.reactivex.MaybeObserver;
import io.reactivex.MaybeOnSubscribe;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MaybeCreateLambdaExample {
    public static void main(String[] args){
        Maybe<String> maybe = Maybe.create(emitter -> {
//            emitter.onSuccess(DateUtil.getNowDate());
            emitter.onComplete();
        });

        maybe.subscribe(
                data->Logger.log(LogType.ON_SUCCESS, "#현재 날짜시각: " + data),
                error->Logger.log(LogType.ON_ERROR, error),
                ()->Logger.log(LogType.ON_COMPLETE)
        );
    }
}
