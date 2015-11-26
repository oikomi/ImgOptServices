package com.baidu.uaq.imgopt.util;

import com.baidu.uaq.imgopt.bean.PicAttr;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by miaohong01 on 15/11/9.
 */
public class FileUtil {
    private static final Logger LOG = LogManager.getLogger(FileUtil.class);

    public static void write(String filePath, String data) {
        try {
            FileWriter wd = new FileWriter(filePath);
            wd.write(data);
            wd.close();
        } catch (IOException e) {
            LOG.error("writeHar failed");
            e.printStackTrace();
        }
    }

    public static void clear(List<String> deleteFileList) {
        for (String f : deleteFileList) {
            deleteFile(f);
        }
    }

    public static boolean deleteFile(String sPath) {
        boolean flag = false;
        File file = new File(sPath);
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    public static long getFileSize(String filename) {
        File file = new File(filename);
        if (!file.exists() || !file.isFile()) {
            System.out.println("文件不存在");
            return -1;
        }
        return file.length();
    }

    public static PicAttr getPicAttr(String filename) {
        PicAttr picAttr = new PicAttr();
        File file = new File(filename);
        BufferedImage bi = null;
        try {
            bi = ImageIO.read(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        int width = bi.getWidth();
        int height = bi.getHeight();

        picAttr.setHeight(height);
        picAttr.setWidth(width);
        picAttr.setSize(getFileSize(filename));

        return picAttr;
    }

    public static boolean deleteDir(File dir) {
        if (dir.isDirectory()) {
            String[] children = dir.list();
            for (int i=0; i<children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }

                return true;
            }
        }

        return false;
    }
}