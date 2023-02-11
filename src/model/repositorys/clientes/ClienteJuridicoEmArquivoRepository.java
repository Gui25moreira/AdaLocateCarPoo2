package model.repositorys.clientes;

import model.clientes.Cliente;
import model.repositorys.RepositorioEmArquivoGenerico;

public class ClienteJuridicoEmArquivoRepository extends RepositorioEmArquivoGenerico<Cliente> {

    public  ClienteJuridicoEmArquivoRepository() {
        super("dados_pessoa.txt");
    }
}

