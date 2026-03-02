package com.example.rxjava.chapter03;

import com.example.rxjava.utils.DateUtil;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Maybe;
import io.reactivex.Single;

public class MaybeFromExample {
    public static void main(String[] args){
        Single<String> single = Single.just(DateUtil.getNowDate());
        Maybe.fromSingle(single)
            .subscribe(
                data->Logger.log(LogType.ON_SUCCESS, "#현재 날짜시각: " + data),
                error->Logger.log(LogType.ON_ERROR, error),
                ()->Logger.log(LogType.ON_COMPLETE)
            );
    }
}
