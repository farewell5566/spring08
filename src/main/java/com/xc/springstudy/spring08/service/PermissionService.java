package com.xc.springstudy.spring08.service;

import com.github.pagehelper.PageInfo;
import com.xc.springstudy.spring08.entity.Permission;
import com.xc.springstudy.spring08.mapper.PermissionExample;
import com.xc.springstudy.spring08.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.beans.PersistenceDelegate;

@Service
public class PermissionService {

    @Autowired
    PermissionMapper perMapper;

    public PageInfo<Permission> findAll(int pageNum, Integer pageSize) {

        PageInfo<Permission>pageInfos =  new PageInfo<>( perMapper.selectByExample(new PermissionExample()));
        return pageInfos;


    }
}
