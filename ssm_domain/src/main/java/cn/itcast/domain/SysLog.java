package cn.itcast.domain;

import cn.itcast.util.DateUtil;

import java.io.Serializable;
import java.util.Date;

public class SysLog implements Serializable{

    private Long id;

    private Date visitTime;

    private String visitTimeStr;

    private String username;

    private String ip;

    private String method;

    private String executeMsg;

    private String executeResult;

    private Long executeTime;

    public String getExecuteMsg() {
        return executeMsg;
    }

    public void setExecuteMsg(String executeMsg) {
        this.executeMsg = executeMsg;
    }

    public String getExecuteResult() {
        return executeResult;
    }

    public void setExecuteResult(String executeResult) {
        this.executeResult = executeResult;
    }

    public Long getExecuteTime() {
        return executeTime;
    }

    public void setExecuteTime(Long executeTime) {
        this.executeTime = executeTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getVisitTimeStr() {
        return visitTimeStr;
    }

    public void setVisitTimeStr(String visitTimeStr) {
        this.visitTimeStr = visitTimeStr;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "SysLog{" +
                "id=" + id +
                ", visitTime=" + visitTime +
                ", visitTimeStr='" + visitTimeStr + '\'' +
                ", username='" + username + '\'' +
                ", ip='" + ip + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
