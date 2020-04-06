package com.retail.rewards.service;

import com.retail.rewards.model.Customer;
import com.retail.rewards.model.MonthlyRewards;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class RewardsService {

    public List<Customer> getCustomerRewards() {
        List<Customer> customers = new ArrayList<>();
        //Get sample data for 3 customers for 3 months
        HashMap<String, Object> customerData = getSampleData();
        customerData.forEach((k, v) -> {
            HashMap<Integer, List<Double>> transactions = (HashMap<Integer, List<Double>>) v;
            List<Integer> rewards = new ArrayList<>();
            List<MonthlyRewards> monthlyRewards = new ArrayList<>();
            transactions.forEach((month, trans) -> {
                int reward = calculateRewards(trans);
                rewards.add(reward); //Add rewards for each month to a list to calculate total rewards
                monthlyRewards.add(new MonthlyRewards(month, reward));
            });
            int totalRewards = rewards.stream().mapToInt(Integer::intValue).sum(); //Add rewards for all months
            customers.add(new Customer(k, monthlyRewards, totalRewards));
        });

        return customers;
    }

    private int calculateRewards(List<Double> transactions) {
        int rewards = 0;
        for (double transaction : transactions) {
            if (transaction > 100) {
                rewards += 2 * ((int) transaction - 100) + 50;
            }
            if (transaction > 50 && transaction <= 100) {
                rewards += (int) transaction - 50;
            }
        }
        return rewards;
    }

    private HashMap getSampleData() {
        HashMap<String, Object> customerData = new HashMap<String, Object>();
        HashMap<Integer, List<Double>> transactionsCustomer1 = new HashMap<>();
        transactionsCustomer1.put(1, Arrays.asList(55.0, 100.50, 120.0, 220.0));
        transactionsCustomer1.put(2, Arrays.asList(27.0, 166.0, 200.0));
        transactionsCustomer1.put(3, Arrays.asList(155.0, 40.0, 170.50, 59.0));
        customerData.put("Customer1", transactionsCustomer1);

        HashMap<Integer, List<Double>> transactionsCustomer2 = new HashMap<>();
        transactionsCustomer2.put(1, Arrays.asList(50.0, 120.0,170.0));
        transactionsCustomer2.put(2, Arrays.asList(97.0, 66.0, 150.0));
        transactionsCustomer2.put(3, Arrays.asList(125.0, 100.0, 270.0));
        customerData.put("Customer2", transactionsCustomer2);

        HashMap<Integer, List<Double>> transactionsCustomer3 = new HashMap<>();
        transactionsCustomer3.put(1, Arrays.asList(50.0, 137.0, 120.0, 130.50));
        transactionsCustomer3.put(2, Arrays.asList(72.0, 166.50, 100.0));
        transactionsCustomer3.put(3, Arrays.asList(15.0, 60.0, 170.0, 75.0));
        customerData.put("Customer3", transactionsCustomer3);
        return customerData;
    }
}
