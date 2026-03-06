package com.example.rxjava.chapter09;


import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

//BlockingSingle을 사용시 2개 이상 발행시 예외, 하나만 반환하면 완료
public class BlockingSingleTest {
    @Test
    public void totalSalesOfBranchATest(){
        int actual = SampleObservable.getSalesOfBranchA()
                .filter(sale -> sale > 30_000_000)
                .take(1)
                .blockingSingle();

        assertThat(actual, is(35_000_000));
    }

    @Test
    public void totalSalesOfBranchATest2(){
        assertThrows(IllegalArgumentException.class, () -> {
            SampleObservable.getSalesOfBranchA()
                    .filter(sale -> sale > 30_000_000)
                    .take(2)
                    .blockingSingle();
        });
    }
}
