package com.enterprise.sample.jms.audit;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.Instant;

@Entity
public class MessageAuditEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String eventType;
    private String customerId;
    private Instant processedAt;

    protected MessageAuditEntity() {}

    public MessageAuditEntity(String eventType, String customerId, Instant processedAt) {
        this.eventType = eventType;
        this.customerId = customerId;
        this.processedAt = processedAt;
    }

    public Long getId() { return id; }
    public String getEventType() { return eventType; }
    public String getCustomerId() { return customerId; }
    public Instant getProcessedAt() { return processedAt; }
}
