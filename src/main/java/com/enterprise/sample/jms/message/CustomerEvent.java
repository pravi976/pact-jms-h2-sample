package com.enterprise.sample.jms.message;

import com.fedex.cdc.automation.annotations.PactExample;
import com.fedex.cdc.automation.annotations.PactSecret;

import java.time.Instant;
import java.util.Map;
import java.util.UUID;

public record CustomerEvent(
        UUID eventId,
        @PactExample("22222222-2222-2222-2222-222222222222") UUID customerId,
        @PactExample("CUSTOMER_CREATED") String eventType,
        @PactExample("1") int schemaVersion,
        Map<String, String> attributes,
        @PactSecret String traceToken,
        Instant occurredAt) {
}
