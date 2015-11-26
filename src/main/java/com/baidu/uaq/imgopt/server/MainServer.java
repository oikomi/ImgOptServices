package com.baidu.uaq.imgopt.server;

import com.alibaba.fastjson.JSON;
import com.baidu.uaq.imgopt.bean.RespCmd;
import com.baidu.uaq.imgopt.config.Config;
import com.baidu.uaq.imgopt.config.Const;
import com.baidu.uaq.imgopt.db.Redis;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by miaohong01 on 15/11/13.
 */
public class MainServer extends HttpServlet {
    private Config config = Config.getInstance();

    @Override
    public void init() throws ServletException {
        File f = new File(Const.DOWNLOAD_IMG_BASE_PATH);
        f.mkdirs();
        f = new File(Const.OPT_IMG_BASE_PATH);
        f.mkdirs();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();

        pw.print("ok");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        RespCmd respCmd = new RespCmd();
        StringBuilder buffer = new StringBuilder();
        BufferedReader reader = req.getReader();
        String line;
        while ((line = reader.readLine()) != null) {
            buffer.append(line);
        }
        String reqBody = buffer.toString();

        if (reqBody == null) {
            respCmd.setCode(-1);
            respCmd.setInfo("error");
        }

        Redis redis = new Redis(config.getRedisAddr(), config.getRedisPort());
        redis.pushTask(reqBody);
        respCmd.setCode(0);
        respCmd.setInfo("success");

        pw.print(JSON.toJSON(respCmd));
    }
}
