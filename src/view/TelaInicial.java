package view;

import view.clientes.TelaInicialClientes;
import view.veiculos.TelaInicialVeiculos;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {
    protected Integer larguraBtn = 150;
    protected Integer alturaBtn = 30;

    protected JPanel pnlInicial;
    protected JButton btnAreaClientes;
    protected JButton btnAreaVeiculos;
    protected JButton btnSair;

    public TelaInicial(){
        this.Incializar();
        this.eventos();
    }

    private void Incializar(){
        setLayout(null);
        this.setTitle("AdaLocateCar");
        this.setSize(320,150);
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(getPnlInicial());

    }
    protected void areaDosClientes(ActionEvent ev){

        setVisible(false);
        TelaInicialClientes tela = new TelaInicialClientes();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);

    }
    protected void areaDosVeiculos(ActionEvent ev){

        TelaInicialVeiculos tela = new TelaInicialVeiculos();
        setVisible(false);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);

    }
    private void eventos(){
        btnAreaClientes.addActionListener(this::areaDosClientes);
        btnAreaVeiculos.addActionListener(this::areaDosVeiculos);
        btnSair.addActionListener(this::btnBotaoSair);
    }


    public JPanel getPnlInicial() {

        if (pnlInicial == null) {
            pnlInicial = new JPanel(new FlowLayout());

            btnAreaClientes = new JButton("Area do cliente");
            btnAreaVeiculos = new JButton(" Área dos veículos");
            btnSair = new JButton("Sair");
            btnAreaClientes.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnAreaVeiculos.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnSair.setPreferredSize(new Dimension(larguraBtn,alturaBtn));

            pnlInicial.add(btnAreaClientes);
            pnlInicial.add(btnAreaVeiculos);
            pnlInicial.add(btnSair);
        }
        return pnlInicial;
    }

    protected void btnBotaoSair(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}