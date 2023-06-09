package com.atguigu;

import com.atguigu.dao.impl.AccountDaoImpl;
import org.junit.Test;

/**
 * 包名:com.atguigu
 *
 * @author Leevi
 * 日期2023-04-28  14:49
 */

public class CRUDTest {
    @Test
    public void testFindAll(){
        AccountDaoImpl accountDao = new AccountDaoImpl();
        System.out.println(accountDao.findAll());
    }
}
