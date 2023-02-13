package view;

import view.clientes.TelaInicialClientes;
import view.veiculos.TelaInicialVeiculos;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {
    protected JTextArea texto;
    protected Integer larguraBtn = 150;
    protected Integer alturaBtn = 30;

    protected JPanel pnlForm;

    protected JPanel pnlInicial;
    protected JPanel pnlBotaoSair;
    protected JButton btnAreaClientes;
    protected JButton btnAreaVeiculos;
    protected JButton btnSair;

    public TelaInicial(){
        this.Incializar();
        this.eventos();
    }

    private void Incializar(){
        setLayout(null);
        this.setTitle("Home Page - AdaLocateCar");
        this.setSize(320,150);
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(getPnlInicial());

    }
    public JPanel getPnlForm(){
        if(pnlForm==null){
            pnlForm = new JPanel();
        }
        return pnlForm;
    }
    protected void btnClientArea(ActionEvent ev){

        TelaInicialClientes segunda = new TelaInicialClientes();
        setVisible(false);
        this.setLocationRelativeTo(null);
        segunda.setVisible(true);

    }
    protected void btnVehicleArea(ActionEvent ev){

        TelaInicialVeiculos tela = new TelaInicialVeiculos();
        setVisible(false);
        this.setLocationRelativeTo(null);
        tela.setVisible(true);

    }
    private void eventos(){
        btnAreaClientes.addActionListener(this::btnClientArea);;
        btnAreaVeiculos.addActionListener(this::btnVehicleArea);;
    }


    public JPanel getPnlInicial() {
//        new FlowLayout(FlowLayout.CENTER)
        if (pnlInicial == null) {
            pnlInicial = new JPanel(new FlowLayout());

            btnAreaClientes = new JButton("Client Area");
            btnAreaVeiculos = new JButton(" Vehicle Area ");
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

//    public JButton getPnlBotaoSair() {
//
//           btnSair = new JButton("Sair");
//           btnSair.setLocation(400,300);
//        return btnSair;
//        }
}