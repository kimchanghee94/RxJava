package com.example.rxjava.chapter11.sensor;

import com.example.rxjava.utils.NumberUtil;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class TemperatureSensor {
    public Observable<Integer> getTemperatureStream(){
        return Observable.interval(0L, TimeUnit.MILLISECONDS)
                .delay(item -> {
                    TimeUtil.sleep(NumberUtil.randomRange(1000, 3000));
                    return Observable.just(item);
                })
                .map(notUse -> this.getTemperature());
    }

    private int getTemperature(){
        return NumberUtil.randomRange(-10, 30);
    }
}
