package com.xlsy.service;

import com.xlsy.pojo.Resultinfo;
import com.xlsy.pojo.UserInfo;
import com.xlsy.pojo.UserSerInfo;

import java.util.HashMap;

public interface UserInfoService {

    //查询用户数据
    UserInfo select(UserInfo user);

    //修改保存用户信息
    String userUpdate(UserInfo user);

    //注销用户信息
    String delUser(UserInfo user);

    //查询用户当前提交的服务申请
    HashMap<String,Object> selectuserser(UserInfo user, UserSerInfo ser);

    //查询服务数据
    UserSerInfo selectByserId(UserSerInfo ser);

    //修改
    String upService(UserSerInfo ser);

    //删除服务数据
    String delservice(UserSerInfo ser);

    //新增服务的查询用户信息
    UserInfo selectUserSer(UserSerInfo ser);

    //保存当前新增服务
    String  serveadd(UserSerInfo ser);

    //查询服务返回结果
     HashMap<String,Object> selectresult(Resultinfo resu);

     //根据服务结果查询返回的id查询服务selectByresultId
     Resultinfo selectByresultId(Resultinfo result);

     //修改当前服务信息uprequist
    String uprequist(Resultinfo result);
}
