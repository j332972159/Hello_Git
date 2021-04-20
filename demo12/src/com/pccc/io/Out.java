package com.pccc.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @Author jinquanhua
 * @date 2020/6/2 0:23
 */
public class Out {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("c.txt");
        for (int i = 0;i<10;i++){
            byte[] bytes = new byte[]{49,50,51,52,53,54};
            fos.write(bytes);
            fos.write("\r\n".getBytes());
            fos.flush();
        }
        fos.close();
    }
}
