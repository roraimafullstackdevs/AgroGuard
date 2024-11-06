package com.agroguard.hackaton.controller;

import com.agroguard.hackaton.exception.NotFoundException;
import com.agroguard.hackaton.model.Ocorrencia;
import com.agroguard.hackaton.model.Tecnico;
import com.agroguard.hackaton.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.UUID;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaMain {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @PostMapping("/{id}")
    public ResponseEntity<Ocorrencia> create(@PathVariable("id") UUID tecnicoUUID, @RequestBody Ocorrencia ocorrencia) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaService.saveOcorrencia(ocorrencia,tecnicoUUID));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> getOcorrencia(@PathVariable("id") UUID ocorrenciaUUID) throws NotActiveException {
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaService.findById(ocorrenciaUUID));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> updateOcorrencia(@PathVariable("id") UUID ocorrenciaUUID, @RequestBody Ocorrencia ocorrencia) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaService.updateOcorrencia(ocorrenciaUUID, ocorrencia));
    }
}
