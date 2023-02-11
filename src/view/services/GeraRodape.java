package view.services;

import javax.swing.*;
import java.awt.*;

public class GeraRodape {

    protected JButton btnBotaoSair;
    protected JButton btnCadastro;
    protected JButton btnLimparCampos;

    protected JButton btnVoltar;
    protected JButton btnDeletar;

    protected JButton btnAtualizar;
    protected JPanel pnlRodape;

    public GeraRodape(){

    }
    public JPanel getPnlRodapeComum(JButton btnCadastro, JButton btnBotaoSair, JButton btnLimparCampos){

        if (pnlRodape == null) {

            pnlRodape = new JPanel();
            pnlRodape.setLayout(new FlowLayout(FlowLayout.CENTER));

            pnlRodape.add(btnCadastro);
            pnlRodape.add(btnLimparCampos);
            pnlRodape.add(btnBotaoSair);

        }
        return pnlRodape;
    }
    public JPanel getPnlRodapeManipularCliente(JButton btnAtualizar, JButton btnDeletar, JButton btnLimparCampos,JButton btnBotaoSair,JButton btnVoltar) {

        if (pnlRodape == null) {

            pnlRodape = new JPanel();
            pnlRodape.setLayout(new FlowLayout(FlowLayout.CENTER));

            pnlRodape.add(btnAtualizar);
            pnlRodape.add(btnDeletar);
            pnlRodape.add(btnLimparCampos);
            pnlRodape.add(btnBotaoSair);
            pnlRodape.add(btnVoltar);

        }
        return pnlRodape;
    }
}
