package com.enterprise.sample.jms.message;

import com.enterprise.sample.jms.audit.MessageAuditEntity;
import com.enterprise.sample.jms.audit.MessageAuditRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class CustomerEventService {
    private final MessageAuditRepository repository;

    public CustomerEventService(MessageAuditRepository repository) {
        this.repository = repository;
    }

    public void publishCustomerCreated(CustomerEvent event) {
        repository.save(new MessageAuditEntity(event.eventType(), event.customerId().toString(), Instant.now()));
    }

    public void consumeCustomerCommand(CustomerEvent event) {
        repository.save(new MessageAuditEntity(event.eventType(), event.customerId().toString(), event.occurredAt()));
    }
}
