package br.univille.hanieldacs2021.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.hanieldacs2021.model.Produto;
import br.univille.hanieldacs2021.service.ProdutoService;

@Controller
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public ModelAndView index() {
        // Produto prod1 = new Produto();
        // prod1.setDescricao("descricao");
        // prod1.setDataRegistro(new Date());
        // prod1.setPreco(2000);

        // Produto prod2 = new Produto();
        // prod2.setDescricao("descricao");
        // prod2.setDataRegistro(new Date());
        // prod2.setPreco(2000);

        List<Produto> listaProdutos = service.getAllProdutos();
        // listaProdutos.add(prod1);
        // listaProdutos.add(prod2);

        return new ModelAndView("produto/index", "listaProdutos", listaProdutos);
    }
}