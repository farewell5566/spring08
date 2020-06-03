package com.xc.springstudy.spring08.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.springstudy.spring08.Stas;
import com.xc.springstudy.spring08.entity.Role;
import com.xc.springstudy.spring08.mapper.RoleExample;
import com.xc.springstudy.spring08.mapper.RoleMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    RoleMapper roleMapper;

    public PageInfo<Role> findAll(int pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        RoleExample roleExam = new RoleExample();
        List<Role> roleData = roleMapper.selectByExample(roleExam);

/*        System.out.println(roleData.size());
        return null;*/

        System.out.println(ToStringBuilder.reflectionToString(roleData));
        return new PageInfo<>(roleData,3);
    }

    public Role findById(Integer id) {
        return roleMapper.selectByID(id);
        //return roleMapper.selectByPrimaryKey(id);
    }

    public Stas updateRolePer(int id, int[] idData) {

        for (int idP:idData) {
            System.out.println("id:  " +id);
            System.out.println("idP:  " +idP);
            roleMapper.updataRolePer(id,idP);
        }

        //roleMapper.updateRolePers(id,idData);

        return Stas.build(200);
    }
}
