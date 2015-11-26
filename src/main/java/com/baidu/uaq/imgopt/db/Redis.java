package com.baidu.uaq.imgopt.db;

import com.baidu.uaq.imgopt.config.Config;
import redis.clients.jedis.Jedis;

/**
 * Created by miaohong01 on 15/11/13.
 */
public class Redis {
    private Config config = Config.getInstance();
    private Jedis jedis;
    private String redisAddr;
    private int redisPort;

    public Redis(String redisAddr, int redisPort) {
        this.redisAddr = redisAddr;
        this.redisPort = redisPort;
    }

    private void conn() {
        jedis = new Jedis(redisAddr, redisPort);
    }

    public void addKV(String key, String value) {
        conn();
        jedis.set(key, value);
        jedis.expire(key, 3600 * 2);
    }

    public void pushTask(String task) {
        conn();
        jedis.lpush(config.getTaskList(), task);
    }

    public String popTask(String task) {
        conn();
        return jedis.rpop(config.getTaskList());
    }

}
