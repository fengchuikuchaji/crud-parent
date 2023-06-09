package com.atguigu.pojo;

/**
 * 包名:com.atguigu.pojo
 *
 * @author Leevi
 * 日期2023-04-28  14:42
 */
public class Account {
    private Integer accountId;
    private String accountName;
    private Double money;

    public Account() {
    }

    public Account(Integer accountId, String accountName, Double money) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId=" + accountId +
                ", accountName='" + accountName + '\'' +
                ", money=" + money +
                '}';
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }
}
