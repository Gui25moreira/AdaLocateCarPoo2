package model.repositorys.clientes;


import model.clientes.Cliente;
import model.repositorys.RepositorioEmMemoriaGenerico;

import java.util.List;

public class ClienteJuridicoEmMemoriaRepository extends RepositorioEmMemoriaGenerico<Cliente> {

    public ClienteJuridicoEmMemoriaRepository(List<Cliente> dadosIniciais) {
        super(dadosIniciais);
    }

    public ClienteJuridicoEmMemoriaRepository() {
        super();
    }
}