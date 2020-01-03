package com.no412;

import java.util.ArrayList;
import java.util.List;

/*
412. Fizz Buzz
写一个程序，输出从 1 到 n 数字的字符串表示。

1. 如果 n 是3的倍数，输出“Fizz”；

2. 如果 n 是5的倍数，输出“Buzz”；

3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。

示例：

n = 15,

返回:
[
    "1",
    "2",
    "Fizz",
    "4",
    "Buzz",
    "Fizz",
    "7",
    "8",
    "Fizz",
    "Buzz",
    "11",
    "Fizz",
    "13",
    "14",
    "FizzBuzz"
]

 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> ret = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int status = 0;
            if(i%3==0){
                status += 1;
            }
            if(i%5==0){
                status += 2;
            }
            switch (status){
                case 0:
                    ret.add(""+i);
                    break;
                case 1:
                    ret.add("Fizz");
                    break;
                case 2:
                    ret.add("Buzz");
                    break;
                case 3:
                    ret.add("FizzBuzz");
                    break;
            }

        }
        return ret;
    }

    public static void main(String[] args) {
        List<String> strings = new FizzBuzz().fizzBuzz(15);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
