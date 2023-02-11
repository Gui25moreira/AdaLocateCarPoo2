package model.clientes;

import model.repositorys.Entidade;
import model.veiculos.Veiculo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

public class Cliente implements Comparable, Serializable, Entidade {

    private String nome;
    private String identificador;
    private Endereco endereco;
    private Contato contato;
    private Veiculo[] veiculo;
    private BigDecimal debito;

    public Cliente() {
    }

    public Cliente(String nome, String identificador, Endereco endereco, Contato contato) {
        this.nome = nome;
        this.identificador = identificador;
        this.endereco = endereco;
        this.contato = contato;
        //this.idade = calculaIdade(dataDeNascimento);
    }

    public static ArrayList<Cliente> getClientes(){
        ArrayList<Cliente> clientes = new ArrayList();
        return clientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdentificador() {
        return identificador;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contato getContato() {
        return contato;
    }

    public void setContato(Contato contato) {
        this.contato = contato;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
    @Override
    public String getId() {
        return identificador;
    }
}


