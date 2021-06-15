package com.predic8.scooter.verfuegbarkeitsservice;

import com.predic8.scooter.verfuegbarkeitsservice.model.Verfuegbarkeit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class VerfuegbarkeitsAPI {

    @Autowired
    VerfuegbarkeitsService vService;

    @GetMapping("/scooter/{id}/verfuegbarkeit")
    public ResponseEntity<Verfuegbarkeit> isVerfuegbar(@PathVariable String id){

        int i = new Random().nextInt(3);
        if (i == 2)
            throw new RuntimeException("Doofe Katastrophe!");

        return ok(vService.pruefe(id));
    }

}
