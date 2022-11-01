package com.issues.atm.controller;

import com.issues.atm.dto.WithdrawRequest;
import com.issues.atm.dto.WithdrawalAcknowledgement;
import com.issues.atm.service.WithdrawalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class WithdrawalController {
    @Autowired
    private WithdrawalService service;


    @PostMapping("/withdraw")
    public WithdrawalAcknowledgement bookFlightTicket(@RequestBody WithdrawRequest request){
        return service.withdrawMoney(request);
    }
}
