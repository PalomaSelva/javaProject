package br.com.api.produtos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// Geralmente, um serviço é uma classe responsável por realizar uma lógica de negócio específica.

import br.com.api.produtos.model.ProdutoModel;
import br.com.api.produtos.model.RespostaModel;
import br.com.api.produtos.repository.ProdutoRepository;

@Service
public class ProdutoService {
  // usada para realizar a injeção automática de dependência
  @Autowired
  private ProdutoRepository pr;

  @Autowired
  private RespostaModel rm;

  // método para listar os produtos
  public Iterable<ProdutoModel> listar() {
    return pr.findAll();
  }

  // método para cadastrar ou atualizar produtos
  public ResponseEntity<?> cadastrarAtualizar(ProdutoModel pm, String acao) {

    if (pm.getNome().equals("")) {

      rm.setMensagem("O nome do produto é obrigatório");
      return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);

    } else if (pm.getMarca().equals("")) {

      rm.setMensagem("O nome da marca é obrigatório");
      return new ResponseEntity<RespostaModel>(rm, HttpStatus.BAD_REQUEST);

    } else {
      if (acao.equals("cadastrar")) {

        return new ResponseEntity<ProdutoModel>(pr.save(pm), HttpStatus.CREATED);

      } else {

        return new ResponseEntity<ProdutoModel>(pr.save(pm), HttpStatus.OK);

      }
    }
  }
  
  // método para remover produtos
  public ResponseEntity<RespostaModel> remover(long codigo) {
    
    pr.deleteById(codigo);

    rm.setMensagem("O produto foi removido");
    return new ResponseEntity<RespostaModel>(rm, HttpStatus.OK);
  }
}

