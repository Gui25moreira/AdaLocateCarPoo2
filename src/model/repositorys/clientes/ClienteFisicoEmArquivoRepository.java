package model.repositorys.clientes;

import model.clientes.Cliente;
import model.repositorys.RepositorioEmArquivoGenerico;

public class ClienteFisicoEmArquivoRepository extends RepositorioEmArquivoGenerico<Cliente> {
    public  ClienteFisicoEmArquivoRepository() {
        super("dados_pessoa.txt");
    }
}
