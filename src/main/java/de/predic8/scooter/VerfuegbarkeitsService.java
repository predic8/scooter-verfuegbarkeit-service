package de.predic8.scooter;

import de.predic8.scooter.model.Verfuegbarkeit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.lang.invoke.MethodHandles;
import java.util.*;

@Service
public class VerfuegbarkeitsService {

    private static final Logger log = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    HashMap<String, Boolean> verfuegbarkeiten = new HashMap<>();

    public Verfuegbarkeit pruefe(String scooterId) {
        return new Verfuegbarkeit(verfuegbarkeiten.getOrDefault(scooterId, true));
    }

    public void ausleihen(String scooterId) {
        verfuegbarkeiten.put(scooterId, false);
        dump();
    }

    public void zurueckgegeben(String scooterId) {
        verfuegbarkeiten.put(scooterId, true);
        dump();
    }

    private void dump() {
        for(Map.Entry<String, Boolean> e : verfuegbarkeiten.entrySet()) {
            System.out.println( e.getKey() + " = " + e.getValue());
        }
    }

}
