package model;

import model.clientes.Cliente;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class JTableModel extends AbstractTableModel {

    private final String[] nomesColunas = {
            "Nome",
            "Cpf"
    };

    private final List<Cliente> mLista;

    public JTableModel(List<Cliente> mLista) {
        this.mLista = mLista;
    }

    @Override
    public int getRowCount() {
        if(null == mLista){
            return 0;
        }
        return mLista.size();
    }

    @Override
    public int getColumnCount() {
        return nomesColunas.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex){
            case 0:
                return mLista.get(rowIndex).getNome();
            case 1:
                return mLista.get(rowIndex).getId();
            default:
                return 0;
        }
    }

    public String getColumnName(int indice){
        return nomesColunas[indice];
    }

    public Class getColClass(int coluna){
        switch (coluna){
            case 0,1:
                return String.class;
            default:
                return null;
        }
    }

    public Cliente getCliente(int linha){
        Cliente clienteLinha = new Cliente();
        clienteLinha.setNome(mLista.get(linha).getNome());
        clienteLinha.setIdentificador(mLista.get(linha).getId());

        return clienteLinha;
    }


}
