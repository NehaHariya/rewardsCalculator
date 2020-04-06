package com.retail.rewards.model;

import java.util.HashMap;
import java.util.List;

public class Customer {

    private String customerName;
    private List<MonthlyRewards> monthlyRewards;
    private int totalRewards;

    public Customer(String customerName, List<MonthlyRewards> monthlyRewards, int totalRewards) {
        this.customerName = customerName;
        this.monthlyRewards = monthlyRewards;
        this.totalRewards = totalRewards;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<MonthlyRewards> getMonthlyRewards() {
        return monthlyRewards;
    }

    public void setMonthlyRewards(List<MonthlyRewards> monthlyRewards) {
        this.monthlyRewards = monthlyRewards;
    }

    public int getTotalRewards() {
        return totalRewards;
    }

    public void setTotalRewards(int totalRewards) {
        this.totalRewards = totalRewards;
    }
}
