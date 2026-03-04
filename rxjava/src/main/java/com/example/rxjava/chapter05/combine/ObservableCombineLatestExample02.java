package com.example.rxjava.chapter05.combine;

import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.NumberUtil;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import org.apache.commons.logging.Log;

import java.util.concurrent.TimeUnit;

public class ObservableCombineLatestExample02 {
    public static void main(String[] args){
        Observable<Integer> observable1 = Observable.interval(NumberUtil.randomRange(100, 500), TimeUnit.MILLISECONDS)
                        .take(10).map(data-> SampleData.temperatureOfSeoul[NumberUtil.randomRange(0,5)]);

        Observable<Integer> observable2 = Observable.interval(NumberUtil.randomRange(100, 500), TimeUnit.MILLISECONDS)
                        .take(10).map(data -> SampleData.humidityOfSeoul[NumberUtil.randomRange(0,5)]);

        Observable.combineLatest(observable1, observable2, (temp, hum) -> "최신 온습도 데이터 - 온도: " + temp + "도\t습도: " + hum + "%")
                        .subscribe(data -> Logger.log(LogType.ON_NEXT, data));

        TimeUtil.sleep(7000L);
    }
}
