package com.enterprise.sample.jms;

import com.enterprise.pact.framework.generator.ContractGenerationOrchestrator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class JmsH2ContractGenerationTest {
    @Autowired ApplicationContext context;
    @Autowired ContractGenerationOrchestrator orchestrator;

    @Test
    void generatesJmsContractsFromH2BackedMessageService() throws Exception {
        List<Path> files = orchestrator.generateContracts(context);
        Path jmsPact = files.stream().filter(path -> path.getFileName().toString().endsWith("-jms.json")).findFirst().orElseThrow();
        String json = Files.readString(jmsPact);
        assertTrue(json.contains("messages"));
        assertTrue(json.contains("Auto-generated JMS contract for publishCustomerCreated"));
        assertTrue(json.contains("Auto-generated JMS contract for consumeCustomerCommand"));
        assertTrue(json.contains("customer.events.v1"));
        assertTrue(json.contains("customer.commands.v1"));
        assertTrue(json.contains("\"traceToken\" : \"********\""));
        assertTrue(json.contains("matchingRules"));
    }
}
