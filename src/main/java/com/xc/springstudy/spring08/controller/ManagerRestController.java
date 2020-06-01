package com.xc.springstudy.spring08.controller;

import com.xc.springstudy.spring08.Stas;
import com.xc.springstudy.spring08.entity.Permission;
import com.xc.springstudy.spring08.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/manager/permission")
public class ManagerRestController {

    @Autowired
    PermissionService permServ;

    @RequestMapping("/update")
    public Stas perModify(@RequestBody Permission per){
        System.out.println("per: " + per);
        return  permServ.update(per);

    }
}
