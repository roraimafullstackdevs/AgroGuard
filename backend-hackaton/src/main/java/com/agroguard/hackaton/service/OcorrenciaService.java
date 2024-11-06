package com.agroguard.hackaton.service;

import com.agroguard.hackaton.exception.NotFoundException;
import com.agroguard.hackaton.model.Ocorrencia;
import com.agroguard.hackaton.model.Tecnico;
import com.agroguard.hackaton.repository.OcorrenciaRepository;
import com.agroguard.hackaton.repository.TecnicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OcorrenciaService {

    @Autowired
    private OcorrenciaRepository ocorrenciaRepository;

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public List<Ocorrencia> getAllOcorrencias() {
        return ocorrenciaRepository.findAll();
    }

    public Ocorrencia saveOcorrencia(Ocorrencia ocorrencia, UUID tecnicoUUID, String encodeFoto) {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(tecnicoUUID);
        if(!tecnico.isPresent())
            throw new NotFoundException("Nenhum técnico encontrado");
        ocorrencia.setFotoOcorrencia(Base64.getDecoder().decode(encodeFoto));
        ocorrencia.setTecnico(tecnico.get());
        return ocorrenciaRepository.save(ocorrencia);
    }

    public Ocorrencia findById(UUID uuid) throws NotActiveException {
        Optional<Ocorrencia> ocorrencia = ocorrenciaRepository.findById(uuid);
        if(!ocorrencia.isPresent())
            throw new NotFoundException("Nenhum técnico encontrado");
        return ocorrencia.get();
    }

    public Ocorrencia updateOcorrencia(UUID uuid, Ocorrencia ocorrenciaUpdate) {
        Ocorrencia ocorrencia = ocorrenciaRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        BeanUtils.copyProperties(ocorrenciaUpdate, ocorrencia, "id");

        return ocorrenciaRepository.save(ocorrencia);
    }
}
