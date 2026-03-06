package com.example.rxjava.chapter11.sensor;

import com.example.rxjava.utils.NumberUtil;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class HumiditySensor {
    public Observable<Integer> getHumidityStream(){
        return Observable.interval(0L, TimeUnit.MILLISECONDS)
                .delay(item -> {
                    TimeUtil.sleep(NumberUtil.randomRange(1000, 3000));
                    return Observable.just(item);
                })
                .map(notUse -> this.getHumidity());
    }

    private int getHumidity(){
        return NumberUtil.randomRange(30, 70);
    }
}
