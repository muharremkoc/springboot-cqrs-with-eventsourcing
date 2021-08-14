package com.cqrspattern.cqrswitheventsourcing.controllers;

import com.cqrspattern.cqrswitheventsourcing.services.query.AccountQueryService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/versions/query")
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class QueryController {

    final AccountQueryService accountQueryService;

    @GetMapping("/events/{accountNumber}")
    public List<Object>listEventsAccount(@PathVariable(value = "accountNumber") String accountNumber){
        return accountQueryService.listEventsAccount(accountNumber);
    }


}
