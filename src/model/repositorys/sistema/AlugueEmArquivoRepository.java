package model.repositorys.sistema;

import model.repositorys.RepositorioEmArquivoGenerico;
import model.sistema.Sistema;

public class AlugueEmArquivoRepository extends RepositorioEmArquivoGenerico<Sistema> {

    public  AlugueEmArquivoRepository() {
        super("dados_alugueis.txt");
    }
}
