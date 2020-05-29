package com.xc.springstudy.spring08.controller;


import com.github.pagehelper.PageInfo;
import com.xc.springstudy.spring08.Stas;
import com.xc.springstudy.spring08.entity.Account;
import com.xc.springstudy.spring08.entity.Permission;
import com.xc.springstudy.spring08.service.AccountService;
import com.xc.springstudy.spring08.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    AccountService accServ;

    @Autowired
    PermissionService perServ;


    @RequestMapping("/accountList")
    public String listAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "4") Integer pageSize, Model data){
        PageInfo<Account> pageData= accServ.findAll(pageNum,pageSize);
        data.addAttribute("pageData",pageData);
        return "/manager/accountList";
    }

    @RequestMapping("/permissionList")
    public String permissionlistAll(@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "4") Integer pageSize, Model data){
        PageInfo<Permission> pageData= perServ.findAll(pageNum,pageSize);
        System.out.println(pageData);
        data.addAttribute("pageData",pageData);
        return "/manager/permissionList";
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
