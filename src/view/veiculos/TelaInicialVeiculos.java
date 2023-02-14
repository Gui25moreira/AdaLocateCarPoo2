package view.veiculos;

import model.clientes.Cliente;
import view.TelaInicial;
import view.services.GeraRodape;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class TelaInicialVeiculos extends JFrame {

    protected String escolha;
    protected JButton btnBotaoSair = new JButton("Sair");
    protected JButton btnVoltar = new JButton("Voltar");
    protected GeraRodape pnlRodape = new GeraRodape();
    protected JButton btnCadastrarVeiculo;
    protected JButton btnConsultarVeiculo;

    protected JButton btnConsultarDevolucoes;
    protected JButton btnListarAluegueis;
    protected Integer larguraBtn = 200;
    protected Integer alturaBtn = 30;
    protected JPanel pnlVeiculos;
    protected Cliente cliente = new Cliente();

    public TelaInicialVeiculos() {
        this.Incializar();
        this.eventos();
    }

    private void Incializar() {
        setLayout(null);
        this.setTitle("Tela de Inicio - AdaLocateCar");
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(getpnlVeiculos(), BorderLayout.CENTER);
        this.getContentPane().add(pnlRodape.getPnlRodapeTelaInicial(btnBotaoSair, btnVoltar), BorderLayout.PAGE_END);
        this.pack();
    }

    protected void btnCadastrarVeiculo(ActionEvent ev) {
        escolha = "1";
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
        setVisible(false);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);

    }

    protected void btnConsultarVeiculo(ActionEvent ev) {
        escolha = "2";
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
        setVisible(false);
        tela.setVisible(true);

    }

    private void eventos() {
        btnCadastrarVeiculo.addActionListener(this::btnCadastrarVeiculo);
        btnConsultarVeiculo.addActionListener(this::btnConsultarVeiculo);
        btnBotaoSair.addActionListener(this::setBotaoSair);
        btnVoltar.addActionListener(this::setBtnVoltar);
    }

    public JPanel getpnlVeiculos() {
//        new FlowLayout(FlowLayout.CENTER)
        if (pnlVeiculos == null) {
            pnlVeiculos = new JPanel(new GridLayout(4, 2, 10, 10));


            btnCadastrarVeiculo = new JButton("Cadastrar Veículo");
            btnConsultarVeiculo = new JButton("Consultar Veículo");
            btnConsultarDevolucoes = new JButton("Consultar Devoluções");
            btnListarAluegueis = new JButton("Listar Alugueis");


            btnCadastrarVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnConsultarVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));

            btnConsultarDevolucoes.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnListarAluegueis.setPreferredSize(new Dimension(larguraBtn, alturaBtn));


            pnlVeiculos.add(btnCadastrarVeiculo);
            pnlVeiculos.add(btnConsultarVeiculo);

            pnlVeiculos.add(btnConsultarDevolucoes);
            pnlVeiculos.add(btnListarAluegueis);


        }
        return pnlVeiculos;
    }

    protected void setBotaoSair(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    protected void setBtnVoltar(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();
        TelaInicial tela = new TelaInicial();
        tela.setVisible(true);
    }
}
