package com.baidu.uaq.imgopt.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by miaohong01 on 15/11/16.
 */
public class Shell {
    private static final Logger LOG = LogManager.getLogger(Shell.class);

    public static String runCmd(String cmd) {
        if (cmd == null) {
            return null;
        }
        try {
            Process ps = Runtime.getRuntime().exec(cmd);
            ps.waitFor();

            BufferedReader br = new BufferedReader(new InputStreamReader(ps.getInputStream()));
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = br.readLine()) != null) {
                // sb.append(line).append("\n");
            }
            String result = sb.toString();
            // System.out.println(result);

            return result;
        }
        catch (Exception e) {
            LOG.error("run cmd failed | " + cmd);
            e.printStackTrace();
        }
        return null;
    }
}
