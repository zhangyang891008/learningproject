package com.no216;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
216. 组合总和 III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]

 */
public class CombinationSum3 {

    List<List<Integer>> retList = new LinkedList<>();
    Stack<Integer> stack = new Stack<>();
    //int count = 0;

    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] arr = new int[4];
        combina(n,k,0,1);
        System.out.println("count:" + count);
        return retList;
    }

    private void combina(int sum ,int num,int tempSum,int pos){

        //count++;

        if(stack.size()==num && tempSum == sum){
            retList.add(new LinkedList<>(stack));
            return;
        }

        if(stack.size()==num){
            return;
        }

        for (int i = pos; i < 10; i++) {
            //if(pos + tempSum > sum) return;
            //一个更有效的剪枝的方法

            if((num - stack.size()) * pos > sum - tempSum){
                return ;
            }

            stack.push(i);
            combina(sum, num, tempSum + i, i +1);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        int k = 3;
        int n = 8;
        List<List<Integer>> lists = new CombinationSum3().combinationSum3(k, n);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
