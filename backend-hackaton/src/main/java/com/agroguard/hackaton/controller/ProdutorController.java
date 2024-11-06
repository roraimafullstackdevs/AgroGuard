package com.agroguard.hackaton.controller;


import com.agroguard.hackaton.exception.NotFoundException;
import com.agroguard.hackaton.model.Produtor;
import com.agroguard.hackaton.service.ProdutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/produtor")
public class ProdutorController {

    @Autowired
    private ProdutorService produtorService;

    @PostMapping
    public ResponseEntity<Produtor> create(@RequestBody Produtor produtor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtorService.saveProdutor(produtor));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produtor> getProdutor(@PathVariable("id") UUID produtorUUID) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtorService.findById(produtorUUID));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Produtor> updateProdutor(@PathVariable("id") UUID produtorUUID, @RequestBody Produtor produtorUpdate) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(produtorService.updateProdutor(produtorUUID, produtorUpdate));
    }
}
