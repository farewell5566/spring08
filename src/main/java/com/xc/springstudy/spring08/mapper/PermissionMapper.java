package com.xc.springstudy.spring08.mapper;

import com.xc.springstudy.spring08.entity.Permission;
import org.springframework.stereotype.Repository;

/**
 * PermissionMapper继承基类
 */
@Repository
public interface PermissionMapper extends MyBatisBaseDao<Permission, Integer, PermissionExample> {
}