package com.pccc.io;

import java.io.File;

/**
 * @Author jinquanhua
 * @date 2020/6/1 22:40
 */
public class FileDemo {
    public static void main(String[] args) {
        String pathSeparator = File.pathSeparator;
        System.out.println(pathSeparator);
        String separator = File.separator;
        System.out.println(separator);
        File file = new File("D:\\Git");
        System.out.println(file.getName());
        File file1 = new File("D:\\Git\\bin\\bash.exe");
        System.out.println(file1.getName());
        getAllFiles(file);
    }

    private static void getAllFiles(File file) {
        File[] files = file.listFiles(new FileFilterImpl());
        for (File f : files) {
            if (f.isDirectory()){
                getAllFiles(f);
            }else{
                System.out.println(f);
            }
        }
    }
}
