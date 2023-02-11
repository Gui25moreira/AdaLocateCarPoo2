package model.sistema;

public class Devolucao extends Sistema {

    public Devolucao(String identificador, String data, String local) {
        super(identificador, data, local);
    }

    public boolean devolverVeiculo(){
     return true;
 }

}
