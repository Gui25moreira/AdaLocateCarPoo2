package model.veiculos;

import model.clientes.Cliente;
import model.repositorys.Entidade;
import model.sistema.Aluguel;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.EnumMap;

public class Veiculo implements Comparable, Serializable, Entidade {

    private String modelo;
    private String anoDeFabricacao;
    private String marca;
    private String placa;
    private String tipoDoVeiculo;
    private int valorAluguel;
    private boolean isAlugado;
    private Cliente cliente;
    private Aluguel aluguel;


    public Veiculo() {
    }

    public Veiculo(String modelo, String placa, String marca, String anoDeFabricacao, String tipoDoVeiculo) {
        this.modelo = modelo;
        this.placa = placa;
        this.marca = marca;
        this.anoDeFabricacao = anoDeFabricacao;
        this.tipoDoVeiculo = tipoDoVeiculo;
        this.isAlugado = false;
        if (tipoDoVeiculo.equals("Pequeno")) {
            this.valorAluguel = 100;
        } else if (tipoDoVeiculo.equals("Medio")) {
            this.valorAluguel = 150;
        } else if (tipoDoVeiculo.equals("SUV")) {
            this.valorAluguel = 200;
        } else {
            System.out.println("Digite uma opção de veículo válida!");
        }
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


    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(int valorAluguel) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String toString() {
        return "Veiculo{" +
                "Modelo='" + getModelo() + "'," +
                '\'' +
                "Placa='" + getId() + '\'' +
                '\'' +
                '}';
    }
}
