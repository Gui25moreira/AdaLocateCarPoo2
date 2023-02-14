package model.sistema;

import model.clientes.Cliente;
import model.repositorys.Entidade;
import model.veiculos.Veiculo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class Sistema implements Comparable, Serializable, Entidade{

    private LocalDateTime data;
    private Veiculo veiculo;
    private Cliente cliente;

    public Sistema(Veiculo veiculo, Cliente cliente) {

        this.data = LocalDateTime.now();
        this.veiculo = veiculo;
        this.cliente = cliente;

    }

    public LocalDateTime getData() {
        return data;
    }


    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String getId() {
        return data.toString();
    }
}
