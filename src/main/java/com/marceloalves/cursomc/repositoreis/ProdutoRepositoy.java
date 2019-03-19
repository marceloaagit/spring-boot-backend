package com.marceloalves.cursomc.repositoreis;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marceloalves.cursomc.domain.Produto;

@Repository
public interface ProdutoRepositoy extends JpaRepository<Produto, Integer> {

}
