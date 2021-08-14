package com.cqrspattern.cqrswitheventsourcing.services.query;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.axonframework.eventsourcing.eventstore.EventStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AccountQueryServiceImpl implements AccountQueryService{

    final EventStore eventStore;


    @Override
    public List<Object> listEventsAccount(String accountNumber) {
        return eventStore.readEvents(accountNumber).asStream().map(s->s.getPayload()).collect(Collectors.toList());
    }
}
