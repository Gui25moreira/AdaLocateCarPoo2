package view.clientes;

import model.JTableModelCliente;

import model.clientes.*;
import model.repositorys.clientes.ClienteEmArquivoRepository;

import view.services.GeraRodape;
import view.veiculos.TelaDeAcoesVeiculos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class TelaDeAcoesClientes extends JFrame {
    public String escolha;
    protected GeraRodape pnlRodape = new GeraRodape();
    protected ClienteEmArquivoRepository repositorioDeClientes = new ClienteEmArquivoRepository();

    //Botões
    protected JButton btnBotaoSair = new JButton("Sair");
    protected JButton btnVoltar = new JButton("Voltar");
    protected JButton btnLimparCampos = new JButton("Limpar campos");
    protected JButton btnDeletar = new JButton("Deletar");
    protected JButton btnAlterar = new JButton("Alterar");

    protected JButton btnCadastro = new JButton("Cadastrar");
    protected JButton btnAlugar = new JButton("Alugar");
    protected JButton btnDevolver = new JButton("Devolver");
    protected JButton btnLoginAluguel = new JButton("Login");
    protected JButton btnLoginDevolucao = new JButton("Login");

    //Campos de texto
    protected int tamanhoColunasTextField = 20;
    protected JLabel lblNome;
    protected JTextField txtNome;

    protected JLabel lblCpf;
    protected JTextField txtCpf;
    protected JLabel lblSenha;
    protected JTextField txtSenha;
    protected JCheckBox tipoDeCliente;

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

    //Paineis
    protected JPanel pnlFormLogin;
    protected JPanel pnlFormCadastroCliente;

    protected JPanel pnlForm = new JPanel();

    public TelaDeAcoesClientes(String escolha) {
        this.escolha = escolha;
        if (escolha.equals("0")) {
            TelaInicialClientes tela = new TelaInicialClientes();
            tela.setVisible(true);
        } else if (escolha.equals("1")) {
            incializarTelaCadastroDeClientes();
            this.eventos();

        } else if (escolha.equals("2")) {
            incializarTelaDeConsulta();
            this.eventos();
        } else if (escolha.equals("3")) {
            inicializarTelaDeAluguel();
            this.eventos();
        } else if (escolha.equals("4")) {
            inicializarTelaDeLogin();
            this.eventos();
        }
    }


    private void eventos() {
        btnCadastro.addActionListener(this::btnCadastrarCliente);
        btnAlugar.addActionListener(this::btnAlugar);
        btnLoginAluguel.addActionListener(this::btnLoginAluguel);
        btnLoginDevolucao.addActionListener(this::btnLoginDevolucao);
        btnBotaoSair.addActionListener(this::btnBotaoSair);
        btnVoltar.addActionListener(this::btnVoltar);
        btnLimparCampos.addActionListener(this::btnLimparCampos);
        btnAlterar.addActionListener(this::setBtnAlterar);
        btnDeletar.addActionListener(this::setBtnDeletar);
    }

    private void incializarTelaDeConsulta() {

        List<Cliente> clientes = repositorioDeClientes.listarTodos();
        JTableModelCliente meuTable = new JTableModelCliente(clientes);
        JTable jTable = new JTable(meuTable);
        JScrollPane scrollPane = new JScrollPane(jTable);
        pnlForm = getPnlFormConsultaCliente();
        this.setTitle("Tela de consulta Clientes");
        this.getContentPane().add(scrollPane, BorderLayout.LINE_START);
        this.getContentPane().add(pnlForm, BorderLayout.CENTER);
        this.getContentPane().add(pnlRodape.getPnlRodapeManipularEntidade(btnAlterar, btnDeletar, btnLimparCampos, btnBotaoSair, btnVoltar), BorderLayout.PAGE_END);
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
        this.getContentPane().add(pnlRodape.getPnlRodapeComum(btnCadastro, btnBotaoSair, btnVoltar, btnLimparCampos), BorderLayout.PAGE_END);
        this.pack();
    }

    private void inicializarTelaDeAluguel() {


        this.setTitle("Aluguel Veiculo");
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(getPnlFormLogin(), BorderLayout.CENTER);
        this.getContentPane().add(pnlRodape.getPnlRodapeLogin(btnLoginAluguel, btnVoltar), BorderLayout.PAGE_END);
        this.pack();


    }

    private void inicializarTelaDeLogin() {

        this.setTitle("Devolução Veiculo");
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(getPnlFormLogin(), BorderLayout.CENTER);
        this.getContentPane().add(pnlRodape.getPnlRodapeLogin(btnLoginDevolucao, btnVoltar), BorderLayout.PAGE_END);
        this.pack();

    }

    private JPanel getPnlFormLogin() {
        if (pnlFormLogin == null) {

            pnlFormLogin = new JPanel();
            pnlFormLogin.setLayout(new GridLayout(2, 1, 20, 15));

            lblCpf = new JLabel("Cpf - Cnpj");
            txtCpf = new JTextField(tamanhoColunasTextField);

            lblSenha = new JLabel("Senha");
            txtSenha = new JTextField(tamanhoColunasTextField);

            pnlFormLogin.add(lblCpf);
            pnlFormLogin.add(txtCpf);
            pnlFormLogin.add(lblSenha);
            pnlFormLogin.add(txtSenha);

        }
        return pnlFormLogin;

    }


    public JPanel getPnlFormCadastroCliente() {

        if (pnlFormCadastroCliente == null) {

            pnlFormCadastroCliente = new JPanel();
            pnlFormCadastroCliente.setLayout(new GridLayout(11, 1, 20, 15));

            lblNome = new JLabel("Nome");
            txtNome = new JTextField(tamanhoColunasTextField);

            lblCpf = new JLabel("Cpf - Cnpj");
            txtCpf = new JTextField(tamanhoColunasTextField);

            lblSenha = new JLabel("Senha");
            txtSenha = new JTextField(tamanhoColunasTextField);

            lblDataDeNascimento = new JLabel("Data de nascimento");
            txtDataDeNascimento = new JTextField(tamanhoColunasTextField);

            tipoDeCliente = new JCheckBox("Cliente Jurídico");

            CheckBoxHandler tratador = new CheckBoxHandler();
            tipoDeCliente.addItemListener(tratador);

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

            pnlFormCadastroCliente.add(tipoDeCliente);
            pnlFormCadastroCliente.add(new JLabel(""));

            pnlFormCadastroCliente.add(lblNome);
            pnlFormCadastroCliente.add(txtNome);

            pnlFormCadastroCliente.add(lblCpf);
            pnlFormCadastroCliente.add(txtCpf);

            pnlFormCadastroCliente.add(lblSenha);
            pnlFormCadastroCliente.add(txtSenha);

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

    public JPanel getPnlFormConsultaCliente() {

        if (pnlFormCadastroCliente == null) {

            pnlFormCadastroCliente = new JPanel();
            pnlFormCadastroCliente.setLayout(new GridLayout(11, 1, 20, 15));

            lblNome = new JLabel("Nome");
            txtNome = new JTextField(tamanhoColunasTextField);

            lblCpf = new JLabel("Cpf - Cnpj");
            txtCpf = new JTextField(tamanhoColunasTextField);
            txtCpf.setEditable(false);

            lblSenha = new JLabel("Senha");
            txtSenha = new JTextField(tamanhoColunasTextField);

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

            tipoDeCliente = new JCheckBox("Cliente Jurídico");

            pnlFormCadastroCliente.add(tipoDeCliente);
            pnlFormCadastroCliente.add(new JLabel(""));

            pnlFormCadastroCliente.add(lblNome);
            pnlFormCadastroCliente.add(txtNome);

            pnlFormCadastroCliente.add(lblCpf);
            pnlFormCadastroCliente.add(txtCpf);

            pnlFormCadastroCliente.add(lblSenha);
            pnlFormCadastroCliente.add(txtSenha);

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

    public void setarValoresCampos(JTable table) {
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (table.getSelectedRow() != -1) {
                    String cpf = table.getValueAt(table.getSelectedRow(), 1).toString();
                    Cliente cliente = repositorioDeClientes.consultar(cpf);
                    Endereco endereco = cliente.getEndereco();
                    System.out.println(endereco.getBairro());
                    Contato contato = cliente.getContato();

                    txtNome.setText(cliente.getNome());
                    txtCpf.setText(cliente.getId());
                    txtSenha.setText(cliente.getSenha());
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

        tipoDeCliente.setVisible(false);
        txtNome.setText("");
        txtCpf.setText("");
        txtSenha.setText("");
        txtDataDeNascimento.setText("");
        txtRua.setText("");
        txtBairro.setText("");
        txtNumero.setText("");
        txtEstado.setText("");
        txtNumeroDeTelefone.setText("");
        txtEmail.setText("");

    }

    protected void btnBotaoSair(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    protected void btnCadastrarCliente(ActionEvent ev) {
        escolha = "1";
        String cpf = txtCpf.getText();
        String nome = txtNome.getText();
        String senha = txtSenha.getText();
        String dataDeNascimento = txtDataDeNascimento.getText();
        Endereco endereco = new Endereco(txtRua.getText(), txtBairro.getText(), txtNumero.getText(), txtEstado.getText());
        Contato contato = new Contato(txtNumeroDeTelefone.getText(), txtEmail.getText());

        if(txtCpf.getText().length() != 0){
                    if (tipoDeCliente.isSelected()) {
                        ClienteJuridico cliente = new ClienteJuridico(nome, cpf, senha, endereco, contato);
                        repositorioDeClientes.salvar(cliente);
                    } else {
                        ClienteFisico cliente = new ClienteFisico(nome, cpf, dataDeNascimento, senha, endereco, contato);
                        repositorioDeClientes.salvar(cliente);
                    }
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Confirmação", JOptionPane.WARNING_MESSAGE);
            } else{
            JOptionPane.showMessageDialog(null, "Id precisa ser preenchido!", "Confirmação", JOptionPane.WARNING_MESSAGE);
        }

        setVisible(false);
        TelaDeAcoesClientes tela = new TelaDeAcoesClientes(escolha);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }

    protected void btnVoltar(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();
        TelaInicialClientes tela = new TelaInicialClientes();
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }

    protected void btnAlugar(ActionEvent ev) {
        escolha = "3";
        this.setVisible(false);
        this.dispose();
    }

    protected boolean verificaCliente(String cpf, String senha) {
        String cpfTeste = repositorioDeClientes.consultar(cpf).getId();
        if (cpf.equals(cpfTeste)) {
            Cliente cliente = repositorioDeClientes.consultar(cpf);
            if (cliente.getSenha().equals(senha)) {
                JOptionPane.showMessageDialog(null, "Login Realizado com sucesso.", "Confirmação", JOptionPane.WARNING_MESSAGE);
                return true;
            }
        }
        return false;
    }

    protected void btnLoginAluguel(ActionEvent ev) {

        String cpf = txtCpf.getText();
        String senha = txtSenha.getText();
        Cliente cliente = repositorioDeClientes.consultar(cpf);
        if (verificaCliente(cpf, senha)) {
            escolha = "10";
            this.setVisible(false);
            this.dispose();
            TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
            tela.setVisible(true);
            tela.setLocationRelativeTo(null);
        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Alerta", JOptionPane.WARNING_MESSAGE);

        }

    }

    protected void btnLoginDevolucao(ActionEvent ev) {

        String cpf = txtCpf.getText();
        String senha = txtSenha.getText();
        Cliente cliente = repositorioDeClientes.consultar(cpf);
        if (verificaCliente(cpf, senha)) {
            escolha = "3";
            this.setVisible(false);
            this.dispose();
            TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
            tela.setVisible(true);
            tela.setLocationRelativeTo(null);

        } else {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado!", "Alerta", JOptionPane.WARNING_MESSAGE);
        }

    }

    protected void setBtnAlterar(ActionEvent ev) {
        escolha = "2";
        String cpf = txtCpf.getText();
        Cliente cliente = repositorioDeClientes.consultar(cpf);
        cliente.setNome(txtNome.getText());
        Contato contato = cliente.getContato();
        contato.setEmail(txtEmail.getText());
        contato.setTelefone(txtNumeroDeTelefone.getText());
        cliente.setContato(contato);
        Endereco endereco = cliente.getEndereco();
        endereco.setRua(txtRua.getText());
        endereco.setBairro(txtBairro.getText());
        endereco.setEstado(txtEstado.getText());
        endereco.setNumero(txtNumero.getText());

        cliente.setEndereco(endereco);

        repositorioDeClientes.atualizar(cliente);
        JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso!", "Confirmação", JOptionPane.WARNING_MESSAGE);
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesClientes tela = new TelaDeAcoesClientes(escolha);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }

    protected void setBtnDeletar(ActionEvent ev) {
        escolha = "2";
        String cpf = txtCpf.getText();
        repositorioDeClientes.deletar(cpf);
        JOptionPane.showMessageDialog(null, "Cliente deletado com sucesso!", "Confirmação", JOptionPane.WARNING_MESSAGE);
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesClientes tela = new TelaDeAcoesClientes(escolha);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }

    private class CheckBoxHandler implements ItemListener {
        public void itemStateChanged(ItemEvent e) {
            if (tipoDeCliente.isSelected()) {
                txtDataDeNascimento.setEditable(false);
            } else {
                txtDataDeNascimento.setEditable(true);
            }
        }
    }

}
