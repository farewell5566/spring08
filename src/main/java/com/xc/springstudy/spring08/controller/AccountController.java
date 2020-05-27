package com.xc.springstudy.spring08.controller;


import com.xc.springstudy.spring08.entity.Account;
import com.xc.springstudy.spring08.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
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

    @RequestMapping("/list")
    public String listAll(Model data){
        List<Account> accData= accServ.findAll();
        data.addAttribute("accountData",accData);
        return "account/list";
    }






}
