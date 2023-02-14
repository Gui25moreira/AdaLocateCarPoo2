package view.services;

import javax.swing.*;
import java.awt.*;

public class GeraRodape {

    protected JButton btnBotaoSair;
    protected JButton btnCadastro;
    protected JButton btnLimparCampos;

    protected JButton btnVoltar;
    protected JButton btnAlugar;
    protected JButton btnDeletar;
    protected JButton btnPesquisar;

    protected JButton btnAtualizar;
    protected JButton btnLogin;
    protected JPanel pnlRodape;

    public GeraRodape(){

    }
    public JPanel getPnlRodapeComum(JButton btnCadastro, JButton btnBotaoSair,JButton btnVoltar, JButton btnLimparCampos){

        if (pnlRodape == null) {

            pnlRodape = new JPanel();
            pnlRodape.setLayout(new FlowLayout(FlowLayout.CENTER));

            pnlRodape.add(btnCadastro);
            pnlRodape.add(btnLimparCampos);
            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnBotaoSair);

        }
        return pnlRodape;
    }
    public JPanel getPnlRodapeManipularEntidade(JButton btnAtualizar, JButton btnDeletar, JButton btnLimparCampos,JButton btnBotaoSair,JButton btnVoltar) {

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
    public JPanel getPnlRodapeAlugarVeiculo(JButton btnAlugar, JButton btnPesquisar, JButton btnVoltar, JButton btnSair){

         if (pnlRodape == null) {

            pnlRodape = new JPanel();
            pnlRodape.setLayout(new FlowLayout(FlowLayout.CENTER));

            pnlRodape.add(btnAlugar);
            pnlRodape.add(btnPesquisar);
            pnlRodape.add(btnVoltar);
            pnlRodape.add(btnSair);

        }
        return pnlRodape;
    }
    public JPanel getPnlRodapeLogin(JButton btnLogin, JButton btnVoltar){

        if (pnlRodape == null) {

            pnlRodape = new JPanel();
            pnlRodape.setLayout(new FlowLayout(FlowLayout.CENTER));

            pnlRodape.add(btnLogin);
            pnlRodape.add(btnVoltar);
        }
        return pnlRodape;
    }
    public JPanel getPnlRodapeTelaInicial(JButton btnBotaoSair, JButton btnVoltar){

        if (pnlRodape == null) {

            pnlRodape = new JPanel();
            pnlRodape.setLayout(new FlowLayout(FlowLayout.CENTER));

            pnlRodape.add(btnBotaoSair);
            pnlRodape.add(btnVoltar);
        }
        return pnlRodape;
    }
}
