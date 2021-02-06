package com.xlsy.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xlsy.dao.ManagerInfoDao;
import com.xlsy.dao.ResultInfoDao;
import com.xlsy.dao.UserInfoDao;
import com.xlsy.dao.UserSerInfoDao;
import com.xlsy.pojo.Resultinfo;
import com.xlsy.pojo.UserInfo;
import com.xlsy.pojo.UserSerInfo;
import com.xlsy.util.MdFive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class UserInfoServiceImpl implements UserInfoService {
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

    //查询当前用户信息
    @Override
    public UserInfo select(UserInfo user) {
        return userInfoDao.selectuser(user);
    }

    //修改用户信息
    @Override
    public String userUpdate(UserInfo user) {
        //判断用户是否重名
        int v=userInfoDao.seluserName(user);
        //判断管理员是否存在
        int m= managerInfoDao.seluserManger(user);
        System.out.println(m);
        if (v==0) {
            if (m>0) {
                int num = userInfoDao.updateUserInfo(user);
                System.out.println(num);
                if (num > 0) {
                    return "保存成功";
                }
            }
            else {return "经理不存在";}
        }else {return "用户重名";}
        return "保存失败";
    }

    //注销用户信息
    @Override
    public String delUser(UserInfo user) {
        int num = userInfoDao.deluse(user);
        System.out.println(num);
        if(num>0){
            return "注销成功";
        }
        return "注销失败";
    }

    //分页查询用户的申请服务请求
    @Override
    public HashMap<String, Object> selectuserser(UserInfo user, UserSerInfo ser) {
        HashMap<String, Object> map=new HashMap<String, Object>();
        //1设置分页参数
        PageHelper.startPage(ser.getPage(),ser.getRow());
        //2查询数据库表数据
        List< UserSerInfo> list=new ArrayList<>();

        //判断用户输入的查询条件是否有值
        if(ser.getConValue().equals("")) {
            //空值查询所有
            list=userSerInfoDao.selectuserser(ser);
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
                list = userSerInfoDao.selectuserser(ser);
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

    //通过id查询用户服务
    @Override
    public UserSerInfo selectByserId(UserSerInfo ser) {
        return userSerInfoDao.selectByserId(ser);
    }

    //保存用户的修改的服务
    @Override
    public String upService(UserSerInfo ser) {
        int num = userSerInfoDao.upService(ser);
        if(num>0){
            return "保存成功";
        }
        return "保存失败";
    }

    //删除用户的服务
    @Override
    public String delservice(UserSerInfo ser) {
        int num = userSerInfoDao.delservice(ser);
        System.out.println(num);
        if(num>0){
            return "删除成功";
        }
        return "删除失败";
    }

    //新增服务查询用户的部分信息
    @Override
    public UserInfo selectUserSer(UserSerInfo ser) {
        return userInfoDao.selectUserSer(ser);
    }

    //处理保存新增服务操作
    @Override
    public String serveadd(UserSerInfo ser) {
       //插入数据
                int num = userSerInfoDao.serveadd(ser);
                System.out.println(num);
                if (num > 0) {
                    return "保存成功";
                }
        return "保存失败";
    }

    //分页查询服务返回结果
    @Override
    public HashMap<String, Object> selectresult(Resultinfo resu) {
        HashMap<String, Object> map=new HashMap<String, Object>();
        //1设置分页参数
        PageHelper.startPage(resu.getPage(),resu.getRow());
        //2查询数据库表数据
        List< Resultinfo> list=new ArrayList<>();

        //判断用户输入的查询条件是否有值
        if(resu.getConValue().equals("")) {
            //空值查询所有
            list=resultInfoDao.selectuserser(resu);
        }else {
            //根据用户选择的查询条件，判断用户需要查询的
            if (resu.getCondition().equals("编号")) {
                //设置用户输入的查询条件
                resu.setResultId(Integer.parseInt(resu.getConValue()));
                list = resultInfoDao.findBySerId(resu);
            }  else if (resu.getCondition().equals("服务类型"))
            {
                //服务类型的查询
                resu.setSerType(resu.getConValue());
                list = resultInfoDao.findByserType(resu);
            }else if (resu.getCondition().equals("服务日期")){
                //服务时间的查询
                resu.setSerTime(resu.getConValue());
                list = resultInfoDao.findByserTime(resu);
            }else if (resu.getCondition().equals("处理人"))
            {
                //处理人查询
                resu.setResultManager(resu.getConValue());
                list = resultInfoDao.findByPeople(resu);
            }else if (resu.getCondition().equals("完成时间"))
            {
                //完成时间查询
                resu.setResultTimei(resu.getConValue());
                 list = resultInfoDao.findByoverTime(resu);
            }else {
                //空值查询所有
                list=resultInfoDao.selectuserser(resu);
               
            }
        }

        //分页操作
        //3.把查询出来的数据转换成分页对象
        PageInfo<Resultinfo> page = new PageInfo<Resultinfo>(list);

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

    //根据服务结果查询返回的id查询服务selectByresultId
    @Override
    public Resultinfo selectByresultId(Resultinfo result) {
        return resultInfoDao.selectByresultId(result);
    }

    @Override
    public String uprequist(Resultinfo result) {
        //向申请服务表中修改当前修改的数据
        int num = userSerInfoDao.upService(result);
        //向服务结果表中修改当前服务
        int re = resultInfoDao.uprequist(result);
        if(num>0 && re>0){
            return "保存成功";
        }
        return "保存失败";
    }
}
