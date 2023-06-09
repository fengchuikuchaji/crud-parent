package com.atguigu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * 包名:com.atguigu.jdbc
 *
 * @author Leevi
 * 日期2023-03-10  14:24
 * ThreadLocal的作用:你将对象存储到ThreadLocal中，那么在同一个线程的任意方法中获取都可以共享
 * ThreadLocal中存储的内容，使用完之后一定要进行remove，否则很有可能造成内存泄露
 */
public class JDBCUtil {
    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<Connection>();
    private static DataSource dataSource;
    static {
        try {
            System.out.println("热修复.....");
            System.out.println("张三修改代码.......");
            System.out.println("李四修改代码.....");
            System.out.println("李四第二次修改代码.....");
            System.out.println("张三第二次修改代码.....");
            System.out.println("张三第二次修改代码.....");
            System.out.println("张三第二次修改代码.....");
            System.out.println("张三第二次修改代码.....");
            InputStream in = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            Properties properties = new Properties();
            properties.load(in);
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取连接池对象
     * @return
     */
    public static DataSource getDataSource(){
        return dataSource;
    }

    /**
     * 获取连接
     * 保证在同一次调用链路(同一个线程)
     * @return
     */
    public static Connection getConnection(){
        try {
            //从threadLocal中获取
            Connection connection = threadLocal.get();
            if (connection == null) {
                //从连接池获取一个连接
                connection = dataSource.getConnection();
                //放入ThreadLocal对象
                threadLocal.set(connection);
            }
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 归还连接
     */
    public static void releaseConnection(){
        try {
            Connection connection = getConnection();
            //1. 将connection从threadLocal中移除掉
            threadLocal.remove();
            //2. 将connection的autoCommit属性还原成true
            connection.setAutoCommit(true);
            //3. 归还到连接池
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void rollback(){
        try {
            getConnection().rollback();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void commit(){
        try {
            getConnection().commit();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void startTransaction(){
        try {
            getConnection().setAutoCommit(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
