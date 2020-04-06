package com.retail.rewards.controller;

import com.retail.rewards.model.Customer;
import com.retail.rewards.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@RestController
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @GetMapping(value = "/customer/rewards/")
    public ResponseEntity<List<Customer>> getTotalRewards() {
        List<Customer> customers = rewardsService.getCustomerRewards();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }
}

