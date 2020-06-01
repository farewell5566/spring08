package com.xc.springstudy.spring08.service;

import com.github.pagehelper.PageInfo;
import com.xc.springstudy.spring08.Stas;
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

    public Permission findById(Integer id) {
       return  perMapper.selectByPrimaryKey(id);
    }

    public Stas  update(Permission per) {
        int rows = 0;

        if (null != perMapper.selectByPrimaryKey(per.getId())) {
            rows = perMapper.updateByPrimaryKeySelective(per);
        }
        else {
            rows = perMapper.insert(per);
        }
        return rows == 1 ? Stas.build(200) : Stas.error("Dont Update Permission");

    }
}
