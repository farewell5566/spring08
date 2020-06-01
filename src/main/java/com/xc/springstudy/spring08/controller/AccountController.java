package com.xc.springstudy.spring08.controller;


import com.github.pagehelper.PageInfo;
import com.xc.springstudy.spring08.Stas;
import com.xc.springstudy.spring08.entity.Account;
import com.xc.springstudy.spring08.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/account")
public class AccountController {

    @Autowired
    AccountService accServ;

    @RequestMapping("/login")
    public String login(){
        return "account/login";
    }


    @RequestMapping("/validataAccount")
    @ResponseBody
    public String validataAccount(String loginName, String password, HttpServletRequest request){
        Account acc = accServ.findByLoginNameAndPassword(loginName,password);
        System.out.println("账号："+loginName);
        System.out.println("密码："+password);
        if (acc!=null) {
            request.getSession().setAttribute("account",acc);
            return "success";
        }else
            return "error";
    }

    @RequestMapping("/logout")
    public String logOut(HttpServletRequest request){
        request.getSession().removeAttribute("account");
        return "index";
    }

    @RequestMapping("/profile")
    //@ResponseBody
    public String profile(){
        System.out.println("weisha");
        return "account/profile";
    }



    @RequestMapping("/list")
    public String listAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "4") Integer pageSize, Model data){
        PageInfo<Account> pageData= accServ.findAll(pageNum,pageSize);
        data.addAttribute("pageData",pageData);
        return "account/list";
    }

    @RequestMapping("/deleteById")
    @ResponseBody
    public Stas deleteById(int id ){
        System.out.println("deleteById = " + id);
        Stas status = accServ.deleteById(id);
        System.out.println(status);
        return status;
    }


}
