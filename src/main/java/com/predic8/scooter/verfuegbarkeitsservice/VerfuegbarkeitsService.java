package com.predic8.scooter.verfuegbarkeitsservice;

import com.predic8.scooter.verfuegbarkeitsservice.model.Verfuegbarkeit;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class VerfuegbarkeitsService {

    HashMap<String, Boolean> verfuegbarkeiten = new HashMap<>();

    public Verfuegbarkeit pruefe(String id) {
        if (!verfuegbarkeiten.containsKey(id))
            verfuegbarkeiten.put(id, true);
        return new Verfuegbarkeit(verfuegbarkeiten.get(id));
    }

    public void ausleihen(String scooterId) {
        verfuegbarkeiten.put(scooterId, false);
    }

    public void zurueckgegeben(String scooterId) {
        verfuegbarkeiten.put(scooterId, true);
    }

}
