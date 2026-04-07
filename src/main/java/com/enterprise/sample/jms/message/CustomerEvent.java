package com.enterprise.sample.jms.message;

import com.enterprise.pact.framework.annotation.PactFieldExample;
import com.enterprise.pact.framework.annotation.PactSensitiveField;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public record CustomerEvent(
        UUID eventId,
        @PactFieldExample("22222222-2222-2222-2222-222222222222") UUID customerId,
        @PactFieldExample("CUSTOMER_CREATED") String eventType,
        @PactFieldExample("1") int schemaVersion,
        Map<String, String> attributes,
        @PactSensitiveField String traceToken,
        Instant occurredAt) {
}
