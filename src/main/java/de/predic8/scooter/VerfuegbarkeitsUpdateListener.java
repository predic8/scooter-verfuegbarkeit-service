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

    @KafkaListener(topics = "scooter.ausleihe")
    public void listener(String verleih) throws JsonProcessingException {
        VerleihDTO verleihDTO = om.readValue(verleih, VerleihDTO.class);
        log.info("Scooter: " + verleihDTO.getScooterId() + " wurde ausgeliehen.");
        scooterService.ausleihen(verleihDTO.getScooterId());
    }

    @KafkaListener(topics = "scooter.rueckgabe")
    public void rueckgabeListener(String rueckgabe) throws JsonProcessingException {
        RueckgabeDTO rueckgabeDTO = om.readValue(rueckgabe, RueckgabeDTO.class);
        log.info("Scooter " + rueckgabeDTO.getScooterId() + " wurde zurückgegeben.");
        scooterService.zurueckgegeben(rueckgabeDTO.getScooterId());
    }
}