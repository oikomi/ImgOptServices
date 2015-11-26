package com.baidu.uaq.imgopt.util;

import com.baidu.uaq.imgopt.config.Const;

/**
 * Created by miaohong01 on 15/11/19.
 */
public class Util {

    public static String getPicBaseName(String url) {
        String[] urlList = url.split("\\?");
        String[] pathList = urlList[0].split("/");
        String baseName = pathList[(pathList.length) - 1];
        return baseName;
    }

    public static String getShellCmdByPicType(String url, String orgImgStorePath) {
        String cmd = null;
        String[] urlList = url.split("\\?");
        String[] pathList = urlList[0].split("/");
        String baseName = pathList[(pathList.length) - 1];
        String ext = baseName.split("\\.")[1].toLowerCase();

        if (ext == null) {
            return null;
        }

        if ("jpg".equals(ext)) {
            cmd = Const.CONVERT_CMD +  " " + orgImgStorePath + " " + " -quality 70%  " +
                    Const.OPT_IMG_BASE_PATH + MD5.CalcMD5(url) + baseName;
        } else if ("png".equals(ext)) {
            cmd = Const.PNGQUANT_CMD + " -f " + orgImgStorePath + " -o  " +
                    Const.OPT_IMG_BASE_PATH + MD5.CalcMD5(url) + baseName;
        } else {

        }

        return cmd;
    }
}
