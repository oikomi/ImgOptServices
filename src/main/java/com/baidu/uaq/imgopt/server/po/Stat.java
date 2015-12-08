package com.baidu.uaq.imgopt.server.po;

/**
 * Created by baidu on 15/12/8.
 */
public class Stat {
    int id;
    int request_id;
    float duration;
    float user_cpu;
    float sys_cpu;
    int mem_peak_usage;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRequest_id() {
        return request_id;
    }

    public void setRequest_id(int request_id) {
        this.request_id = request_id;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(float duration) {
        this.duration = duration;
    }

    public float getUser_cpu() {
        return user_cpu;
    }

    public void setUser_cpu(float user_cpu) {
        this.user_cpu = user_cpu;
    }

    public float getSys_cpu() {
        return sys_cpu;
    }

    public void setSys_cpu(float sys_cpu) {
        this.sys_cpu = sys_cpu;
    }

    public int getMem_peak_usage() {
        return mem_peak_usage;
    }

    public void setMem_peak_usage(int mem_peak_usage) {
        this.mem_peak_usage = mem_peak_usage;
    }

}
