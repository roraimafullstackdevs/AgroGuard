package com.agroguard.hackaton.controller;


import com.agroguard.hackaton.exception.NotFoundException;
import com.agroguard.hackaton.model.Tecnico;
import com.agroguard.hackaton.service.TecnicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.UUID;

@RestController
@RequestMapping("/tecnico")
public class TecnicoController {

    @Autowired
    private TecnicoService tecnicoService;

    @PostMapping
    public ResponseEntity<Tecnico> create(@RequestBody Tecnico tecnico) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnicoService.saveTecnico(tecnico));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Tecnico> getTecnico(@PathVariable("id") UUID tecnicoUUID) throws NotActiveException {
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnicoService.findById(tecnicoUUID));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tecnico> updateTecnico(@PathVariable("id") UUID tecnicoUUID, @RequestBody Tecnico tecnicoNew) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(tecnicoService.updateTecnico(tecnicoUUID, tecnicoNew));
    }


}
