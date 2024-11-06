package com.agroguard.hackaton.service;

import com.agroguard.hackaton.exception.NotFoundException;
import com.agroguard.hackaton.model.Produtor;
import com.agroguard.hackaton.repository.ProdutorRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutorService {

    @Autowired
    private ProdutorRepository produtorRepository;

    public List<Produtor> getAllUsers() {
        return produtorRepository.findAll();
    }

    public Produtor saveProdutor(Produtor produtor) {
        return produtorRepository.save(produtor);
    }

    public Produtor updateProdutor(UUID uuid, Produtor produtorUpdate) {
        Produtor produtor = produtorRepository.findById(uuid)
                .orElseThrow(() -> new EntityNotFoundException("Entidade não encontrada"));

        BeanUtils.copyProperties(produtorUpdate, produtor, "id");

        return produtorRepository.save(produtor);
    }

    public Produtor findById(UUID uuid) throws NotFoundException {
        Optional<Produtor> produtor = produtorRepository.findById(uuid);
        if(!produtor.isPresent())
            throw new NotFoundException("Nenhum técnico encontrado");
        return produtor.get();
    }

}
