package de.predic8.scooter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.predic8.scooter.model.VerleihDTO;
import de.predic8.scooter.model.RueckgabeDTO;
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
    ObjectMapper om;

    @Autowired
    VerfuegbarkeitsService scooterService;

    // Hier Kafka Listener einbauen für Ausleihe

    // Hier Kafka Listener einbauen für Rückgabe
}
