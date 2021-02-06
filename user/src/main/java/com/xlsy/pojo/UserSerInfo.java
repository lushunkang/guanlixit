package com.xlsy.pojo;

import java.io.Serializable;

public class UserSerInfo extends MyPage implements Serializable {
    private int serId;
    private String serUserNickName;
    private String serType;
    private String serTime;
    private String serName;
    private String serUserTel;
    private String serSpendMoney;
    private String serSpendTime;
    private String serContent;
    private String serManager;
    private String serRead;
    //描述查询条件condition的参数
    private String condition;
    //描述查询条件ConValue的参数
    private  String conValue;

    public int getSerId() {
        return serId;
    }

    public void setSerId(int serId) {
        this.serId = serId;
    }

    public String getSerUserNickName() {
        return serUserNickName;
    }

    public void setSerUserNickName(String serUserNickName) {
        this.serUserNickName = serUserNickName;
    }

    public String getSerType() {
        return serType;
    }

    public void setSerType(String serType) {
        this.serType = serType;
    }

    public String getSerTime() {
        return serTime;
    }

    public void setSerTime(String serTime) {
        this.serTime = serTime;
    }

    public String getSerName() {
        return serName;
    }

    public void setSerName(String serName) {
        this.serName = serName;
    }

    public String getSerUserTel() {
        return serUserTel;
    }

    public void setSerUserTel(String serUserTel) {
        this.serUserTel = serUserTel;
    }

    public String getSerSpendMoney() {
        return serSpendMoney;
    }

    public void setSerSpendMoney(String serSpendMoney) {
        this.serSpendMoney = serSpendMoney;
    }

    public String getSerSpendTime() {
        return serSpendTime;
    }

    public void setSerSpendTime(String serSpendTime) {
        this.serSpendTime = serSpendTime;
    }

    public String getSerContent() {
        return serContent;
    }

    public void setSerContent(String serContent) {
        this.serContent = serContent;
    }

    public String getSerManager() {
        return serManager;
    }

    public void setSerManager(String serManager) {
        this.serManager = serManager;
    }

    public String getSerRead() {
        return serRead;
    }

    public void setSerRead(String serRead) {
        this.serRead = serRead;
    }

    public String getCondition() {
        if (condition==null)
        {
            return "";
        }
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getConValue() {
        if (conValue==null)
        {
            return "";
        }
        return conValue;
    }

    public void setConValue(String conValue) {
        this.conValue = conValue;
    }
}
