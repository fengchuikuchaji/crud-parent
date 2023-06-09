package com.atguigu.dao.impl;

import com.atguigu.dao.AccountDao;
import com.atguigu.pojo.Account;
import com.atguigu.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * 包名:com.atguigu.dao.impl
 *
 * @author Leevi
 * 日期2023-04-28  14:46
 */
public class AccountDaoImpl implements AccountDao {
    private QueryRunner queryRunner = new QueryRunner(JDBCUtil.getDataSource());
    @Override
    public List<Account> findAll() {
        try {
            String sql = "select account_id accountId,account_name accountName,money from t_account";
            return queryRunner.query(sql,new BeanListHandler<>(Account.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
