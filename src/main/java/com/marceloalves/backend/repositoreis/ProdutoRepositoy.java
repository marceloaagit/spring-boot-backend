package com.marceloalves.backend.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.backend.domain.Produto;

@Repository
public interface ProdutoRepositoy extends JpaRepository<Produto, Integer> {

}
