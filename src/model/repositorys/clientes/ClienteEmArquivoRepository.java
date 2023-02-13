package model.repositorys.clientes;

import model.clientes.Cliente;
import model.repositorys.RepositorioEmArquivoGenerico;

public class ClienteEmArquivoRepository extends RepositorioEmArquivoGenerico<Cliente> {
    public ClienteEmArquivoRepository() {
        super("dados_pessoa.txt");
    }
}
