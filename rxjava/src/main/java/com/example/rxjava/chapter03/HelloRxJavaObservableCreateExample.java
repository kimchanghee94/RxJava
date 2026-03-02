package com.example.rxjava.chapter03;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class HelloRxJavaObservableCreateExample {
    public static void main(String[] args) throws InterruptedException{
        Observable<String> observable =
                Observable.create(new ObservableOnSubscribe<String>(){
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception{
                        String[] datas = {"Hello", "RxJava!"};
                        for(String data: datas){

                            //구독 해지시 처리 중단
                            if(emitter.isDisposed()) return;

                            //데이터 통지
                            emitter.onNext(data);
                        }

                        //데이터 통지 완료 알림
                        emitter.onComplete();
                    }
                });

        observable.observeOn(Schedulers.computation())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(Disposable disposable) {
                        //아무처리도 하지 않음(observable은 계약기능이 따로 없음)
                    }

                    @Override
                    public void onNext(String s) {
                        Logger.log(LogType.ON_NEXT, s);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        Logger.log(LogType.ON_ERROR, throwable);
                    }

                    @Override
                    public void onComplete() {
                        Logger.log(LogType.ON_COMPLETE);
                    }
                });

        Thread.sleep(500L);
    }
}
