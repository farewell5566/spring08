package com.xc.springstudy.spring08.service;

import com.xc.springstudy.spring08.entity.Account;
import com.xc.springstudy.spring08.mapper.AccountDAO;
import com.xc.springstudy.spring08.mapper.AccountExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {


    @Autowired
    AccountDAO accMapper;


    public Account findByLoginNameAndPassword(String loginName, String password) {
        AccountExample accExample = new AccountExample();
        accExample.createCriteria()
                .andLoginNameEqualTo(loginName)
                .andPasswordEqualTo(password);

        List<Account> accounts = accMapper.selectByExample(accExample);


        return accounts.size()==1? accounts.get(0):null;

    }

    public List<Account> findAll() {
        return accMapper.selectByExample(new AccountExample());

    }
}
