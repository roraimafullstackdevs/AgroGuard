package com.agroguard.hackaton.repository;

import com.agroguard.hackaton.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, UUID> {
}
