package com.pccc.demo;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;


/**
 * @Author jinquanhua
 * @date 2020/5/25 22:24
 */
public class Test2 {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("D:\\aa.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("D:\\bb.txt",true));

            String line;
            while ((line = br.readLine())!=null) {
                String[] split = line.split("\\.");
                map.put(split[0], split[1]);

            }
        Set<Map.Entry<String, String>> entries = map.entrySet();
        for (Map.Entry<String, String> entry : entries) {
            System.out.println(entry.getKey()+"."+entry.getValue());
            bw.write(entry.getKey()+"."+entry.getValue());
            bw.newLine();
        }
        bw.close();
        br.close();
        writeHello();
    }

    private static void writeHello() {

    }
}
