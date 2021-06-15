package com.predic8.scooter.verfuegbarkeitsservice;

import com.predic8.scooter.verfuegbarkeitsservice.model.Verfuegbarkeit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VerfuegbarkeitsController {

    @Autowired
    ScooterService scooterService;

    @GetMapping("/scooter/{id}/verfuegbarkeit")
    public ResponseEntity<Verfuegbarkeit> isVerfuegbar(@PathVariable String id){
        return ResponseEntity.ok(scooterService.getScooterVerfuegbar(id));
    }

}
