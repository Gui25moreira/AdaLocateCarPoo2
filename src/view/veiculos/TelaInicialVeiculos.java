package view.veiculos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


public class TelaInicialVeiculos extends JFrame {

    protected String escolha;
    protected JButton  btnCadastrarVeiculo;
    protected JButton btnConsultarVeiculo;
    protected JButton btnAlterarVeiculo;
    protected JButton btnConsultarDevolucoes;
    protected  JButton btnListarAluegueis;
    protected Integer larguraBtn = 150;
    protected Integer alturaBtn = 30;
    protected JPanel pnlVeiculos;

    public TelaInicialVeiculos(){
        this.Incializar();
        this.eventos();
    }
    private void Incializar(){
        setLayout(null);
        this.setTitle("Tela de Inicio - AdaLocateCar");
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(getpnlVeiculos());
        this.pack();
    }
    protected void btnCadastrarVeiculo(ActionEvent ev){
        escolha = "1";
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha);
        setVisible(false);
        tela.setLocationRelativeTo(null);
        tela.setVisible(true);

    }

    protected void btnConsultarVeiculo(ActionEvent ev){
        escolha = "2";
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha);
        setVisible(false);
        tela.setVisible(true);

    }

    private void eventos(){
        btnCadastrarVeiculo.addActionListener(this::btnCadastrarVeiculo);
        btnConsultarVeiculo.addActionListener(this::btnConsultarVeiculo);
    }

    public JPanel getpnlVeiculos(){
//        new FlowLayout(FlowLayout.CENTER)
        if(pnlVeiculos ==null){
            pnlVeiculos = new JPanel(new GridLayout(5,2,10,10));


            btnCadastrarVeiculo = new JButton("Cadastrar Veículo");
            btnConsultarVeiculo = new JButton("Consultar Veículo");
            btnAlterarVeiculo = new JButton("Alterar Veiculo");
            btnConsultarDevolucoes = new JButton("Consultar Devoluções");
            btnListarAluegueis = new JButton("Listar Alugueis");


            btnCadastrarVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnConsultarVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnAlterarVeiculo.setPreferredSize(new Dimension(larguraBtn, alturaBtn));

            btnConsultarDevolucoes.setPreferredSize(new Dimension(larguraBtn, alturaBtn));
            btnListarAluegueis.setPreferredSize(new Dimension(larguraBtn, alturaBtn));


            pnlVeiculos.add(btnCadastrarVeiculo);
            pnlVeiculos.add(btnConsultarVeiculo);
            pnlVeiculos.add(btnAlterarVeiculo);

            pnlVeiculos.add(btnConsultarDevolucoes);
            pnlVeiculos.add(btnListarAluegueis);


        }
        return pnlVeiculos;
    }
}
