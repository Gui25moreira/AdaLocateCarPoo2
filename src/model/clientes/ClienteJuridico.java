package model.clientes;

public class ClienteJuridico extends Cliente {
    public ClienteJuridico(String nome, String identificador,Endereco endereco,Contato contato) {
        super(nome, identificador,endereco,contato);
    }
    public String toString() {
        return "Cliente{" +
                "nome='" + getNome() + "'," +
                '\'' +
                "CNP='" + getIdentificador() + '\'' +
                '}';
    }
}