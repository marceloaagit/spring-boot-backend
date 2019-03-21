package com.marceloalves.backend.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.backend.domain.Categoria;

@Repository
public interface CategoriaRepositoy extends JpaRepository<Categoria, Integer> {
		
}
