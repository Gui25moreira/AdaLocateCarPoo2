package model.sistema;

import model.clientes.Cliente;
import model.veiculos.Veiculo;

public class Aluguel extends Sistema {


    public Aluguel(String identificador, String data, String local) {
        super(identificador, data, local);
    }

    public boolean alugar(){
        return true;
    }

    public String toString() {
        return "Aluguel{" +
                "Identificador='" + getId() + "'," +
                "Data de aluguel='" + this.getData() + '\'' +
                "Local do aluguel='" + this.getLocal() + '\'' +
                '}';
    }
}
