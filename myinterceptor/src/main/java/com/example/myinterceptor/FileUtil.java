package com.example.myinterceptor;

import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by ryan on 18-8-31.
 *
 * 在这里我们主要是 包缓存的文件 保存起来
 * */

public class FileUtil {

    // Interceptor 为保存在SD卡里根目录的文件名
    public static final String EXTERNAL_DIRECTORY_NAME = "Interceptor";

    //判断外部存储是否能用

    public static boolean isSDCardAvailable(){
        String state = Environment.getExternalStorageState();
        return Environment.MEDIA_MOUNTED.equals(state);
    }

    //获取外部存储的根目录 路径
    public static String getSDcardPath() throws IOException{
        if (isSDCardAvailable()){
            return Environment.getExternalStorageDirectory().getAbsolutePath();
        }else {
            throw  new FileNotFoundException("没有外部存储");
        }
    }

    /**
     * 获取程序的外部存储的数据存放根目录
     *
     * @return
     */
    public static String getAppRootDirectoryPath() {
        if (isSDCardAvailable()) {
            try {
                String path = getSDcardPath();
                File file = new File(path, EXTERNAL_DIRECTORY_NAME);
                if (!file.exists()) {
                    file.mkdirs();
                }
                return file.getAbsolutePath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    //获取外部缓存的地址
    public static String getExternalCacheDirectory(){
        if (isSDCardAvailable()){
            String path = getAppRootDirectoryPath();
            File file = new File(path,"cache");
            if (!file.exists()){
                file.mkdirs();
            }
            return file.getAbsolutePath();
        }
        return null;
    }

    /**
     * 删除文件或文件夹
     *
     * @param file
     * @throws IOException
     */
    public static void deleteFile(File file) throws IOException {
        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                deleteFile(f);
            }
        } else {
            file.delete();
        }
    }


}
