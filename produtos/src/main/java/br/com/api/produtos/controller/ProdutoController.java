package br.com.api.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
// import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.produtos.model.ProdutoModel;
import br.com.api.produtos.model.RespostaModel;
import br.com.api.produtos.service.ProdutoService;

@RestController
// @CrossOrigin(origins = "http://localhost:3000") // libera o acesso apenas para essa porta
// @CrossOrigin(origins = "*") // libera o acesso para todas as portas


public class ProdutoController {

  @Autowired
  private ProdutoService ps;

  @DeleteMapping("/remove/{codigo}")
  public ResponseEntity<RespostaModel> remove(@PathVariable long codigo) {
    return ps.remover(codigo);
  }

  @PostMapping("/cadastrar")
  public ResponseEntity<?> cadastrar(@RequestBody ProdutoModel pm) {
    return ps.cadastrarAtualizar(pm, "cadastrar");
  }

  @PutMapping("/atualizar")
  public ResponseEntity<?> atualizar(@RequestBody ProdutoModel pm) {
    return ps.cadastrarAtualizar(pm, "alterar");
  }

  @GetMapping("/listar")
  public Iterable<ProdutoModel> lista() {
    return ps.listar();
  }

  @GetMapping("/")
  public String rota() {
    return "API de produtos funcionando";
  }
}
