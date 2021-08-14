package com.cqrspattern.cqrswitheventsourcing.events;

public class MoneyCreditEvent extends BaseEvent{

   public final double creditAmount;

    public MoneyCreditEvent(String id,double amount) {
        super(id);
        this.creditAmount=amount;
    }
}
