package com.pccc.demo;



import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @Author jinquanhua
 * @date 2020/5/26 0:18
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8000);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好服务器".getBytes());
        InputStream inputStream = socket.getInputStream();
        byte [] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        System.out.println(new String(bytes,0,read));
        socket.close();
    }


}
