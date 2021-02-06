package com.xlsy.service;

import com.xlsy.pojo.UserInfo;
import com.xlsy.pojo.UserSerInfo;

import java.util.HashMap;

public interface ManagerInfoService {

    //查询经理收到的所有服务请求
    HashMap<String,Object> selectresilt( UserSerInfo ser);

}
