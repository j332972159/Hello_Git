package com.pccc.demo;

import java.util.*;

/**
 * @Author jinquanhua
 * @date 2020/6/1 0:07
 */
public class Demo1 {
    public static void main(String[] args) {
        String str = "a,b,c,,d";
        String[] ary = str.split(",");
        System.out.println(str.endsWith(","));
        for (String s : ary) {
            System.out.println(s);
        }
        byte[] bytes = new byte[]{56,57,58,59};
        System.out.println(bytes);
        System.out.println(Arrays.toString(bytes));
        System.out.println(new String(bytes));
        System.out.println(ary.length);
        HashMap<String,String> map = new HashMap();
        HashMap<String,String> map1 = new HashMap<>();
        HashMap<String,String> map2 = new HashMap<String,String>();
        map.put("11","11");
        map.put("22","11");
        map.put("33","11");
        map.put("44","11");
        map.put("55","11");
        Set<Map.Entry<String, String>> entries = map.entrySet();
        Set<String> set = map.keySet();
        map.forEach((key,value) ->{
            System.out.println(key +":"+value);
        });

        for(int i = 0;i < 100;i++){
            double random = Math.random();
            System.out.print((int)(random*10));
        }
        System.out.println("=======================");
        for (int i = 0;i < 100;i++){

            Random random1 = new Random();
            System.out.print(random1.nextInt(10));
        }
        /*int num;
        switch (num){

            case 1:
                break;
            default:
                break;
        }*/
    }
}
