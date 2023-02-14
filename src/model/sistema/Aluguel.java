package model.sistema;

import model.clientes.Cliente;
import model.veiculos.Veiculo;

public class Aluguel extends Sistema {


    public Aluguel( Veiculo veiculo, Cliente cliente) {
        super(veiculo, cliente);
    }

    public boolean alugar(){
        return true;
    }

    public String toString() {
        return "Aluguel{" +
                "Identificador='" + getId() + "'," +
                "Data de aluguel='" + this.getData() + '\'' +
                "Veiculo alugado='" + this.getVeiculo().getModelo()  + '\'' +
                '}';
    }
}
