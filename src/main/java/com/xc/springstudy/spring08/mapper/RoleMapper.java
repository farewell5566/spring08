package com.xc.springstudy.spring08.mapper;

import com.xc.springstudy.spring08.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * RoleMapper继承基类
 */
@Repository
@Mapper

public interface RoleMapper extends MyBatisBaseDao<Role, Integer, RoleExample> {
    void updataRolePer(int id,int idData);

    void updateRolePers(@Param("id") int id,@Param("idData") int[] idData);

    Role selectByID(Integer id);
}