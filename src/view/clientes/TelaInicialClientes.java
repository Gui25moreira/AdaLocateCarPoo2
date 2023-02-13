package view.clientes;



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
    protected JButton btnAlterarCliente;
    protected JButton btnConsultarVeiculo;
    protected JButton btnConsultarClientes;
    protected JButton btnConsultarDevolucoes;
    protected JButton btnListarAlugueis;
    protected JButton btnDevolverVeiculo;
    protected JButton btnAlugarVeiculo;



    public TelaInicialClientes(){
        this.incializar();
        this.eventos();
    }
    private void incializar(){
        setLayout(null);
        this.setTitle("Tela de Inicio - AdaLocateCar");
        this.setSize(500,300);
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(getPnlClientes());
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

    private void eventos(){
        btnCadastrarCliente.addActionListener(this::btnCadastrarCliente);
        btnConsultarClientes.addActionListener(this::btnConsultarClientes);
    }



    public JPanel getPnlClientes(){
//        new FlowLayout(FlowLayout.CENTER)
        if(pnlClientes ==null){
            pnlClientes = new JPanel();
            pnlClientes.setLayout(new GridLayout(4,2, 15,15));

            btnCadastrarCliente = new JButton("Cadastrar Cliente");
            btnConsultarClientes = new JButton("Consultar Cliente");
            btnAlterarCliente = new JButton("Alterar Cliente");

            btnConsultarVeiculo = new JButton("Consultar Veículo");
            btnAlugarVeiculo = new JButton("Alugar Veículo");
            btnDevolverVeiculo = new JButton("Devolver Veículo");

            btnConsultarDevolucoes = new JButton("Consultar Devoluções");
            btnListarAlugueis = new JButton("Listar Alugueis");


            btnCadastrarCliente.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnConsultarClientes.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnAlterarCliente.setPreferredSize(new Dimension(larguraBtn, alturaBtn));

            btnConsultarVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnAlugarVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnDevolverVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));

            btnConsultarDevolucoes.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnListarAlugueis.setPreferredSize(new Dimension(larguraBtn, alturaBtn));


            pnlClientes.add(btnCadastrarCliente);
            pnlClientes.add(btnConsultarClientes);
            pnlClientes.add(btnAlterarCliente);


            pnlClientes.add(btnConsultarVeiculo);
            pnlClientes.add(btnAlugarVeiculo);
            pnlClientes.add(btnDevolverVeiculo);

            pnlClientes.add(btnConsultarDevolucoes);
            pnlClientes.add(btnListarAlugueis);


        }
        return pnlClientes;
    }
}
