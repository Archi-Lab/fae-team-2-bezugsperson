package de.th.koeln.fae.microservice_assoziierte_instanz;

import de.th.koeln.fae.microservice_assoziierte_instanz.models.*;
import de.th.koeln.fae.microservice_assoziierte_instanz.models.Asi.*;
import de.th.koeln.fae.microservice_assoziierte_instanz.repositories.AssoziierteInstanzRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


@Component
public class SampleDataLoader implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AssoziierteInstanzRepository assoziierteInstanzRepository;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        final AssoziierteInstanz asi = new AssoziierteInstanz();

        asi.setVorname(new Vorname("Hans"));
        asi.setNachname(new Nachname("Wurst"));
        asi.setEmail(new Email("address@test.com"));
        asi.setPasswort(new Passwort("hunter1"));
        asi.setRolle(Rolle.BEZUGSPERSON);
        asi.setUsername(new Username("hwurst"));
        asi.setTelefonnummer(new TelefonNummer("1234567890"));

        final AssoziierteInstanz savedAsi = this.assoziierteInstanzRepository.save(asi);

    }
}

