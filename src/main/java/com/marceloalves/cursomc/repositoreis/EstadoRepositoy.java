package com.marceloalves.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.cursomc.domain.Estado;

@Repository
public interface EstadoRepositoy extends JpaRepository<Estado, Integer> {
		
}
