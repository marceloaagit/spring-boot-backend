package com.marceloalves.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.api.entities.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
		
}
