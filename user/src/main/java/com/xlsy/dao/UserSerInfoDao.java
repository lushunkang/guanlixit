package com.xlsy.dao;

import com.xlsy.pojo.UserInfo;
import com.xlsy.pojo.UserSerInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper//关于userinfo数据表的数据库操作
public interface UserSerInfoDao {
    //查询当前用户申请的服务
    @Select("select * from userserinfo where  serUserNickName=#{serUserNickName}")
    List<UserSerInfo> selectuserser (UserSerInfo ser);

    //根据服务ID查询
    @Select("select * from userserinfo where serId=#{serId}")
    List<UserSerInfo> findBySerId (UserSerInfo ser);

    //根据服务类型
    @Select("select * from userserinfo where serType=#{serType}")
    List<UserSerInfo> findByserType (UserSerInfo ser);

    //根据服务时间
    @Select("select * from userserinfo where serTime=#{serTime}")
    List<UserSerInfo> findByserTime(UserSerInfo ser);

    //根据服务是否已读
    @Select("select * from userserinfo where serRead=#{serRead}")
    List<UserSerInfo> findByserRead (UserSerInfo ser);

    //根据服务ID查询
    @Select("select * from userserinfo where serId=#{serId}")
    UserSerInfo selectByserId (UserSerInfo ser);

    //修改
    @Update("update userserinfo set serType=#{serType},serTime=#{serTime},serUserTel=#{serUserTel},serSpendMoney=#{serSpendMoney},serSpendTime=#{serSpendTime},serContent=#{serContent} where serId=#{serId}")
    int upService(UserSerInfo ser);

    //删除服务delservice
    @Delete("delete from userserinfo where serId=#{serId}")
    int delservice(UserSerInfo ser);

    //插入新增服务
    @Insert("insert into userserinfo (serUserNickName,serType,serTime,serName,serUserTel,serSpendMoney,serSpendTime,serContent,serManager,serRead) value (#{serUserNickName},#{serType},#{serTime},#{serName},#{serUserTel},#{serSpendMoney},#{serSpendTime},#{serContent},#{serManager},#{serRead})")
    int serveadd(UserSerInfo ser);

    //查询当前经理收到的所有服务请求selectresilt
    @Select("select * from userserinfo where serManager=#{serManager}")
    List<UserSerInfo> selectresilt(UserSerInfo ser);
}
