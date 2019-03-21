package com.marceloalves.backend.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.backend.domain.Estado;

@Repository
public interface EstadoRepositoy extends JpaRepository<Estado, Integer> {
		
}
