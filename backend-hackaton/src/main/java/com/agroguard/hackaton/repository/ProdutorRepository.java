package com.agroguard.hackaton.repository;

import com.agroguard.hackaton.model.Ocorrencia;
import com.agroguard.hackaton.model.Produtor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProdutorRepository extends JpaRepository<Produtor, UUID> {
}
