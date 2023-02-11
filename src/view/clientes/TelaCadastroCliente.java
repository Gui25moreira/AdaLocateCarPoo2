package view.clientes;

import model.clientes.ClienteFisico;
import model.clientes.ClienteJuridico;
import model.repositorys.clientes.ClienteFisicoEmArquivoRepository;
import view.services.ClienteService;
import view.services.GeraRodape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class TelaCadastroCliente extends JFrame {
    protected ClienteFisicoEmArquivoRepository repositorioDeClientes = new ClienteFisicoEmArquivoRepository();
    protected JButton btnCadastro = new JButton("Cadastrar");
    protected JButton btnBotaoSair = new JButton("Sair");
    protected JButton btnLimparCampos = new JButton("Limpar campos");

    protected GeraRodape pnlRodape = new GeraRodape();

    protected int tamanhoColunasTextField = 20;
    protected JLabel lblNome;
    protected JTextField txtNome;

    protected JLabel lblCpf;
    protected JTextField txtCpf;

    protected JLabel lblDataDeNascimento;
    protected JTextField txtDataDeNascimento;

    protected JLabel lblRua;
    protected JTextField txtRua;

    protected JLabel lblBairro;
    protected JTextField txtBairro;

    protected JLabel lblNumero;
    protected JTextField txtNumero;

    protected JLabel lblEstado;
    protected JTextField txtEstado;

    protected JLabel lblNumeroDeTelefone;
    protected JTextField txtNumeroDeTelefone;

    protected JLabel lblEmail;
    protected JTextField txtEmail;


    protected JPanel pnlFormCadastroCliente;

    public TelaCadastroCliente() {
        this.incializar();
        this.eventos();
    }

    private void incializar() {
        this.setLocationRelativeTo(null);
        this.setTitle("Cadastro - Cliente");
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        this.getContentPane().add(getPnlFormCadastroCliente(), BorderLayout.CENTER);
        this.getContentPane().add(pnlRodape.getPnlRodapeComum(btnCadastro, btnBotaoSair, btnLimparCampos), BorderLayout.PAGE_END);
        this.addMouseListener(new MouseAdapter() {public void mouseClicked(MouseEvent e){System.out.println("Clicou");}});
        this.pack();
    }

    protected abstract void btnCadastrarCliente(ActionEvent ev);
    protected abstract void btnBotaoSair(ActionEvent ev);
    protected abstract void btnLimparCampos(ActionEvent ev);
    private void eventos(){
        btnCadastro.addActionListener(this::btnCadastrarCliente);
        btnBotaoSair.addActionListener(this::btnBotaoSair);
        btnLimparCampos.addActionListener(this::btnLimparCampos);
    }

    public JPanel getPnlFormCadastroCliente() {

        if (pnlFormCadastroCliente == null) {

            pnlFormCadastroCliente = new JPanel();
            pnlFormCadastroCliente.setLayout(new GridLayout(9, 1, 20, 15));

            lblNome = new JLabel("Nome");
            txtNome = new JTextField(tamanhoColunasTextField);

            lblCpf = new JLabel("Cpf");
            txtCpf = new JTextField(tamanhoColunasTextField);

            lblDataDeNascimento = new JLabel("Data de nascimento");
            txtDataDeNascimento = new JTextField(tamanhoColunasTextField);

            lblRua = new JLabel("Rua");
            txtRua = new JTextField(tamanhoColunasTextField);

            lblBairro = new JLabel("Bairro");
            txtBairro = new JTextField(tamanhoColunasTextField);

            lblNumero = new JLabel("Numero");
            txtNumero = new JTextField(tamanhoColunasTextField);

            lblEstado = new JLabel("Estado");
            txtEstado = new JTextField(tamanhoColunasTextField);

            lblNumeroDeTelefone = new JLabel("Numero de telefone");
            txtNumeroDeTelefone = new JTextField(tamanhoColunasTextField);

            lblEmail = new JLabel("E-mail");
            txtEmail = new JTextField(tamanhoColunasTextField);

            pnlFormCadastroCliente.add(lblNome);
            pnlFormCadastroCliente.add(txtNome);

            pnlFormCadastroCliente.add(lblCpf);
            pnlFormCadastroCliente.add(txtCpf);

            pnlFormCadastroCliente.add(lblDataDeNascimento);
            pnlFormCadastroCliente.add(txtDataDeNascimento);

            pnlFormCadastroCliente.add(lblRua);
            pnlFormCadastroCliente.add(txtRua);

            pnlFormCadastroCliente.add(lblBairro);
            pnlFormCadastroCliente.add(txtBairro);

            pnlFormCadastroCliente.add(lblNumero);
            pnlFormCadastroCliente.add(txtNumero);

            pnlFormCadastroCliente.add(lblEstado);
            pnlFormCadastroCliente.add(txtEstado);

            pnlFormCadastroCliente.add(lblEmail);
            pnlFormCadastroCliente.add(txtEmail);

            pnlFormCadastroCliente.add(lblNumeroDeTelefone);
            pnlFormCadastroCliente.add(txtNumeroDeTelefone);


        }
        return pnlFormCadastroCliente;
    }

}