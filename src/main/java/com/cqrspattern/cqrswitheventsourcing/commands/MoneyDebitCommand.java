package com.cqrspattern.cqrswitheventsourcing.commands;

public class MoneyDebitCommand extends BaseCommand{

    public final  double amount;

    public MoneyDebitCommand(String id,double amount) {
        super(id);
        this.amount=amount;
    }
}
