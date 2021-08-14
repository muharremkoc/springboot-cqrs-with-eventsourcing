package com.cqrspattern.cqrswitheventsourcing.services.query;

import java.util.List;

public interface AccountQueryService {
     List<Object> listEventsAccount(String accountNumber);
}
