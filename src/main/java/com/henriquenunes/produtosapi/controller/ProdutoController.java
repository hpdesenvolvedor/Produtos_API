package com.henriquenunes.produtosapi.controller;

import com.henriquenunes.produtosapi.model.Produto;
import com.henriquenunes.produtosapi.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto) {
        System.out.println("Produto adicionado " + produto);
        var id = UUID.randomUUID().toString();
        produto.setId(id);
        produtoRepository.save(produto);
        return produto;
    }

    public Produto obterProdutoPorId(String id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.isPresent() ? produto.get() : null;
    }

}
