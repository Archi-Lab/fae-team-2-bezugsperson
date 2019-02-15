package de.th.koeln.fae.microservice_assoziierte_instanz.infrastructure.eventing.produce;

import java.util.UUID;

public interface EventSource {
    
    UUID getId();
    Long getVersion();
    String getAggregateName();

}
