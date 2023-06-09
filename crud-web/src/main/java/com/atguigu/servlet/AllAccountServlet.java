package com.atguigu.servlet;

import com.atguigu.base.ViewBaseServlet;
import com.atguigu.pojo.Account;
import com.atguigu.service.AccountService;
import com.atguigu.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 包名:com.atguigu.servlet
 *
 * @author Leevi
 * 日期2023-04-28  14:54
 */
@WebServlet("/account/findAll")
public class AllAccountServlet extends ViewBaseServlet {
    private AccountService accountService = new AccountServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 调用业务层的方法查询所有的账户信息
        List<Account> accountList = accountService.findAll();
        //2. 将所有的账户信息存放到请求域中
        req.setAttribute("accountList",accountList);
        //3. 解析Thymeleaf视图
        processTemplate("list",req,resp);
    }
}
