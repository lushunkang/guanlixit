package com.xlsy.dao;

import com.xlsy.pojo.Resultinfo;
import com.xlsy.pojo.UserSerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper//关于ResultInfo数据表的数据库操作
public interface ResultInfoDao {
    //查询信息
    @Select("SELECT resultId,serId,serUserNickName,serType,serTime,serName,serUserTel,serSpendMoney,serSpendTime,serContent,serManager,resultManager,serRead,resultUserBack,resultUsereVal,resultTimei FROM resultinfo,userserinfo WHERE resultinfo.resultSerId=userserinfo.serId")
    List<Resultinfo> selectuserser (Resultinfo result);

    //根据服务结果查询返回的id查询服务selectByresultId
    @Select("select * from userserinfo,resultinfo where resultSerId=#{serId} and serId=#{serId}")
    Resultinfo selectByresultId (Resultinfo result);

    //把修改的数据插入到服务结果数据库中uprequist
    @Update("update resultinfo set resultUserBack=#{resultUserBack},resultUsereVal=#{resultUsereVal} where resultSerId=#{serId}")
    int uprequist(Resultinfo result);

    //根据服务ID查询
    @Select("select * from userserinfo,resultinfo where resultId=#{resultId} and serId=resultSerId")
    List<Resultinfo> findBySerId (Resultinfo result);

    //根据服务类型
    @Select("select * from userserinfo,resultinfo where serType=#{serType} and serId=resultSerId")
    List<Resultinfo> findByserType (Resultinfo  result);

    //根据服务时间
    @Select("select * from userserinfo,resultinfo where serTime=#{serTime} and serId=resultSerId")
    List<Resultinfo> findByserTime(Resultinfo  result);

    //根据服务处理人
    @Select("select * from userserinfo,resultinfo where resultManager=#{resultManager} and serId=resultSerId")
    List<Resultinfo> findByPeople (Resultinfo  result);

    //根据服务完成时间
    @Select("select * from userserinfo,resultinfo where resultTimei=#{resultTimei} and serId=resultSerId")
    List<Resultinfo> findByoverTime(Resultinfo  result);

}
