package com.pccc.demo;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author jinquanhua
 * @date 2020/5/27 23:08
 */
public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        byte [] bytes = new byte[1024];
        int len;
        len = inputStream.read(bytes);
        System.out.println(new String(bytes,0,len));
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("收到，谢谢".getBytes());
        socket.close();
        serverSocket.close();
    }

}
