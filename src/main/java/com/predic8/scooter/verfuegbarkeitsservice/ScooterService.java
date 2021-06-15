package com.predic8.scooter.verfuegbarkeitsservice;

import com.predic8.scooter.verfuegbarkeitsservice.model.Verfuegbarkeit;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class ScooterService {

    HashMap<String, Verfuegbarkeit> scooterDb = new HashMap<>();

    public Verfuegbarkeit getScooterVerfuegbar(String id) {
        if (!scooterDb.containsKey(id))
            scooterDb.put(id, new Verfuegbarkeit(true));
        return scooterDb.get(id);
    }

    public void ausgeliehen(String scooterId) {
        verfuegbarkeitFuerScooter(scooterId, false);
    }

    public void zurueckgegeben(String scooterId) {
        verfuegbarkeitFuerScooter(scooterId, true);
    }

    private void verfuegbarkeitFuerScooter(String scooterId, boolean verfuegbarkeitsStatus) {
        if (!scooterDb.containsKey(scooterId))
            scooterDb.put(scooterId, new Verfuegbarkeit(true));

        Verfuegbarkeit verfuegbarkeit = scooterDb.get(scooterId);
        verfuegbarkeit.setVerfuegbar(verfuegbarkeitsStatus);
        scooterDb.put(scooterId, verfuegbarkeit);
    }

}
