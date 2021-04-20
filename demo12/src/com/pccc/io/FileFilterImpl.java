package com.pccc.io;

import java.io.File;
import java.io.FileFilter;

/**
 * @Author jinquanhua
 * @date 2020/6/1 23:48
 */
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory()){
            return true;
        }
        return pathname.getName().toLowerCase().endsWith(".exe");
    }
}
