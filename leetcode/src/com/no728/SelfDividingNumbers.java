package com.no728;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/*
自除数 是指可以被它包含的每一位数除尽的数。

例如，128 是一个自除数，因为 128 % 1 == 0，128 % 2 == 0，128 % 8 == 0。

还有，自除数不允许包含 0 。

给定上边界和下边界数字，输出一个列表，列表的元素是边界（含边界）内所有的自除数。

示例 1：

输入：
上边界left = 1, 下边界right = 22
输出： [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
注意：

每个输入参数的边界满足 1 <= left <= right <= 10000。

 */
public class SelfDividingNumbers {

    public List<Integer> selfDividingNumbers(int left, int right) {
        if(left>right)
            return new ArrayList<>();
        List<Integer> ret = new ArrayList<>();
        for (int i = left; i < right+1; i++) {
            if(isSelfDividingNumber(i))
                ret.add(i);
        }

        return ret;
    }

    private boolean isSelfDividingNumber(int num){
        int divide = num;
        while(divide!=0){
            int temp = divide%10;
            if(temp == 0)
                return false;
            if(num%(temp)!=0)
                return false;
            divide = divide/10;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,200};
        List<Integer> integers = new SelfDividingNumbers().selfDividingNumbers(1, 200);
        integers.forEach(System.out::println);
    }
}
