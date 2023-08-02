package br.com.api.produtos.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity // para o arquivo entender que precisa gerar uma tabela
@Table(name = "produtos") // diz o nome da tabela
@Getter
@Setter
public class ProdutoModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long codigo;
  private String nome;
  private String marca;
}
