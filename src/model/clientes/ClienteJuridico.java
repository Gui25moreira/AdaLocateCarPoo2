package model.clientes;

public class ClienteJuridico extends Cliente {
    public ClienteJuridico(String nome, String identificador, String senha, Endereco endereco, Contato contato) {
        super(nome, identificador, senha, endereco, contato);
    }

    public String toString() {
        return "Cliente{" +
                "nome='" + getNome() + "'," +
                '\'' +
                "CNPJ='" + getIdentificador() + '\'' +
                '}';
    }
}
