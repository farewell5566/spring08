package com.xc.springstudy.spring08.mapper;

import com.xc.springstudy.spring08.entity.Account;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * AccountDAO继承基类
 */
@Repository
@Mapper
public interface AccountDAO extends MyBatisBaseDao<Account, Integer, AccountExample> {
}