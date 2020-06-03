package com.xc.springstudy.spring08.controller.rest;

import com.xc.springstudy.spring08.Stas;
import com.xc.springstudy.spring08.entity.Permission;
import com.xc.springstudy.spring08.service.PermissionService;
import com.xc.springstudy.spring08.service.RoleService;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.net.TelnetOutputStream;

@RestController
@RequestMapping("/api/v1/manager/role")
public class RoleManagerRestController {

    @Autowired
    RoleService roleServ;

    @RequestMapping("/update")
    public Stas perModify(@RequestParam int  []idData,@RequestParam int id ){
        System.out.println("idData: " + idData.length );

        System.out.println("idData: " +ToStringBuilder.reflectionToString(idData) );
        System.out.println("id: " +id  );

        return roleServ.updateRolePer(id,idData);

    }
}
