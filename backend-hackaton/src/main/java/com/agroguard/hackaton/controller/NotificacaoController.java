package com.agroguard.hackaton.controller;

import com.agroguard.hackaton.model.Notificacao;
import com.agroguard.hackaton.service.NotificacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/notificacao")
public class NotificacaoController {

    @Autowired
    private NotificacaoService notificacaoService;

    @PostMapping
    public ResponseEntity<Notificacao> createNotificacao(@RequestBody Notificacao notificacao) {
            return ResponseEntity.status(HttpStatus.CREATED).body(notificacaoService.saveNotificacao(notificacao));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notificacao> getNotificacao(@PathVariable("id") UUID notificacaoUUID) {
        return ResponseEntity.status(HttpStatus.CREATED).body(notificacaoService.findById(notificacaoUUID));
    }
}
