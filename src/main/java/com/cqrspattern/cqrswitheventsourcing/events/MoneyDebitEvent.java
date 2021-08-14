package com.cqrspattern.cqrswitheventsourcing.events;

public class MoneyDebitEvent extends BaseEvent{

  public   final double amount;

    public MoneyDebitEvent(String id,double amount) {
        super(id);
        this.amount=amount;
    }
}
