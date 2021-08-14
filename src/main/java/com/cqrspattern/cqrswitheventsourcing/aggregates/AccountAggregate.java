package com.cqrspattern.cqrswitheventsourcing.aggregates;

import com.cqrspattern.cqrswitheventsourcing.commands.CreateAccountCommand;
import com.cqrspattern.cqrswitheventsourcing.commands.MoneyCreditCommand;
import com.cqrspattern.cqrswitheventsourcing.commands.MoneyDebitCommand;
import com.cqrspattern.cqrswitheventsourcing.events.AccountCreateEvent;
import com.cqrspattern.cqrswitheventsourcing.events.MoneyCreditEvent;
import com.cqrspattern.cqrswitheventsourcing.events.MoneyDebitEvent;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;

@Aggregate
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
public class AccountAggregate {

    @AggregateIdentifier
    String id;

    double accountBalance;

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand) {
        AggregateLifecycle.apply(new AccountCreateEvent(createAccountCommand.id, createAccountCommand.accountBalance));

    }
    @EventSourcingHandler
    protected void on(AccountCreateEvent accountCreatedEvent) {
        this.id = accountCreatedEvent.id;
        this.accountBalance = accountCreatedEvent.accountBalance;
    }
    @CommandHandler
    protected void on(MoneyCreditCommand moneyCreditCommand) {
        AggregateLifecycle.apply(new MoneyCreditEvent(moneyCreditCommand.id, moneyCreditCommand.amount));
    }

    @EventSourcingHandler
    protected void on(MoneyCreditEvent moneyCreditedEvent) {

        this.accountBalance += moneyCreditedEvent.creditAmount;
    }

    @CommandHandler
    protected void on(MoneyDebitCommand moneyDebitCommand) {
        AggregateLifecycle.apply(new MoneyDebitEvent(moneyDebitCommand.id, moneyDebitCommand.amount));
    }

    @EventSourcingHandler
    protected void on(MoneyDebitEvent moneyDebitedEvent) {
        if (this.accountBalance >= 0 & (this.accountBalance - moneyDebitedEvent.amount) < 0) {
        }
        this.accountBalance -= moneyDebitedEvent.amount;

    }
}
