package view.clientes;



import view.TelaInicial;
import view.services.GeraRodape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class TelaInicialClientes extends JFrame {

    protected Integer larguraBtn = 150;
    protected Integer alturaBtn = 30;
    protected JPanel pnlClientes;
    public String escolha;

    //Botões

    protected JButton btnCadastrarCliente;
    protected JButton btnConsultarVeiculo;
    protected JButton btnConsultarClientes;

    protected JButton btnDevolverVeiculo;
    protected JButton btnAlugarVeiculo;

    protected JButton btnBotaoSair = new JButton("Sair");
    protected JButton btnVoltar = new JButton("Voltar");
    protected GeraRodape pnlRodape = new GeraRodape();


    public TelaInicialClientes(){
        this.incializar();
        this.eventos();
    }
    private void incializar(){
        setLayout(null);
        this.setTitle("Tela de Inicio - AdaLocateCar");
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(getPnlClientes(),BorderLayout.CENTER);
        this.getContentPane().add(pnlRodape.getPnlRodapeTelaInicial(btnBotaoSair,btnVoltar),BorderLayout.PAGE_END);
        this.pack();
    }

    protected void btnCadastrarCliente(ActionEvent ev){
        escolha = "1";
        TelaDeAcoesClientes tela = new TelaDeAcoesClientes(escolha);
        setVisible(false);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);

    }

    protected void btnConsultarClientes(ActionEvent ev){
          escolha = "2";
          TelaDeAcoesClientes tela = new TelaDeAcoesClientes(escolha);
          setVisible(false);
          tela.setLocationRelativeTo(null);
          tela.setVisible(true);

    }
    protected void btnAlugarVeiculo(ActionEvent ev){
        escolha = "3";
        TelaDeAcoesClientes tela = new TelaDeAcoesClientes(escolha);
        setVisible(false);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);
    }

    private void eventos(){
        btnCadastrarCliente.addActionListener(this::btnCadastrarCliente);
        btnConsultarClientes.addActionListener(this::btnConsultarClientes);
        btnAlugarVeiculo.addActionListener(this::btnAlugarVeiculo);
        btnVoltar.addActionListener(this::btnVoltar);
        btnBotaoSair.addActionListener(this::btnBotaoSair);
    }



    public JPanel getPnlClientes(){
//        new FlowLayout(FlowLayout.CENTER)
        if(pnlClientes ==null){
            pnlClientes = new JPanel();
            pnlClientes.setLayout(new GridLayout(5,1, 15,15));

            btnCadastrarCliente = new JButton("Cadastrar Cliente");
            btnConsultarClientes = new JButton("Consultar Cliente");

            btnConsultarVeiculo = new JButton("Consultar Veículo");
            btnAlugarVeiculo = new JButton("Alugar Veículo");
            btnDevolverVeiculo = new JButton("Devolver Veículo");

            btnCadastrarCliente.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnConsultarClientes.setPreferredSize(new Dimension(larguraBtn, alturaBtn));

            btnConsultarVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnAlugarVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnDevolverVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));

            pnlClientes.add(btnCadastrarCliente);
            pnlClientes.add(btnConsultarClientes);


            pnlClientes.add(btnConsultarVeiculo);
            pnlClientes.add(btnAlugarVeiculo);
            pnlClientes.add(btnDevolverVeiculo);

        }
        return pnlClientes;
    }
    protected void btnBotaoSair(ActionEvent ev){
        this.setVisible(false);
        this.dispose();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    protected void btnVoltar(ActionEvent ev){
        this.setVisible(false);
        this.dispose();
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);
    }
}
