package com.xc.springstudy.spring08.controller;


import com.github.pagehelper.PageInfo;
import com.xc.springstudy.spring08.Stas;
import com.xc.springstudy.spring08.entity.Account;
import com.xc.springstudy.spring08.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
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

    @RequestMapping("/uploadImage")

    public String uploadImage( String password,MultipartFile filename,HttpServletRequest request){

        try{
            Account acc =(Account) request.getSession().getAttribute("account");
            //定位项目路径，用于war，不能用在jar，用在jar的话，需要在项目外边进性生成
            File path = new File(ResourceUtils.getURL("classpath:").getPath());
            File upload = new File(path.getAbsoluteFile(),"static/upload/");

            //设置文件保留的绝对路径

            String pathName="D:/upload";

            System.out.println("originale:" + filename.getOriginalFilename());
            System.out.println("upload :" + upload+ "/" + filename.getOriginalFilename());
            filename.transferTo(new File(pathName+ "/" + filename.getOriginalFilename()));

            acc.setPassword(password);
            acc.setAddress(filename.getOriginalFilename());
            accServ.updataAccount(acc);

        }catch (Exception ex){
            ex.printStackTrace();
        }

        return "account/profile";
    }




}
