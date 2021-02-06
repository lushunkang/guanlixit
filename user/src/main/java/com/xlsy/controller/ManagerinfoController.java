package com.xlsy.controller;

import com.xlsy.pojo.Resultinfo;
import com.xlsy.pojo.UserInfo;
import com.xlsy.pojo.UserSerInfo;
import com.xlsy.service.ManagerInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

@Controller
@RequestMapping("/manager")
public class ManagerinfoController {
    //创建managerinfoservice的实现类对象
    @Autowired
    ManagerInfoService managerInfoService;

    //访问manager-resultqure.html界面
    @RequestMapping("/managerresultPage")
    public String managerresultPage(UserSerInfo ser, ModelMap m){
        //把当前用户名存入pojpo中并备份中也存入
        ser.setSerManager("admin");
        //查询分页数据
        HashMap<String, Object> map=managerInfoService.selectresilt(ser);
        //把数据传到前端
        m.put("info",map);
        //把用户输入的查询条件传到前端
        m.put("vv",ser.getConValue());
        return "manager/manager-resultqure";
    }

}
