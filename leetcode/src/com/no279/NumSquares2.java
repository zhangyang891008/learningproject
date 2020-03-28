package com.no279;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
方法二：广度优先遍历
 */
public class NumSquares2 {
    public int numSquares(int n) {

        int max_square = (int)(Math.sqrt(n)+1);
        int[] squares = new int[max_square];
        for (int i = 1; i < max_square; i++) {
            squares[i] = i*i;
        }

        Set<Integer> set = new HashSet<>();
        set.add(n);
        int level = 0;

        while(set.size()>0){
            level++;
            Set<Integer> nextSet = new HashSet<>();

            for (Integer cur : set) {
                for (int s = 0; s < max_square; s++) {
                    if(cur == squares[s]){
                        return level;  //成功直接返回
                    }else if(cur < squares[s]){
                        break;   //平方大直接剪枝
                    }else{
                        nextSet.add(cur-squares[s]); //计算减去平方数以后剩下的值，进入下一轮
                    }
                }
            }
            set = nextSet;

        }
        return level;
    }


    public static void main(String[] args) {

    }
}
