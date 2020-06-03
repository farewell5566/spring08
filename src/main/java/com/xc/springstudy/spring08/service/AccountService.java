package com.xc.springstudy.spring08.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xc.springstudy.spring08.Stas;
import com.xc.springstudy.spring08.entity.Account;
import com.xc.springstudy.spring08.entity.Role;
import com.xc.springstudy.spring08.mapper.AccountDAO;
import com.xc.springstudy.spring08.mapper.AccountExample;
import org.apache.commons.lang3.builder.ToStringBuilder;
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

    public PageInfo<Account> findAll(int pageNum, Integer pageSize) {



        List<Account> accAllData = accMapper.findAll();
        Account acc = accAllData.get(0);
        Role role = accAllData.get(0).getRoles().get(0);

        System.out.println("-------");
        System.out.println(accAllData.size());

        System.out.println(ToStringBuilder.reflectionToString(role));
        System.out.println(ToStringBuilder.reflectionToString(acc.getRoles().get(0)));
        System.out.println(ToStringBuilder.reflectionToString(acc.getPermissions().get(0)));

        System.out.println("-------");

        List<Account>accData = accMapper.selectByExample(new AccountExample());


        PageHelper.startPage(pageNum,pageSize);
        System.out.println("pageNum" + pageNum);
        System.out.println("pageSize" + pageSize);
        return new PageInfo<Account>(accData,3);
    }

    public Stas deleteById(int id) {
        AccountExample accExample = new AccountExample();
        accExample.createCriteria().andIdEqualTo(id);

        int row = accMapper.deleteByExample(accExample);
        Stas stas =new Stas();

        return row==1 ? stas.build(200):stas.error("没有删除数据");

    }

    public void updataAccount(Account acc) {
        accMapper.updateByPrimaryKeySelective(acc);
    }
}
