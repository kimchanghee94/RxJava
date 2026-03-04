package com.example.rxjava.chapter05.error;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.Observable;

public class CanNotUseTryCatchExample {
    public static void main(String[] args){
        try{
            Observable.just(2)
                    .map(num -> num/0)
                    .subscribe(data->Logger.log(LogType.ON_NEXT, data));
        }catch (Exception e){
            Logger.log(LogType.PRINT,"# 에러처리가 필요: " + e.getCause());
        }
    }
}
