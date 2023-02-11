package model.clientes;

import model.repositorys.Entidade;

import java.io.Serializable;

public class Contato implements Serializable{
    private String telefone;
    private String email;

    public Contato() {

    }

    public Contato(String telefone, String email) {
        this.telefone = telefone;
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
