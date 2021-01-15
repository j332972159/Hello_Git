package com.pccc.demo.util;

/**
 * @Author jinquanhua
 * @date 2020/12/25 11:03
 */
public class StringUtil {
    public static void main(String[] args) {
        String str = "a,s,d,f,g,h,,k,,";
        String[] split = str.split(",");
        System.out.println(split.length);
        System.out.println(split[split.length-2]);
        String s = split[split.length - 2];
        if (s == null){
            System.out.println("s is null");
        }else if(s.equals("")){
            System.out.println("s is \"\"");
        }
        System.out.println("first modify");
    }
}
