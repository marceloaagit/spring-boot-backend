package com.marceloalves.backend.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.backend.domain.Cliente;

@Repository
public interface ClienteRepositoy extends JpaRepository<Cliente, Integer> {
		
}
