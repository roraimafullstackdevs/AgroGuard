package com.agroguard.hackaton.controller;

import com.agroguard.hackaton.exception.NegocioException;
import com.agroguard.hackaton.model.Ocorrencia;
import com.agroguard.hackaton.service.OcorrenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.NotActiveException;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/ocorrencia")
public class OcorrenciaController {

    @Autowired
    private OcorrenciaService ocorrenciaService;

    @PostMapping("/{tecnicoUUID}")
    public ResponseEntity<Ocorrencia> create(@PathVariable UUID tecnicoUUID, @RequestBody Ocorrencia ocorrencia, @RequestParam String encodeFoto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaService.saveOcorrencia(ocorrencia,tecnicoUUID, encodeFoto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ocorrencia> getOcorrencia(@PathVariable("id") UUID ocorrenciaUUID) throws NotActiveException {
        return ResponseEntity.status(HttpStatus.OK).body(ocorrenciaService.findById(ocorrenciaUUID));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Ocorrencia>> getAllOcorrencias(){
        return ResponseEntity.status(HttpStatus.OK).body(ocorrenciaService.getAll());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> updateOcorrencia(@PathVariable("id") UUID ocorrenciaUUID, @RequestBody Ocorrencia ocorrencia) throws NegocioException {
        return ResponseEntity.status(HttpStatus.CREATED).body(ocorrenciaService.updateOcorrencia(ocorrenciaUUID, ocorrencia));
    }
}
