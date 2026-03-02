package com.example.rxjava.chapter03;

import com.example.rxjava.utils.LogType;
import com.example.rxjava.utils.Logger;
import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class HelloRxJavaFlowableCreateExample {
    public static void main(String[] args) throws InterruptedException{
        Flowable<String> flowable =
                Flowable.create(new FlowableOnSubscribe<String>(){
                    @Override
                    public void subscribe(FlowableEmitter<String> emitter) throws Exception{
                        String[] datas = {"Hello", "RxJava!"};
                        for(String data: datas){

                            //구독 해지시 처리 중단
                            if(emitter.isCancelled()) return;

                            //데이터 통지
                            emitter.onNext(data);
                        }

                        //데이터 통지 완료 알림
                        emitter.onComplete();
                    }
                }, BackpressureStrategy.BUFFER);

        flowable.observeOn(Schedulers.computation())
                .subscribe(new Subscriber<String>() {
                    private Subscription subscription;
                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        this.subscription.request(Long.MAX_VALUE);
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
