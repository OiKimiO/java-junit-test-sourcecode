package com.junit.test.chapter01;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class ScoreCollectionTest {

    @Test
    void 계산하기(){
        // given
        ScoreCollection scoreCollection = new ScoreCollection();
        scoreCollection.add(() -> 10);
        scoreCollection.add(() -> 6);

        // when
        int number = scoreCollection.arithmeticMean();

        // then
        assertEquals(number,8);
    }
}
