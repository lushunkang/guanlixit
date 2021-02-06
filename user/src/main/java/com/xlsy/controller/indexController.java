package com.xlsy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {

    //访问user-index界面
    @RequestMapping("/index")
    public String index(){return "user-index";}

    //访问manager-index界面
    @RequestMapping("/manager-index")
    public  String manager(){
        return "manager-index";
    }

}
