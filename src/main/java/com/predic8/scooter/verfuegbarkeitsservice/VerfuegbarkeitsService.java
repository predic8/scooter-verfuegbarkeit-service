package com.predic8.scooter.verfuegbarkeitsservice;

import com.predic8.scooter.verfuegbarkeitsservice.model.Verfuegbarkeit;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class VerfuegbarkeitsService {

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
