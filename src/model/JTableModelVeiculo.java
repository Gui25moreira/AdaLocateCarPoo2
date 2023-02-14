package model;

import model.clientes.Cliente;
import model.veiculos.Veiculo;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class JTableModelVeiculo extends AbstractTableModel {

    private final String[] nomesColunas = {
            "Modelo",
            "Placa",
            "Valor"
    };

    private final List<Veiculo> mLista;

    public JTableModelVeiculo(List<Veiculo> mLista) {
        this.mLista = mLista;
    }

    @Override
    public int getRowCount() {
        if (null == mLista) {
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
        switch (columnIndex) {
            case 0:
                return mLista.get(rowIndex).getModelo();
            case 1:
                return mLista.get(rowIndex).getId();
            case 2:
                return mLista.get(rowIndex).getValorAluguel();
            default:
                return 0;
        }
    }

    public String getColumnName(int indice) {
        return nomesColunas[indice];
    }

    public Class getColClass(int coluna) {
        switch (coluna) {
            case 0, 1, 2:
                return String.class;
            default:
                return null;
        }
    }

    public Veiculo getVeiculo(int linha) {
        Veiculo veiculoLinha = new Veiculo();
        veiculoLinha.setModelo(mLista.get(linha).getModelo());
        veiculoLinha.setPlaca(mLista.get(linha).getId());
        veiculoLinha.setValorAluguel(mLista.get(linha).getValorAluguel());

        return veiculoLinha;
    }


}
