package com.atguigu.service;

import com.atguigu.pojo.Account;

import java.util.List;

/**
 * 包名:com.atguigu.service
 *
 * @author Leevi
 * 日期2023-04-28  14:52
 */
public interface AccountService {
    List<Account> findAll();
}
