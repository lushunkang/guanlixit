package com.xlsy.dao;

import com.xlsy.pojo.UserInfo;
import com.xlsy.pojo.UserSerInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;

@Mapper//关于userinfo数据表的数据库操作
public interface UserInfoDao {
    //用户信息查询
    @Select("select *from userInfo where userName=#{userName} ")
    UserInfo selectuser(UserInfo user);

    //修改用户信息
    @Update("update userinfo set userName=#{userName},name=#{name},userSex=#{userSex},userBir=#{userBir},userTel=#{userTel},userEmail=#{userEmail},userEdu=#{userEdu},userIdCard=#{userIdCard},userUnit=#{userUnit},userManager=#{userManager},userText=#{userText} where userId=#{userId}")
    int updateUserInfo(UserInfo user);

    //注销用户信息
    @Delete("delete from userInfo where userId=#{userId}")
    int deluse(UserInfo user);

    //查询当前昵称是否存在（重名）
    @Select("select count(*) from userInfo where userName=#{userName} and userId!=#{userId}")
    int seluserName(UserInfo user);

    //查询当前用户的姓名，昵称，电话信息
    @Select("select userName,name,userTel,userManager from userInfo where userName=#{serUserNickName} ")
    UserInfo selectUserSer(UserSerInfo ser);





}
