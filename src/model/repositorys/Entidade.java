package model.repositorys;

import model.clientes.Contato;
import model.clientes.Endereco;

public interface Entidade {

    String getNome();
    String getId();
    Endereco getEndereco();
    Contato getContato();
}
