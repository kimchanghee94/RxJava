package com.example.rxjava.chapter05.condition;

import com.example.rxjava.common.CarMaker;
import com.example.rxjava.common.SampleData;
import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class ObservableSequenceEqualExample {
    public static void main(String[] args){
        //subscribeOn은 발행하는 쓰레드를 어디서 실행할지 결정해준다
        //Schedulers.io() 쓰레드랑 Schedulers.computation() 쓰레드가 존재하는데
        //Io는 읽기시간에 대기용으로 주로 사용되고 computation은 계산과정에 처리하는데 있어 별도의 쓰레드로 사용되어진다.
        Observable<CarMaker> observable1 =
                Observable.fromArray(SampleData.carMakers)
                        .subscribeOn(Schedulers.io())
                        .delay(carMaker -> {
                            TimeUtil.sleep(500L);
                            return Observable.just(carMaker);
                        })
                        .doOnNext(data -> Logger.log(LogType.DO_ON_NEXT,"# observable1: " + data));

        //sleep을 obeservable1보다 느리게 하면 main마지막에 TimeUtil.sleep()메서드를 처리해줘야한다.
        //observable1은 다른 쓰레드에서 돌고 아래 메서드는 main메서드에서 돌기 때문이다.
        //또한 delay안에 시간만 넣는 파라미터 메서드는 computaion쓰레드에서 돌고
        //delay안에 람다식 파라미터 메서드는 main메서드에서 돈다.
        Observable<CarMaker> observable2 =
                Observable.fromArray(SampleData.carMakersDuplicated)
                        .delay(carMaker -> {
                            TimeUtil.sleep(1000L);
                            return Observable.just(carMaker);
                        }).doOnNext(data -> Logger.log(LogType.DO_ON_NEXT, "# observable2: " + data));

        Observable.sequenceEqual(observable1, observable2)
                .subscribe(data->Logger.log(LogType.ON_NEXT, data));
    }
}
