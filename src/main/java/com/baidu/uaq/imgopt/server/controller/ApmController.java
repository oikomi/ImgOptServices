package com.baidu.uaq.imgopt.server.controller;

import com.baidu.uaq.imgopt.bean.RespCmd;
import com.baidu.uaq.imgopt.db.Redis;
import com.baidu.uaq.imgopt.server.po.Stat;
import com.baidu.uaq.imgopt.server.services.ApmService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by baidu on 15/12/8.
 */

@Controller
@RequestMapping("/uaq/v1")
public class ApmController {

    @Resource
    private ApmService apmService;

    @RequestMapping(value = "/apm", method = RequestMethod.GET)
    public @ResponseBody Stat apm(@RequestBody String reqBody) {
        try {
            return apmService.getStatById(Integer.parseInt(reqBody));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

}
