package com.no551;
/*
551.学生出勤记录I
给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：

'A' : Absent，缺勤
'L' : Late，迟到
'P' : Present，到场
如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。

你需要根据这个学生的出勤记录判断他是否会被奖赏。

示例 1:

输入: "PPALLP"
输出: True
示例 2:

输入: "PPALLL"

 */
public class CheckRecord {
    public boolean checkRecord(String s) {
        if(s == null)
            return false;
        int absent = 0;
        int late = 0;
        boolean flag = true;
        s = s.toUpperCase();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'A':
                    absent++;
                    late = 0;
                    break;
                case 'L':
                    late++;
                    break;
                case 'P':
                    late = 0;
                    break;
                default:

            }
            if(late>2 || absent>1){
                flag = false;
                break;
            }
        }
        return flag;
    }


    public static void main(String[] args) {
        String record = "PPALLL";
        boolean b = new CheckRecord().checkRecord(record);
        System.out.println(b);
    }
}
