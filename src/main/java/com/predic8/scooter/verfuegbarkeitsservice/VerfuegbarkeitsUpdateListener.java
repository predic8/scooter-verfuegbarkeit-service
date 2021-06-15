package com.predic8.scooter.verfuegbarkeitsservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.lang.invoke.MethodHandles;

@Component
public class VerfuegbarkeitsUpdateListener {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Autowired
    VerfuegbarkeitsService scooterService;

    @KafkaListener(topics = "scooter.ausleihe", groupId = "verfuegbarkeits-service")
    public void listener(String scooterId){
        log.info("Scooter: " + scooterId + " wurde ausgeliehen." );
        scooterService.ausleihen(scooterId);
    }

    @KafkaListener(topics = "scooter.rueckgabe", groupId = "verfuegbarkeits-service")
    public void rueckgabeListener(String scooterId){
        log.info("Scooter: " + scooterId + " wurde zurückgegeben." );
        scooterService.zurueckgegeben(scooterId);
    }
}
