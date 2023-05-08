package com.unittesting.learn.spring_demotest.business;

import com.unittesting.learn.spring_demotest.data.SomeDataService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SomeBusinessServiceStub implements SomeDataService {
    @Override
    public int[] retrieveAll() {
        return new int[]{1,2,3};
    }
}

class SomeBusinessServiceEmptyStub implements SomeDataService {
    @Override
    public int[] retrieveAll() {
        return new int[]{};
    }
}

class SomeBusinessServiceOneValueStub implements SomeDataService {
    @Override
    public int[] retrieveAll() {
        return new int[]{6};
    }
}

public class SomeBusinessStubTest {

    @Test
    public void calculateSumUsingDataService_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeBusinessServiceStub());

        int actualResult = business.calculateWithDataService();
        int expectResult = 6;

        assertEquals(expectResult, actualResult);
        assertFalse(10 < actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeBusinessServiceEmptyStub());

        int actualResult = business.calculateWithDataService();
        int expectResult = 0;

        assertEquals(expectResult, actualResult);
        assertFalse(10 < actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneElement() {
        SomeBusinessImpl business = new SomeBusinessImpl();
        business.setSomeDataService(new SomeBusinessServiceOneValueStub());

        int actualResult = business.calculateWithDataService();
        int expectResult = 6;

        assertEquals(expectResult, actualResult);
        assertFalse(10 < actualResult);
    }

    @Test
    public void calculateSum_basic() {
        SomeBusinessImpl business = new SomeBusinessImpl();

        int actualResult = business.calculate(new int[]{1,2,3});
        int expectResult = 6;

        assertEquals(expectResult, actualResult);
    }
}
