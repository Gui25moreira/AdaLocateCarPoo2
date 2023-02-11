package model.sistema;

import model.clientes.Cliente;
import model.repositorys.Entidade;
import model.veiculos.Veiculo;

import java.io.Serializable;
import java.util.Date;

public class Sistema implements Comparable, Serializable{

    private String identificador;
    private String data;
    private String local;
    private String horario;
    private Veiculo veiculo;
    private Cliente cliente;

    public Sistema(String identificador, String data, String local) {
        this.identificador = identificador;
        this.data = data;
        this.local = local;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
        return identificador;
    }
}
