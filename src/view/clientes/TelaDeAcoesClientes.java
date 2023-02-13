package view.clientes;

import model.JTableModelCliente;
import model.clientes.Cliente;
import model.clientes.Contato;
import model.clientes.Endereco;
import model.repositorys.clientes.ClienteEmArquivoRepository;
import view.services.GeraRodape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TelaDeAcoesClientes extends JFrame{
    public String escolha;
    protected JButton btnBotaoSair = new JButton("Sair");
    protected JButton btnVoltar = new JButton("Voltar");
    protected JButton btnLimparCampos = new JButton("Limpar campos");
    protected JButton btnDeletar = new JButton("Deletar");
    protected JButton btnAtualizar = new JButton("Atualizar");
    protected ClienteEmArquivoRepository repositorioDeClientes = new ClienteEmArquivoRepository();
    protected JButton btnCadastro = new JButton("Cadastrar");

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

    protected JPanel pnlForm = new JPanel();

    protected void btnAtualizarDados(ActionEvent ev) {

    }
    protected void btnDeletarCliente(ActionEvent ev) {

    }

    public TelaDeAcoesClientes (String escolha){
        this.escolha = escolha;
        if (escolha.equals("1")){
            incializarTelaCadastroDeClientes();
            this.eventos();

        }else if (escolha.equals("2")){
            incializarTelaDeConsulta();
            this.eventos();
        }

    }

    private void eventos(){
        btnCadastro.addActionListener(this::btnCadastrarCliente);
        btnBotaoSair.addActionListener(this::btnBotaoSair);
        btnLimparCampos.addActionListener(this::btnLimparCampos);
        btnAtualizar.addActionListener(this::btnAtualizarDados);
        btnDeletar.addActionListener(this::btnDeletarCliente);
    }

    private void incializarTelaDeConsulta(){

        List<Cliente> clientes = repositorioDeClientes.listarTodos();
        JTableModelCliente meuTable = new JTableModelCliente(clientes);
        JTable jTable = new JTable(meuTable);
        JScrollPane scrollPane = new JScrollPane(jTable);
        pnlForm = getPnlFormCadastroCliente();
        this.setTitle("Tela de consulta Clientes");
        this.getContentPane().add(scrollPane, BorderLayout.LINE_START);
        this.getContentPane().add(pnlForm, BorderLayout.CENTER);
        this.getContentPane().add(pnlRodape.getPnlRodapeManipularEntidade( btnAtualizar,  btnDeletar,  btnLimparCampos, btnBotaoSair, btnVoltar), BorderLayout.PAGE_END);
        setarValoresCampos(jTable);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void incializarTelaCadastroDeClientes() {

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
    public void setarValoresCampos(JTable table){
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                System.out.println("Clicou");
                if(table.getSelectedRow() !=-1) {
                    String cpf = table.getValueAt(table.getSelectedRow(), 1).toString();
                    Cliente cliente = repositorioDeClientes.consultar(cpf);
                    Endereco endereco = cliente.getEndereco();
                    System.out.println(endereco.getBairro());
                    Contato contato = cliente.getContato();

                    txtNome.setText(cliente.getNome());
                    txtCpf.setText(cliente.getId());
                    txtRua.setText(endereco.getRua());
                    txtBairro.setText(endereco.getBairro());
                    txtNumero.setText(endereco.getNumero());
                    txtEstado.setText(endereco.getEstado());
                    txtNumeroDeTelefone.setText(contato.getTelefone());
                    txtEmail.setText(contato.getEmail());
                }
            }
        });

    }
    protected void btnLimparCampos(ActionEvent ev) {

        txtNome.setText("");
        txtCpf.setText("");
        txtDataDeNascimento.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txtNumero.setText("");
        txtEstado.setText("");
        txtNumeroDeTelefone.setText("");
        txtEmail.setText("");

    }
    protected void btnBotaoSair(ActionEvent ev){
        this.setVisible(false);
        this.dispose();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    protected void btnCadastrarCliente(ActionEvent ev){
        escolha = "1";
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String dataDeNascimento = txtDataDeNascimento.getText();
        Endereco endereco = new Endereco(txtRua.getText(),txtBairro.getText(),txtNumero.getText(),txtEstado.getText());
        Contato contato = new Contato(txtNumeroDeTelefone.getText(),txtEmail.getText());

        Cliente cliente = new Cliente(nome,cpf,endereco,contato);
        repositorioDeClientes.salvar(cliente);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Confirmação", JOptionPane.WARNING_MESSAGE);
        setVisible(false);
        TelaDeAcoesClientes tela = new TelaDeAcoesClientes(escolha);
        this.setLocationRelativeTo(null);
        tela.setVisible(true);

    }
}
