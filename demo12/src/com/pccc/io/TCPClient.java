package com.pccc.io;

import java.io.*;
import java.net.Socket;

/**
 * @Author jinquanhua
 * @date 2020/6/2 18:34
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("D:\\aa.txt");
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream os = socket.getOutputStream();
        int len ;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes))!= -1){
            os.write(bytes);
        }
        socket.shutdownOutput();
        InputStream is = socket.getInputStream();

        while((len = is.read(bytes))!=-1){
            System.out.println(new String(bytes,0,len));
        }

        fis.close();
        socket.close();
    }
}
