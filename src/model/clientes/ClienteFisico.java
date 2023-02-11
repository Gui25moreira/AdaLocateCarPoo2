package model.clientes;

import java.util.Date;

public class ClienteFisico extends Cliente{
    private String dataDeNascimento;
    private String idade;

    public ClienteFisico(String nome, String identificador, String dataDeNascimento,Endereco endereco,Contato contato) {
        super(nome, identificador,endereco,contato);
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String toString() {
        return "Cliente{" +
                "nome='" + getNome() + "'," +
                "dataDeNascimento='" + this.dataDeNascimento + '\'' +
                "cpf='" + getIdentificador() + '\'' +
                '}';
    }
}
