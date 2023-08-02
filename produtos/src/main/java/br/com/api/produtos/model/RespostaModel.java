package br.com.api.produtos.model;

import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

// @Component é usada para marcar uma classe como um componente gerenciado pelo Spring. Ela permite que o Spring detecte e gerencie automaticamente esses componentes, facilitando a integração e a injeção de dependência em sua aplicação.
@Component
@Getter
@Setter
public class RespostaModel {
  private String mensagem;
}
