package com.cqrspattern.cqrswitheventsourcing.services.command;

import com.cqrspattern.cqrswitheventsourcing.commands.CreateAccountCommand;
import com.cqrspattern.cqrswitheventsourcing.commands.MoneyCreditCommand;
import com.cqrspattern.cqrswitheventsourcing.commands.MoneyDebitCommand;
import com.cqrspattern.cqrswitheventsourcing.dto.AccountCreateDTO;
import com.cqrspattern.cqrswitheventsourcing.dto.MoneyCreditDTO;
import com.cqrspattern.cqrswitheventsourcing.dto.MoneyDebitDTO;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountCommandServiceImpl implements AccountCommandService {

    final CommandGateway commandGateway;

    @Override
    public CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO) {
        return commandGateway.send(new MoneyCreditCommand(accountNumber,moneyCreditDTO.getAmount()));
    }

    @Override
    public CompletableFuture<String> debitMoneyToAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO) {
        return commandGateway.send(new MoneyDebitCommand(accountNumber,moneyDebitDTO.getAmount()));
    }

    @Override
    public CompletableFuture<String> AccountCreate(String accountNumber, AccountCreateDTO accountCreateDTO) {
        return commandGateway.send(new CreateAccountCommand(accountNumber,accountCreateDTO.getBalance()));
    }
}
