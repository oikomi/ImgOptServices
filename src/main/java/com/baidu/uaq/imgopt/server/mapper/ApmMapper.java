package com.baidu.uaq.imgopt.server.mapper;

import com.baidu.uaq.imgopt.server.po.Stat;

/**
 * Created by baidu on 15/12/8.
 */
public interface ApmMapper {
    public Stat getStat(int id) throws Exception;
}
