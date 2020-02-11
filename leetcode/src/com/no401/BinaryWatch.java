package com.no401;

import java.util.*;

/*
401. 二进制手表
二进制手表顶部有 4 个 LED 代表小时（0-11），底部的 6 个 LED 代表分钟（0-59）。
每个 LED 代表一个 0 或 1，最低位在右侧。
例如，上面的二进制手表读取 “3:25”。
给定一个非负整数 n 代表当前 LED 亮着的数量，返回所有可能的时间。

案例:

输入: n = 1
返回: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

注意事项:

输出的顺序没有要求。
小时不会以零开头，比如 “01:00” 是不允许的，应为 “1:00”。
分钟必须由两位数组成，可能会以零开头，比如 “10:2” 是无效的，应为 “10:02”。

 */
public class BinaryWatch {
    private List<String> ret = new ArrayList<>();
    public List<String> readBinaryWatch(int num) {
        int[] clocks = new int[10];
        for (int i = 0; i < clocks.length; i++) {
            clocks[i] = 1;
        }
        clock(clocks, num, 0);
        Collections.sort(ret);
        return ret;
    }

    private void clock(int[] clocks, int num,int curPos){
        if(num<0)
            return;
        if(curPos == clocks.length){
            if( num == 0){
                int hour = 0;
                int minutes = 0;
                if( (hour = countHour(clocks)) <12 && (minutes = countMinutes(clocks)) <60 ){
                    //说明取到的小时和分钟都是合法的，可以将其作为一组有效结果
                    StringBuilder s = new StringBuilder();
                    s.append(hour);
                    s.append(":");
                    if(minutes<10){
                        s.append('0');
                        s.append(minutes);
                    }else{
                        s.append(minutes);
                    }
                    ret.add(s.toString());
                }
            }
            return;
        }


        //case1.下一位为1
        clock(clocks,num-1,curPos+1);
        clocks[curPos] = 0;
        //case2下一位为0
        clock(clocks,num, curPos+1);
        //恢复现场
        clocks[curPos] = 1;

    }


    private int countHour(int[] clocks){
        int carry = 0;
        int hour = 0;
        for (int i = 0; i < 4; i++) {
            if(clocks[i]==1)
                hour += Math.pow(2,carry);
            carry++;
        }
        return hour;
    }

    private int countMinutes(int[] clocks){
        int carry = 0;
        int minutes = 0;
        for (int i = 4; i < 10; i++) {
            if(clocks[i]==1){
                minutes += Math.pow(2,carry);
            }
            carry++;
        }
        return minutes;
    }


    public static void main(String[] args) {
        int n = 1;
        List<String> strings = new BinaryWatch().readBinaryWatch(n);
        strings.forEach(System.out::println);
    }
}


