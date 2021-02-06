package com.xlsy.dao;

import com.xlsy.pojo.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper//这个结果执行mangerinfo的数据库操作
public interface ManagerInfoDao {
    //查询管理员是否存在
    @Select("select count(*) from managerinfo where managerNickName=#{userManager}")
    int seluserManger(UserInfo user);
}
