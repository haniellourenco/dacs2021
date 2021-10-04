package br.univille.hanieldacs2021.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.hanieldacs2021.model.Fornecedor;
import br.univille.hanieldacs2021.model.Produto;
import br.univille.hanieldacs2021.service.FornecedorService;
import br.univille.hanieldacs2021.service.ProdutoService;

@Controller
@RequestMapping("/import-produto")
public class ImportadorProdutoController {

    @Autowired
    private FornecedorService fornecedorService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ModelAndView index(@ModelAttribute Fornecedor fornecedor) {
        List<Fornecedor> listaFornecedor = fornecedorService.getAllFornecedores();

        return new ModelAndView("/importproduto/index", "listafornecedor", listaFornecedor);
    }

    @PostMapping
    public ModelAndView busca(Fornecedor fornecedor) {
        List<Fornecedor> listaFornecedor = fornecedorService.getAllFornecedores();

        fornecedor = fornecedorService.getFornecedor(fornecedor.getId());
        List<Produto> listaProduto = produtoService.importProduto(fornecedor);

        HashMap<String, Object> dados = new HashMap<>();
        dados.put("listafornecedor", listaFornecedor);
        dados.put("listaproduto", listaProduto);

        return new ModelAndView("/importproduto/index", dados);
    }
}