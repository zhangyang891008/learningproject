package com.no575;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class DistributeCandies2 {
    public int distributeCandies(int[] candies) {
        if(candies==null || candies.length<1)
            return 0;
        HashSet<Integer> candiesSet = new HashSet<>();
        int ret = 0;

        for (int i = 0; i < candies.length; i++) {
            candiesSet.add(candies[i]);
        }

        return candiesSet.size() < candies.length/2 ? candiesSet.size(): candies.length/2;
    }

    public static void main(String[] args) {
        int[] candies= {1,1,1,1,2,2};
        int i = new DistributeCandies2().distributeCandies(candies);
        System.out.println(i);
    }
}
