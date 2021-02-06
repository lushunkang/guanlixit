package com.xlsy.util;

import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.stereotype.Component;

/**
 * 密码加密的工具类
 */
@Component   //工具类交由其他管理和service相同
public class MdFive {
    /**
     *
     * @param password 要加密的密码
     * @param saltValue 盐值，一般是用户名为盐值
     * @return
     */
    public String encrypt(String password,String saltValue){

        Object salt = new Md5Hash(saltValue);

        Object result = new SimpleHash("MD5", password, salt, 1024);

        return result+"";
    }
    public static void  main(String[] args){

        com.xlsy.util.MdFive md=new com.xlsy.util.MdFive();
       String pd= md.encrypt("123","admin");
        System.out.println(pd);
    }


}

