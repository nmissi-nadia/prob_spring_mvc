package com.smart.service;

import org.springframework.stereotype.Component;

/**
 * Exemple: autowire="byName" depuis applicationContext.xml
 * (il trouvera la bean idGenerator si présent)
 */
public class ReportService {
    private com.smart.util.IdGenerator idGenerator; // par convention setIdGenerator() appelé si autowire byName

    public void setIdGenerator(com.smart.util.IdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    public String sampleReportToken() {
        return idGenerator != null ? idGenerator.generate() : "no-idgen";
    }
}
