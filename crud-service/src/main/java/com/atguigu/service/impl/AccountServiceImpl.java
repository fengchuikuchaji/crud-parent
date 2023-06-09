package com.atguigu.service.impl;

import com.atguigu.dao.AccountDao;
import com.atguigu.dao.impl.AccountDaoImpl;
import com.atguigu.pojo.Account;
import com.atguigu.service.AccountService;

import java.util.List;

/**
 * 包名:com.atguigu.service.impl
 *
 * @author Leevi
 * 日期2023-04-28  14:52
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();
    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }
}
