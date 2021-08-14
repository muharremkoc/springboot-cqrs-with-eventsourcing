package com.cqrspattern.cqrswitheventsourcing.controllers;

import com.cqrspattern.cqrswitheventsourcing.dto.AccountCreateDTO;
import com.cqrspattern.cqrswitheventsourcing.dto.MoneyCreditDTO;
import com.cqrspattern.cqrswitheventsourcing.dto.MoneyDebitDTO;
import com.cqrspattern.cqrswitheventsourcing.services.command.AccountCommandService;
import lombok.AccessLevel;

import lombok.experimental.FieldDefaults;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/api/versions/cqrs")
@FieldDefaults(level = AccessLevel.PRIVATE)

public class CommandController {

       final  AccountCommandService accountCommandService;

    public CommandController(AccountCommandService accountCommandService) {
        this.accountCommandService = accountCommandService;
    }

    @PostMapping(value = "/credits/{accountNumber}")
    public CompletableFuture<String> createAccount(@PathVariable(value = "accountNumber") String accountNumber,@RequestBody AccountCreateDTO accountCreateDTO){
        return accountCommandService.AccountCreate(accountNumber,accountCreateDTO);
    }

    @PutMapping("/credits/{accountNumber}")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                          @RequestBody MoneyCreditDTO moneyCreditDTO) {

     return accountCommandService.creditMoneyToAccount(accountNumber,moneyCreditDTO);

    }
    @PutMapping(value = "/debits/{accountNumber}")
    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                           @RequestBody MoneyDebitDTO moneyDebitDTO){
        return accountCommandService.debitMoneyToAccount(accountNumber, moneyDebitDTO);
    }



}
