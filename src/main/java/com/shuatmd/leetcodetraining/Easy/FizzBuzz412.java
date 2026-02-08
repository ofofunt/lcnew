package com.shuatmd.leetcodetraining.Easy;

import java.util.ArrayList;
import java.util.List;

public class FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        List<String> resList = new ArrayList<>();
        int cur = 1;
        while (cur <= n) {
            if (cur % 3 == 0 && cur % 5 == 0) {
                resList.add("FizzBuzz");
            } else if (cur % 3 == 0) {
                resList.add("Fizz");
            } else if (cur % 5 == 0) {
                resList.add("Buzz");
            } else {
                resList.add(cur + "");
            }
            cur++;
        }
        return resList;
    }
}
