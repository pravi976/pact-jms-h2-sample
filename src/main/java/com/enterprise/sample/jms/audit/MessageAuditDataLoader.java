package com.enterprise.sample.jms.audit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Instant;

@Configuration
class MessageAuditDataLoader {
    @Bean
    CommandLineRunner seedMessageAudit(MessageAuditRepository repository) {
        return args -> repository.save(new MessageAuditEntity("CUSTOMER_CREATED", "22222222-2222-2222-2222-222222222222", Instant.parse("2026-04-06T10:30:00Z")));
    }
}
