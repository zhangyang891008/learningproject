package com.no93;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/*
93. 复原IP地址
给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

示例:

输入: "25525511135"
输出: ["255.255.11.135", "255.255.111.35"]

**********
减枝：三位数大于256
    剩余字符串应该至多不超过每part3位，不少于每part1位；
    0为首位的时候，只能是1位数
注意：拼接字符串，首位不加"."

 */
public class RestoreIpAddresses {

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        resolveAddr(result,"",s,0);
        return result;
    }

    private static void resolveAddr(List result,String addressString, String tempString, int partNo){
        if(partNo == 3){
            if(tempString!=null && tempString.length()>0 && Integer.valueOf(tempString)<256){
                //特殊字符0为首位
                if(tempString.charAt(0)=='0' && tempString.length()>1)
                    return;
                result.add(addressString+"."+tempString);
            }

            return;
        }
        //剪枝，位数
        if(tempString ==null || tempString.length() > (4-partNo)*3 || tempString.length()<(4-partNo))
            return;
        //如果剩余不超过3为，则取剩余位数，不能越界
        int times = Math.min(3,tempString.length());

        for (int i = 0; i < times; i++) {
            //特殊情况，0为首位
            if(tempString.charAt(0) == '0'){
                resolveAddr(result,((addressString.length() < 1) ? "" : addressString+".") + tempString.substring(0, 1), tempString.substring(1), partNo + 1);
                break;
            }
            //如果是3位数不能超过255
            if( i<2 || Integer.valueOf(tempString.substring(0,3))<256 ) {
                resolveAddr(result,((addressString.length() < 1) ? "" : addressString+".") + tempString.substring(0, i + 1), tempString.substring(i + 1), partNo + 1);
            }
        }
    }
    public static void main(String[] args) {
        String address = "010010";
        List<String> strings = new RestoreIpAddresses().restoreIpAddresses(address);
        for (String string : strings) {
            System.out.println(string);
        }
    }
}
