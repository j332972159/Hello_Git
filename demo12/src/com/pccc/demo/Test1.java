package com.pccc.demo;

import sun.awt.FwDispatcher;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

/**
 * @Author jinquanhua
 * @date 2020/5/24 22:04
 */
public class Test1 {
    public static void main(String[] args) {

        Properties pro = new Properties();
        try (FileWriter fw = new FileWriter("D:\\a.txt");
             FileReader fr = new FileReader("D:\\b.txt");
             ){
            pro.setProperty("aa","aa");
            pro.setProperty("bb","bb");
            pro.setProperty("cc","cc");
            pro.load(fr);
            pro.store(fw,"save pro");
        } catch (IOException e) {
            e.printStackTrace();
        }


        Set<String> set = pro.stringPropertyNames();
        for (String key : set) {
            System.out.println(key +":   "+pro.getProperty(key));
        }
    }
}
