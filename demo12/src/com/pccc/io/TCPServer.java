package com.pccc.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author jinquanhua
 * @date 2020/6/2 11:26
 */
public class TCPServer {
    public static void main(String[] args)  throws IOException{
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {


                        Socket socket = serverSocket.accept();
                        InputStream is = socket.getInputStream();
                        OutputStream os = socket.getOutputStream();
                        FileOutputStream fos = new FileOutputStream("D:\\qwe.txt");
                        byte[] bytes = new byte[1024];
                        int len;
                        while ((len = is.read(bytes)) != -1) {
                            fos.write(bytes);
                        }
                        os.write("服务器已收到".getBytes());
                        fos.close();
                        socket.close();
                    } catch (IOException ioe) {
                        ioe.printStackTrace();
                    }

                }
            }).start();

//        serverSocket.close();
        }
    }
}
