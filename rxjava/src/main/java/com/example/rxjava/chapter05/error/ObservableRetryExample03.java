package com.example.rxjava.chapter05.error;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

public class ObservableRetryExample03 {
    public static void main(String[] args){
        //retry는 실패한 데이터만 재전송하는것이 아니라 처음부터 다시 구독해서 실행한다.
        Observable.just(10, 12, 15, 16)
                .zipWith(Observable.just(1,2,0,4), (a,b)->{
                    int result;
                    try{
                        result = a / b;
                    }catch (ArithmeticException e){
                        Logger.log(LogType.PRINT, "error" + e.getMessage());
                        throw e;
                    }
                    return result;
                }).retry(3)
                .onErrorReturn(throwable -> -1)
                .subscribe(
                        data -> Logger.log(LogType.ON_NEXT, data),
                        error -> Logger.log(LogType.ON_ERROR, error),
                        () -> Logger.log(LogType.ON_COMPLETE)
                );

        TimeUtil.sleep(6000L);
    }
}
