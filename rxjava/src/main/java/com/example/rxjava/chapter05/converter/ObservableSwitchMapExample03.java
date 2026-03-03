package com.example.rxjava.chapter05.converter;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import com.example.rxjava.utils.TimeUtil;
import io.reactivex.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ObservableSwitchMapExample03 {
    public static void main(String[] args){
        TimeUtil.start();

        Searcher searcher = new Searcher();
        final List<String> keywords = Arrays.asList("M", "Ma", "Mal", "Malay");
        Observable.interval(100L, TimeUnit.MILLISECONDS)
                .take(4)
                .switchMap(data -> {
                    //switchMap을 사용했기 때문에 마지막 키워드를 사용한 최신검색 결과만 가져온다.
                    String keyword = keywords.get(data.intValue());

                    return Observable.just(searcher.search(keyword))
                            .doOnNext(notUse -> System.out.println("===================="))
                            .delay(1000L, TimeUnit.MILLISECONDS);
                })
                .flatMap(resultList -> Observable.fromIterable(resultList))
                .subscribe(
                    data -> Logger.log(LogType.ON_NEXT, data),
                        error -> {},
                        () -> {
                            TimeUtil.end();
                            TimeUtil.takeTime();
                        }
                );

        TimeUtil.sleep(6000L);
    }
}
