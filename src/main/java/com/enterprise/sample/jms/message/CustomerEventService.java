package com.enterprise.sample.jms.message;

import com.enterprise.pact.framework.annotation.AutoGeneratePact;
import com.enterprise.pact.framework.annotation.PactDestination;
import com.enterprise.pact.framework.annotation.PactMessageListener;
import com.enterprise.pact.framework.annotation.PactMessageProducer;
import com.enterprise.sample.jms.audit.MessageAuditEntity;
import com.enterprise.sample.jms.audit.MessageAuditRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AutoGeneratePact(consumer = "consumer-driven-contract-testing", provider = "pact-jms-h2-sample")
public class CustomerEventService {
    private final MessageAuditRepository repository;

    public CustomerEventService(MessageAuditRepository repository) {
        this.repository = repository;
    }

    @PactMessageProducer(destination = "customer.events.v1")
    @PactDestination("customer.events.v1")
    public void publishCustomerCreated(CustomerEvent event) {
        repository.save(new MessageAuditEntity(event.eventType(), event.customerId().toString(), Instant.now()));
    }

    @PactMessageListener(destination = "customer.commands.v1")
    @PactDestination("customer.commands.v1")
    public void consumeCustomerCommand(CustomerEvent event) {
        repository.save(new MessageAuditEntity(event.eventType(), event.customerId().toString(), event.occurredAt()));
    }
}
