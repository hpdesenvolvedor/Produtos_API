package com.henriquenunes.produtosapi.repository;

import com.henriquenunes.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, String> {
}
