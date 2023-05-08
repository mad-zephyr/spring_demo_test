package com.unittesting.learn.spring_demotest.business;

import com.unittesting.learn.spring_demotest.data.SomeDataService;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class SomeBusinessImpl {
    SomeDataService someDataService;
    public int calculate(int[] data) {
        int sum = 0;
        for(int value:data) {
            sum += value;
        }
        return sum;
    }

    public int calculateWithDataService() {
        int sum = 0;
        int[] data = someDataService.retrieveAll();
        for(int value:data) {
            sum += value;
        }
        return sum;
    }
}
