package com.cqrspattern.cqrswitheventsourcing.commands;

public class MoneyCreditCommand extends BaseCommand{

  public   final double amount;

    public MoneyCreditCommand(String id,double amount) {
        super(id);
        this.amount=amount;
    }
}
