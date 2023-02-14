package model.repositorys.veiculos;

import model.repositorys.RepositorioEmArquivoGenerico;
import model.veiculos.Veiculo;

public class VeiculoEmArquivoRepository extends RepositorioEmArquivoGenerico<Veiculo> {
    public VeiculoEmArquivoRepository() {
        super("dados_veiculos.txt");
    }
}

