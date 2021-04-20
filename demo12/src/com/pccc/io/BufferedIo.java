package com.pccc.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author jinquanhua
 * @date 2020/6/23 21:28
 */
public class BufferedIo {
    public static void main(String[] args) {
        BufferedWriter bw = null;
        try {
            List<String> list = new ArrayList<>();
            list.add("aa  aa");
            list.add("bbaa   ddfv");
            list.add("cc");
            list.add("dd");
            for (String s : list) {
          bw =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File("d:\\abcd.txt"),true)));
                bw.write(s,0,s.length());
                bw.newLine();
                bw.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bw!=null){
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
