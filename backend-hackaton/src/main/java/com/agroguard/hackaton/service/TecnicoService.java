package com.agroguard.hackaton.service;

import com.agroguard.hackaton.exception.NegocioException;
import com.agroguard.hackaton.model.Tecnico;
import com.agroguard.hackaton.repository.TecnicoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TecnicoService {

    @Autowired
    private TecnicoRepository tecnicoRepository;

    public List<Tecnico> getAllUsers() {
        return tecnicoRepository.findAll();
    }

    public Tecnico saveTecnico(Tecnico tecnico) {
        return tecnicoRepository.save(tecnico);
    }

    public Tecnico updateTecnico(UUID uuid, Tecnico tecnicoUpdate) {
        Tecnico tecnico = tecnicoRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        BeanUtils.copyProperties(tecnicoUpdate, tecnico, "id");

        return tecnicoRepository.save(tecnico);
    }

    public Tecnico findById(UUID uuid) throws NegocioException {
        Optional<Tecnico> tecnico = tecnicoRepository.findById(uuid);
        if(!tecnico.isPresent())
            throw new NegocioException("Nenhum técnico encontrado");
        return tecnico.get();
    }

}
