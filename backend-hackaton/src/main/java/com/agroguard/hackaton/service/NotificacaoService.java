package com.agroguard.hackaton.service;

import com.agroguard.hackaton.exception.NegocioException;
import com.agroguard.hackaton.model.Notificacao;
import com.agroguard.hackaton.repository.NotificacaoRepository;
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

    public Notificacao findById(UUID uuid) throws NegocioException {
        Optional<Notificacao> notificacao = notificacaoRepository.findById(uuid);
        if(!notificacao.isPresent())
            throw new NegocioException("Não foi possível localizar a notificação");
        return notificacao.get();
    }

    public List<Notificacao> getAll() throws NegocioException {
        List<Notificacao> notificacoes = notificacaoRepository.findAll();

        if(notificacoes.isEmpty())
            throw new NegocioException("Não foram adicionadas notificações até o momento");
        return notificacoes;
    }

}
