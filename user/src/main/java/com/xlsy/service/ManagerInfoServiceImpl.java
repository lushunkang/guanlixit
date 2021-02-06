package com.xlsy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlsy.dao.ManagerInfoDao;
import com.xlsy.dao.ResultInfoDao;
import com.xlsy.dao.UserInfoDao;
import com.xlsy.dao.UserSerInfoDao;
import com.xlsy.pojo.UserSerInfo;
import com.xlsy.util.MdFive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service//实现ManagerInfoService的接口功能
public class ManagerInfoServiceImpl implements ManagerInfoService {

    //创建一个userInfoDao的实现类对象
    @Autowired(required = false)
    UserInfoDao userInfoDao;
    //创建一个ManagerInfoDao的实现类对象
    @Autowired(required = false)
    ManagerInfoDao managerInfoDao;
    //创建一个UserSerInfoDao的实现类对象
    @Autowired(required = false)
    UserSerInfoDao userSerInfoDao;
    //创建一个ResultInfoDao的实现类对象
    @Autowired(required = false)
    ResultInfoDao resultInfoDao;

    //创建加密工具类对象
    @Autowired
    MdFive mdfive;

    //查询经理收到的所有服务请求
    @Override
    public HashMap<String, Object> selectresilt(UserSerInfo ser) {
        HashMap<String, Object> map=new HashMap<String, Object>();
        //1设置分页参数
        PageHelper.startPage(ser.getPage(),ser.getRow());
        //2查询数据库表数据
        List<UserSerInfo> list=new ArrayList<>();

        //判断用户输入的查询条件是否有值
        if(ser.getConValue().equals("")) {
            //空值查询所有
            list=userSerInfoDao.selectresilt(ser);
        }else {
            //根据用户选择的查询条件，判断用户需要查询的
            if (ser.getCondition().equals("编号")) {
                //设置用户输入的查询条件
                ser.setSerId(Integer.parseInt(ser.getConValue()));
                list = userSerInfoDao.findBySerId(ser);
            }  else if (ser.getCondition().equals("服务类型"))
            {
                //服务类型的查询
                ser.setSerType(ser.getConValue());
                list = userSerInfoDao.findByserType(ser);
            }else if (ser.getCondition().equals("服务日期")){
                //服务时间的查询
                ser.setSerTime(ser.getConValue());
                list = userSerInfoDao.findByserTime(ser);
            }else if (ser.getCondition().equals("经理是否已读"))
            {
                //服务经理是否已读查询
                ser.setSerRead(ser.getConValue());
                list = userSerInfoDao.findByserRead(ser);

            }else {
                //空值查询所有
                list = userSerInfoDao.selectresilt(ser);
            }
        }

        //分页操作
        //3.把查询出来的数据转换成分页对象
        PageInfo<UserSerInfo> page = new PageInfo<UserSerInfo>(list);

        //获取分页的当前页的集合
        map.put("list",page.getList());
        //总条数
        map.put("total",page.getTotal());
        //总页数
        map.put("totalPage",page.getPages());
        //上一页
        if (page.getPrePage()==0){
            map.put("pre",1);
        }else
        {
            map.put("pre",page.getPrePage());
        }
        //下一页,判断下一页的值是否大于等于最后一页
        if (page.getNextPage()==0)
        {
            map.put("next",page.getPages());
        }else {
            map.put("next", page.getNextPage());
        }
        //当前页
        map.put("cur",page.getPageNum());

        return map;
    }
}
