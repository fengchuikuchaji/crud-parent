package com.atguigu.dao;

import com.atguigu.pojo.Account;

import java.util.List;

/**
 * 包名:com.atguigu.dao
 *
 * @author Leevi
 * 日期2023-04-28  14:46
 */
public interface AccountDao {
    List<Account> findAll();
}
