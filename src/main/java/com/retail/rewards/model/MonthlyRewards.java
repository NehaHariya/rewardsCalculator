package com.retail.rewards.model;

public class MonthlyRewards {

    private int month;
    private int rewards;

    public MonthlyRewards(int month, int rewards) {
        this.month = month;
        this.rewards = rewards;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getRewards() {
        return rewards;
    }

    public void setRewards(int rewards) {
        this.rewards = rewards;
    }
}
