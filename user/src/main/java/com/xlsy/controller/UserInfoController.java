package com.xlsy.controller;

import com.xlsy.pojo.Resultinfo;
import com.xlsy.pojo.UserInfo;
import com.xlsy.pojo.UserSerInfo;
import com.xlsy.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
@RequestMapping("/user")
public class UserInfoController {
    @Autowired
    UserInfoService userInfoService;


    //访问当前用户的数据的页面user-info
    @RequestMapping("/infoPage")
    public String info(UserInfo user, ModelMap m){
        //把当前用户名存入pojpo中并备份中也存入
        user.setUserName("user");
        //根据用户名查询
        UserInfo u=userInfoService.select(user);
        //把数据传到前端
        m.addAttribute("user",u);
        return "user/user-info";
    }

    //处理修改的ajax请求
    @RequestMapping("/usinfo")
    @ResponseBody
    public HashMap<String,Object> usinfo(UserInfo user){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = userInfoService.userUpdate(user);
        System.out.print(info);
        map.put("info",info);
        return map;
    }

    //注销用户信息
    @RequestMapping("/deluser")
    @ResponseBody
    public HashMap<String,Object> deluser(UserInfo user){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = userInfoService.delUser(user);
        System.out.print(info);
        map.put("info",info);
        return map;
    }

    //访问当前用户的数据的页面服务请求页面
    @RequestMapping("/servicePage")
    public String servicePage( UserInfo user,UserSerInfo ser, ModelMap m){
        //把当前用户名存入pojpo中并备份中也存入
        ser.setSerUserNickName("user");
        //查询分页数据
        HashMap<String, Object> map=userInfoService.selectuserser(user,ser);
        //把数据传到前端
        m.put("info",map);
        //把用户输入的查询条件传到前端
        m.put("vv",ser.getConValue());
        return "user/user-service";
    }



    //打开修改服务界面
    @RequestMapping("/serveeditPage")
    public String serveeditPage(UserSerInfo ser, ModelMap m){
        //根据userId查询
        UserSerInfo u =userInfoService.selectByserId(ser);
        //把数据传递到前端
        m.addAttribute("ser",u);
        return "user/user-addser";
    }
    //处理修改服务信息的ajax请求
    @RequestMapping("/serveedit")
    @ResponseBody
    public HashMap<String,Object> serveedit(UserSerInfo ser){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = userInfoService.upService(ser);
        map.put("info",info);
        return map;
    }

    //删除服务
    @RequestMapping("/delservice")
    @ResponseBody
    public HashMap<String,Object> delservice(UserSerInfo ser){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = userInfoService.delservice(ser);
        System.out.print(info);
        map.put("info",info);
        return map;
    }

    //打开新增服务界面
    @RequestMapping("/serveaddPage")
    public String serveaddPage(UserInfo user,UserSerInfo ser, ModelMap m){
        //当前登录用户的用户名
        ser.setSerUserNickName("user");
        //根据userId查询
        UserInfo u =userInfoService.selectUserSer(ser);
        //把数据传递到前端
        m.addAttribute("user",u);
        return "user/user-addservice";
    }
    //处理新增服务信息的ajax请求
    @RequestMapping("/serveadd")
    @ResponseBody
    public HashMap<String,Object> serveadd(UserSerInfo ser){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = userInfoService.serveadd(ser);
        map.put("info",info);
        return map;
    }

    //用户服务处理结果查询
    @RequestMapping("/resultPage")
    public String resultPage(Resultinfo resu, ModelMap m){
        //把当前用户名存入pojpo中并备份中也存入
        resu.setResultName("user");
        //查询分页数据
        HashMap<String, Object> map=userInfoService.selectresult(resu);
        //把数据传到前端
        m.put("info",map);
        //把用户输入的查询条件传到前端
        m.put("vv",resu.getConValue());
        return "user/user-result";
    }
    //打开修改服务界面
    @RequestMapping("/resulteditPage")
    public String resulteditPage(Resultinfo result, ModelMap m){
        //根据userId查询
        Resultinfo u =userInfoService.selectByresultId(result);
        //把数据传递到前端
        m.addAttribute("ret",u);
        return "user/user-editresult";
    }
    //处理修改服务信息的ajax请求
    @RequestMapping("/resultedit")
    @ResponseBody
    public HashMap<String,Object> resultedit(Resultinfo result){
        HashMap<String,Object> map = new HashMap<String,Object>();
        String info = userInfoService.uprequist(result);
        map.put("info",info);
        return map;
    }

}
