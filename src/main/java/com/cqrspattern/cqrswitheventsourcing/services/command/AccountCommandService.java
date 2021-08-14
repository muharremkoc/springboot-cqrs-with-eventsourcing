package com.cqrspattern.cqrswitheventsourcing.services.command;

import com.cqrspattern.cqrswitheventsourcing.dto.AccountCreateDTO;
import com.cqrspattern.cqrswitheventsourcing.dto.MoneyCreditDTO;
import com.cqrspattern.cqrswitheventsourcing.dto.MoneyDebitDTO;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;


public interface AccountCommandService {

     CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);

     CompletableFuture<String> debitMoneyToAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);

     CompletableFuture<String> AccountCreate(String accountNumber, AccountCreateDTO accountCreateDTO);

}
