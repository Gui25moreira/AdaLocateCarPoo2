package model.clientes;

import java.util.Date;

public class ClienteFisico extends Cliente{
    private String dataDeNascimento;
    private String idade;

    public ClienteFisico(String nome, String identificador, String senha,Endereco endereco,Contato contato) {
        super(nome, identificador,senha,endereco,contato);
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
