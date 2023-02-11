package model.repositorys.clientes;


import model.clientes.Cliente;
import model.repositorys.RepositorioEmMemoriaGenerico;

import java.util.List;

public class ClienteFisicoEmMemoriaRepository extends RepositorioEmMemoriaGenerico<Cliente> {

    public ClienteFisicoEmMemoriaRepository(List<Cliente> dadosIniciais) {
        super(dadosIniciais);
    }
    public ClienteFisicoEmMemoriaRepository() {
        super();
    }
}