package model.veiculos;

import model.clientes.Cliente;
import model.repositorys.Entidade;

import java.io.Serializable;
import java.math.BigDecimal;

public class Veiculo implements Comparable, Serializable, Entidade{

    private String modelo;
    private String anoDeFabricacao;
    private String marca;
    private String placa;
    private String tipoDoVeiculo;
    private BigDecimal valorAluguel;
    private boolean isAlugado;
    private Cliente cliente;

    public Veiculo() {
    }

    public Veiculo(String modelo, String placa, String marca, String anoDeFabricacao, String tipoDoVeiculo) {
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
        this.anoDeFabricacao = anoDeFabricacao;
        this.tipoDoVeiculo = tipoDoVeiculo;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public String getId() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnoDeFabricacao() {
        return anoDeFabricacao;
    }

    public void setAnoDeFabricacao(String anoDeFabricacao) {
        this.anoDeFabricacao = anoDeFabricacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public BigDecimal getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(BigDecimal valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public boolean isAlugado() {
        return isAlugado;
    }

    public void setAlugado(boolean alugado) {
        isAlugado = alugado;
    }

    public String getTipoDoVeiculo() {
        return tipoDoVeiculo;
    }

    public void setTipoDoVeiculo(String tipoDoVeiculo) {
        this.tipoDoVeiculo = tipoDoVeiculo;
    }

    public String toString() {
        return "Veiculo{" +
                "Modelo='" + getModelo() + "'," +
                '\'' +
                "Placa='" + getId() + '\'' +
                '}';
    }
}
