package com.example.rxjava.chapter09;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;

public class BlockingForEachTest {
    @Test
    public void getSpeedOfSectionAForEachTest(){
        //blockingIterable은 개별적으로 데이터 테스트가 가능하다면
        //blockingForEach는 모든 데이터가 동일한 테스트로 진행된다.
        //참고로 blockingForEach내부 메서드는 consumer기반이라 별도 반환값이 없다.
        SampleObservable.getSpeedOfSectionA()
                .filter(speed -> speed>10)
                .blockingForEach(speed -> assertThat(speed, greaterThan(10)));
    }
}