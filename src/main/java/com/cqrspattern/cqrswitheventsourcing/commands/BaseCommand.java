package com.cqrspattern.cqrswitheventsourcing.commands;

import lombok.AllArgsConstructor;
import org.axonframework.modelling.command.TargetAggregateIdentifier;
@AllArgsConstructor
public class BaseCommand {

    @TargetAggregateIdentifier
   public final String id;


}
