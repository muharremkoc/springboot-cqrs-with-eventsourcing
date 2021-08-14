package com.cqrspattern.cqrswitheventsourcing.events;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Inheritance;


public class AccountCreateEvent extends BaseEvent{

   public final double accountBalance;

    public AccountCreateEvent(String id,double balance) {
        super(id);
        this.accountBalance=balance;
    }
}
