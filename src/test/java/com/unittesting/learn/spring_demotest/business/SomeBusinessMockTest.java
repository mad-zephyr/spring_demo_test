package com.unittesting.learn.spring_demotest.business;

import com.unittesting.learn.spring_demotest.data.SomeDataService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessMockTest {
    @InjectMocks
    SomeBusinessImpl business = new SomeBusinessImpl();

    @Mock
    SomeDataService dataServiceMock;

    @Test
    public void calculateSumUsingDataService_basic() {
        when(dataServiceMock.retrieveAll()).thenReturn(new int[]{1,2,3});

        int actualResult = business.calculateWithDataService();
        int expectResult = 6;

        assertEquals(expectResult, actualResult);
        assertFalse(10 < actualResult);
    }

    @Test
    public void calculateSumUsingDataService_empty() {
        when(dataServiceMock.retrieveAll()).thenReturn(new int[]{});

        int actualResult = business.calculateWithDataService();
        int expectResult = 0;

        assertEquals(expectResult, actualResult);
        assertFalse(10 < actualResult);
    }

    @Test
    public void calculateSumUsingDataService_oneElement() {
        when(dataServiceMock.retrieveAll()).thenReturn(new int[]{6});

        int actualResult = business.calculateWithDataService();
        int expectResult = 6;

        assertEquals(expectResult, actualResult);
        assertFalse(10 < actualResult);
    }
}
