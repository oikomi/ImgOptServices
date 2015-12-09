package com.baidu.uaq.imgopt.server.controller;

import com.baidu.uaq.imgopt.bean.RespCmd;
import com.baidu.uaq.imgopt.config.Config;
import com.baidu.uaq.imgopt.config.Const;
import com.baidu.uaq.imgopt.db.Redis;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;

/**
 * Created by baidu on 15/12/7.
 */

@Controller
@RequestMapping("/uaq/v1")
public class ImgController {
    private Config config = Config.getInstance();

    @PostConstruct
    public void init() {
        File f = new File(Const.DOWNLOAD_IMG_BASE_PATH);
        f.mkdirs();
        f = new File(Const.OPT_IMG_BASE_PATH);
        f.mkdirs();
    }

    @RequestMapping(value = "/imgopt", method = RequestMethod.GET)
    public @ResponseBody RespCmd imgoptMonitor() {
        RespCmd respCmd = new RespCmd();

        respCmd.setCode(0);
        respCmd.setInfo("success");

        return respCmd;
    }

    @RequestMapping(value = "/imgopt", method = RequestMethod.POST)
    public @ResponseBody RespCmd imgopt(@RequestBody String reqBody) {
        RespCmd respCmd = new RespCmd();
        if (reqBody == null) {
            respCmd.setCode(-1);
            respCmd.setInfo("error");

            return respCmd;
        }

        Redis redis = new Redis(config.getRedisAddr(), config.getRedisPort());
        System.out.println("store in redis");
        redis.pushTask(reqBody);
        System.out.println("store in redis  end");

        CloseableHttpClient httpclient = HttpClients.createDefault();
        CloseableHttpResponse response = null;
//        try {
//            HttpGet httpget = new HttpGet("http://127.0.0.1:8020/uaq/v1/doimgopt");
//            response = httpclient.execute(httpget);
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            if (response != null) {
//                try {
//                    response.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }

        respCmd.setCode(0);
        respCmd.setInfo("success");

        return respCmd;
    }
}
