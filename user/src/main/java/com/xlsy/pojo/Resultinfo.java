package com.xlsy.pojo;

import java.io.Serializable;

public class Resultinfo extends UserSerInfo implements Serializable {
    private int resultId;
    private String resultManager;
    private int resultSerId;
    private String resultUserBack;
    private String resultUsereVal;
    private String resultTimei;
    //记录当前登录人的名字
    private String resultName;


    public int getResultId() {
        return resultId;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public String getResultManager() {
        return resultManager;
    }

    public void setResultManager(String resultManager) {
        this.resultManager = resultManager;
    }

    public int getResultSerId() {
        return resultSerId;
    }

    public void setResultSerId(int resultSerId) {
        this.resultSerId = resultSerId;
    }

    public String getResultUserBack() {
        return resultUserBack;
    }

    public void setResultUserBack(String resultUserBack) {
        this.resultUserBack = resultUserBack;
    }

    public String getResultUsereVal() {
        return resultUsereVal;
    }

    public void setResultUsereVal(String resultUsereVal) {
        this.resultUsereVal = resultUsereVal;
    }

    public String getResultTimei() {
        return resultTimei;
    }

    public void setResultTimei(String resultTimei) {
        this.resultTimei = resultTimei;
    }

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }


}
