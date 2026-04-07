package com.enterprise.sample.jms.audit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageAuditRepository extends JpaRepository<MessageAuditEntity, Long> {
}
