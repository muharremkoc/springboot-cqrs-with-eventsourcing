package com.cqrspattern.cqrswitheventsourcing.commands;

import lombok.AllArgsConstructor;


public class CreateAccountCommand extends BaseCommand{

     public final  double accountBalance;

    public CreateAccountCommand(String id,double accountBalance) {
        super(id);
        this.accountBalance=accountBalance;

    }
}
