package com.agroguard.hackaton.service;

import com.agroguard.hackaton.exception.NotFoundException;
import com.agroguard.hackaton.model.Notificacao;
import com.agroguard.hackaton.model.Tecnico;
import com.agroguard.hackaton.repository.NotificacaoRepository;
import com.agroguard.hackaton.repository.TecnicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class NotificacaoService {

    @Autowired
    private NotificacaoRepository notificacaoRepository;

    public Notificacao saveNotificacao(Notificacao notificacao) {
        return notificacaoRepository.save(notificacao);
    }

    public Notificacao updateNotificacao(UUID uuid, Notificacao notificacaoUpdate) {
        Notificacao notificacao = notificacaoRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        BeanUtils.copyProperties(notificacaoUpdate, notificacao, "id");

        return notificacaoRepository.save(notificacao);
    }

    public Notificacao findById(UUID uuid) throws NotFoundException {
        Optional<Notificacao> notificacao = notificacaoRepository.findById(uuid);
        if(!notificacao.isPresent())
            throw new NotFoundException("Nenhum técnico encontrado");
        return notificacao.get();
    }

}
