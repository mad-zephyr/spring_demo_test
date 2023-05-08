package com.unittesting.learn.spring_demotest.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessTest {

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        int actualResult = business.calculate(new int[]{1,2,3});
        int expectResult = 6;

        assertEquals(expectResult, actualResult);
    }
}
