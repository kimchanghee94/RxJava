package com.example.rxjava.chapter09;


import io.reactivex.Observable;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.jupiter.api.Assertions.assertThrows;


//blockingGet은 blockingSingle과 달리 통지되는 데이터가 없어도 null로 반환해준다.
public class BlockingGetTest {
    @Test
    public void blockingGetEmptyTest(){
        //then
        assertThat(Observable.empty().firstElement().blockingGet(), is(nullValue()));
    }

//  아래코드처럼 해보려 해도 반환값이 무조건 한개인 메서드한 blockingGet은 허용안함
//    @Test
//    public void blockingGetMultiTest(){
//        //then
//        assertThrows(IllegalArgumentException.class, () -> {
//                SampleObservable.getSalesOfBranchA().take(4).blockingGet();
//        });
//    }

    @Test
    public void totalSalesOfBranchATest(){
        //when
        int totalSales = SampleObservable.getSalesOfBranchA()
                .reduce((a,b)->a+b).blockingGet();

        //then
        assertThat(totalSales, is(326_000_000));
    }

    @Test
    public void salesAllBranchTest(){
        //when
        int totalSales = Observable.zip(
                SampleObservable.getSalesOfBranchA(),
                SampleObservable.getSalesOfBranchB(),
                SampleObservable.getSalesOfBranchC(),
                (a,b,c) -> a+b+c
        )
        .reduce((a,b) -> a+b)
        .blockingGet();

        //then
        assertThat(totalSales, is(992_000_000));
    }
}
