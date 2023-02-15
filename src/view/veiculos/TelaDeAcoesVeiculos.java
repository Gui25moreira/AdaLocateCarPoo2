package view.veiculos;


import model.JTableModelVeiculo;
import model.clientes.Cliente;
import model.repositorys.clientes.ClienteEmArquivoRepository;
import model.repositorys.sistema.AlugueEmArquivoRepository;
import model.repositorys.sistema.DevolucaoEmArquivoRepository;
import model.repositorys.veiculos.VeiculoEmArquivoRepository;
import model.sistema.Aluguel;
import model.sistema.Devolucao;
import model.veiculos.Veiculo;
import view.clientes.TelaDeAcoesClientes;
import view.services.GeraRodape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class TelaDeAcoesVeiculos extends JFrame {

    protected JButton btnBotaoSair = new JButton("Sair");
    protected JButton btnVoltarTelaClientes = new JButton("Voltar");
    protected JButton btnVoltar = new JButton("Voltar");
    protected JButton btnLimparCampos = new JButton("Limpar campos");
    protected JButton btnDeletar = new JButton("Deletar");
    protected JButton btnAlterar = new JButton("Alterar Veículo");
    protected JButton btnPesquisar = new JButton("Pesquisar");
    protected JButton btnDevolver = new JButton("Devolver");
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    protected VeiculoEmArquivoRepository repositorioDeVeiculos = new VeiculoEmArquivoRepository();
    protected AlugueEmArquivoRepository repositorioDeAlugueis = new AlugueEmArquivoRepository();
    protected DevolucaoEmArquivoRepository repositorioDeDevolucoes = new DevolucaoEmArquivoRepository();
    protected ClienteEmArquivoRepository repositorioDeClientes = new ClienteEmArquivoRepository();
    Random gerador = new Random();
    protected JButton btnCadastro = new JButton("Cadastrar");
    protected JButton btnAlugar = new JButton("Alugar");

    protected JTable jTable = new JTable();
    protected GeraRodape pnlRodape = new GeraRodape();
    protected Cliente cliente = new Cliente();
    protected JPanel pnlFormCadastroVeiculo;
    protected JPanel pnlFormAlugarVeicuo;

    protected JPanel pnlForm = new JPanel();
    protected int tamanhoColunasTextField = 20;
    protected String escolha;

    protected JLabel lblModelo;
    protected JTextField txtModelo;


    protected JLabel lblClienteResponsavel;
    protected JTextField txtClienteResponsavel;
    protected JLabel lblMarca;
    protected JTextField txtMarca;

    protected JLabel lblPlaca;
    protected JTextField txtPlaca;

    protected JLabel lblAnoDeFabricacao;
    protected JTextField txtAnoDeFabricacao;

    protected JLabel lblTipoDeVeiculo;

    protected JTextField txtTipoDeVeiculo;

    protected JLabel lblValorDoAlguel;
    protected JTextField txtValorDoAluguel;

    protected JLabel lblCliente;
    protected JTextField txtCliente;

    protected JLabel lblVeiculo;
    protected JTextField txtVeiculo;

    protected JLabel lblDataDoAluguel;
    protected JTextField txtDataDoAluguel;

    protected JLabel lblValorAPagar;
    protected JTextField txtValorAPagar;

    protected JLabel lblDataDeDevolucao;
    protected JTextField txtDataDeDevolucao;

    protected JPanel pnlFormDevolucao;


    public TelaDeAcoesVeiculos(String escolha, Cliente clienteLogado) {
        this.escolha = escolha;

        if (escolha.equals(("0"))) {
            TelaInicialVeiculos tela = new TelaInicialVeiculos();
            tela.setVisible(true);
        } else if (escolha.equals("1")) {
            incializarTelaCadastroDeVeiculo();
            this.eventos();
        } else if (escolha.equals("2")) {
            incializarTelaDeConsulta();
            this.eventos();
        } else if (escolha.equals("3")) {
            cliente = clienteLogado;
            incializarTelaDeConsultaDevolucao();
            this.eventos();
        } else if (escolha.equals("10")) {
            cliente = clienteLogado;
            incializarTelaDeConsultaAluguel();
            this.eventos();
        }
    }

    private void eventos() {
        btnCadastro.addActionListener(this::btnCadastrarVeiculo);
        btnBotaoSair.addActionListener(this::btnBotaoSair);
        btnLimparCampos.addActionListener(this::btnLimparCampos);
        btnAlugar.addActionListener(this::setBtnAlugar);
        btnDevolver.addActionListener(this::setBtnDevolver);
        btnVoltarTelaClientes.addActionListener(this::setBtnVoltarTelaClientes);
        btnVoltar.addActionListener(this::setBtnVoltar);
        btnAlterar.addActionListener(this::setBtnAlterar);
        btnDeletar.addActionListener(this::setBtnDeletar);
        btnPesquisar.addActionListener(this::setBtnPesquisar);
    }


    private void incializarTelaCadastroDeVeiculo() {


        this.setTitle("Cadastro - Veiculo");
        this.getContentPane().setLayout(new BorderLayout());
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.getContentPane().add(getPnlFormCadastroVeiculo(), BorderLayout.CENTER);
        this.getContentPane().add(pnlRodape.getPnlRodapeComum(btnCadastro, btnBotaoSair, btnVoltar, btnLimparCampos), BorderLayout.PAGE_END);
        this.pack();

    }

    private void incializarTelaDeConsulta() {

        List<Veiculo> veiculos = repositorioDeVeiculos.listarTodos();
        JTableModelVeiculo meuTable = new JTableModelVeiculo(veiculos);
        JTable jTable = new JTable(meuTable);
        JScrollPane scrollPane = new JScrollPane(jTable);

        pnlForm = getPnlFormConsultaVeiculo();
        this.setTitle("Tela de consulta Veiculos");
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

    private void incializarTelaDeConsultaAluguel() {
        cliente.limpaListaVeiculos();
        List<Veiculo> veiculos = repositorioDeVeiculos.listarTodos().stream().filter(v -> !v.isAlugado()).collect(Collectors.toList());
        JTableModelVeiculo meuTable = new JTableModelVeiculo(veiculos);
        jTable = new JTable(meuTable);
        JScrollPane scrollPane = new JScrollPane(jTable);
        pnlForm = getPnlFormAlugarVeiculo();
        this.setTitle("Tela de consulta Veiculos");
        if (jTable.getRowCount() == 0) {
            JTextField texto = new JTextField("Não existem veículos disponíveis!");
            this.getContentPane().add(texto, BorderLayout.LINE_START);
            this.getContentPane().add(pnlForm, BorderLayout.CENTER);
            this.getContentPane().add(pnlRodape.getPnlRodapeTelaInicial(btnVoltarTelaClientes, btnBotaoSair), BorderLayout.PAGE_END);
            setarValoresCampos(jTable);
            this.setVisible(true);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        } else {
            this.getContentPane().add(scrollPane, BorderLayout.LINE_START);
            this.getContentPane().add(pnlForm, BorderLayout.CENTER);
            this.getContentPane().add(pnlRodape.getPnlRodapeAlugarVeiculo(btnAlugar, btnPesquisar, btnVoltarTelaClientes, btnBotaoSair), BorderLayout.PAGE_END);
            setarValoresCampos(jTable);
            this.setVisible(true);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    private void incializarTelaDeConsultaDevolucao() {

        List<Veiculo> veiculos = cliente.getVeiculos();

        if (cliente.getVeiculos().size() == 0) {
            JOptionPane.showMessageDialog(null, "O cliente não possui veículos alugados!", "Alerta", JOptionPane.WARNING_MESSAGE);
            escolha = "0";
            this.setVisible(false);
            this.dispose();
            TelaDeAcoesClientes tela = new TelaDeAcoesClientes(escolha);
            tela.setVisible(true);
            tela.setLocationRelativeTo(null);

        } else {

            JTableModelVeiculo meuTable = new JTableModelVeiculo(veiculos);
            jTable = new JTable(meuTable);
            JScrollPane scrollPane = new JScrollPane(jTable);
            this.getContentPane().add(scrollPane, BorderLayout.LINE_START);
            this.getContentPane().add(getPnlFormDevolucao(), BorderLayout.CENTER);
            this.getContentPane().add(pnlRodape.getPnlRodapeDevolverVeiculo(btnDevolver, btnVoltar, btnBotaoSair), BorderLayout.PAGE_END);
            setarValoresCamposDevolucao(jTable);
            this.setVisible(true);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }
    }

    public JPanel getPnlFormCadastroVeiculo() {

        if (pnlFormCadastroVeiculo == null) {

            pnlFormCadastroVeiculo = new JPanel();
            pnlFormCadastroVeiculo.setLayout(new GridLayout(5, 1, 20, 15));

            lblMarca = new JLabel("Marca do veículo");
            txtMarca = new JTextField(tamanhoColunasTextField);

            lblPlaca = new JLabel("Placa Do veículo");
            txtPlaca = new JTextField(tamanhoColunasTextField);

            lblModelo = new JLabel("Modelo do veículo");
            txtModelo = new JTextField(tamanhoColunasTextField);

            lblTipoDeVeiculo = new JLabel("Tipo do veículo -> Pequeno, Medio, SUV.");
            txtTipoDeVeiculo = new JTextField(tamanhoColunasTextField);

            lblAnoDeFabricacao = new JLabel("Ano de fabricação do veículo");
            txtAnoDeFabricacao = new JTextField(tamanhoColunasTextField);

            pnlFormCadastroVeiculo.add(lblMarca);
            pnlFormCadastroVeiculo.add(txtMarca);

            pnlFormCadastroVeiculo.add(lblPlaca);
            pnlFormCadastroVeiculo.add(txtPlaca);

            pnlFormCadastroVeiculo.add(lblModelo);
            pnlFormCadastroVeiculo.add(txtModelo);

            pnlFormCadastroVeiculo.add(lblTipoDeVeiculo);
            pnlFormCadastroVeiculo.add(txtTipoDeVeiculo);

            pnlFormCadastroVeiculo.add(lblAnoDeFabricacao);
            pnlFormCadastroVeiculo.add(txtAnoDeFabricacao);


        }
        return pnlFormCadastroVeiculo;
    }

    public JPanel getPnlFormConsultaVeiculo() {

        if (pnlFormCadastroVeiculo == null) {

            pnlFormCadastroVeiculo = new JPanel();
            pnlFormCadastroVeiculo.setLayout(new GridLayout(5, 1, 20, 15));

            lblMarca = new JLabel("Marca do veículo");
            txtMarca = new JTextField(tamanhoColunasTextField);

            lblPlaca = new JLabel("Placa Do veículo");
            txtPlaca = new JTextField(tamanhoColunasTextField);
            txtPlaca.setEditable(false);

            lblModelo = new JLabel("Modelo do veículo");
            txtModelo = new JTextField(tamanhoColunasTextField);

            lblTipoDeVeiculo = new JLabel("Tipo do veículo -> Pequeno, Medio, SUV.");
            txtTipoDeVeiculo = new JTextField(tamanhoColunasTextField);
            txtTipoDeVeiculo.setEditable(false);

            lblAnoDeFabricacao = new JLabel("Ano de fabricação do veículo");
            txtAnoDeFabricacao = new JTextField(tamanhoColunasTextField);

            pnlFormCadastroVeiculo.add(lblMarca);
            pnlFormCadastroVeiculo.add(txtMarca);

            pnlFormCadastroVeiculo.add(lblPlaca);
            pnlFormCadastroVeiculo.add(txtPlaca);

            pnlFormCadastroVeiculo.add(lblModelo);
            pnlFormCadastroVeiculo.add(txtModelo);

            pnlFormCadastroVeiculo.add(lblTipoDeVeiculo);
            pnlFormCadastroVeiculo.add(txtTipoDeVeiculo);

            pnlFormCadastroVeiculo.add(lblAnoDeFabricacao);
            pnlFormCadastroVeiculo.add(txtAnoDeFabricacao);


        }
        return pnlFormCadastroVeiculo;
    }

    public JPanel getPnlFormAlugarVeiculo() {

        if (pnlFormAlugarVeicuo == null) {

            pnlFormAlugarVeicuo = new JPanel();
            pnlFormAlugarVeicuo.setLayout(new GridLayout(6, 1, 20, 15));

            lblMarca = new JLabel("Marca do veículo:");
            txtMarca = new JTextField(tamanhoColunasTextField);
            txtMarca.setEditable(false);

            lblPlaca = new JLabel("Placa Do veículo:");
            txtPlaca = new JTextField(tamanhoColunasTextField);
            txtPlaca.setEditable(false);

            lblModelo = new JLabel("Modelo do veículo:");
            txtModelo = new JTextField(tamanhoColunasTextField);
            txtModelo.setEditable(false);

            lblTipoDeVeiculo = new JLabel("Tipo do veículo -> Pequeno, Medio, SUV.");
            txtTipoDeVeiculo = new JTextField(tamanhoColunasTextField);
            txtTipoDeVeiculo.setEditable(false);

            lblAnoDeFabricacao = new JLabel("Ano de fabricação do veículo:");
            txtAnoDeFabricacao = new JTextField(tamanhoColunasTextField);
            txtAnoDeFabricacao.setEditable(false);

            lblValorDoAlguel = new JLabel("Valor diária:");
            txtValorDoAluguel = new JTextField(tamanhoColunasTextField);
            txtValorDoAluguel.setEditable(false);

            pnlFormAlugarVeicuo.add(lblMarca);
            pnlFormAlugarVeicuo.add(txtMarca);

            pnlFormAlugarVeicuo.add(lblPlaca);
            pnlFormAlugarVeicuo.add(txtPlaca);

            pnlFormAlugarVeicuo.add(lblModelo);
            pnlFormAlugarVeicuo.add(txtModelo);

            pnlFormAlugarVeicuo.add(lblTipoDeVeiculo);
            pnlFormAlugarVeicuo.add(txtTipoDeVeiculo);

            pnlFormAlugarVeicuo.add(lblAnoDeFabricacao);
            pnlFormAlugarVeicuo.add(txtAnoDeFabricacao);

            pnlFormAlugarVeicuo.add(lblValorDoAlguel);
            pnlFormAlugarVeicuo.add(txtValorDoAluguel);

        }
        return pnlFormAlugarVeicuo;
    }

    public JPanel getPnlFormDevolucao() {

        if (pnlFormDevolucao == null) {

            pnlFormDevolucao = new JPanel();
            pnlFormDevolucao.setLayout(new GridLayout(5, 1, 20, 15));

            lblClienteResponsavel = new JLabel("Cliente responsável:");
            txtClienteResponsavel = new JTextField(tamanhoColunasTextField);

            lblVeiculo = new JLabel("Veículo alugado:");
            txtVeiculo = new JTextField(tamanhoColunasTextField);

            lblDataDoAluguel = new JLabel("Data do aluguel:");
            txtDataDoAluguel = new JTextField(tamanhoColunasTextField);

            lblPlaca = new JLabel("Placa do veículo");
            txtPlaca = new JTextField(tamanhoColunasTextField);

            pnlFormDevolucao.add(lblClienteResponsavel);
            pnlFormDevolucao.add(txtClienteResponsavel);

            pnlFormDevolucao.add(lblVeiculo);
            pnlFormDevolucao.add(txtVeiculo);

            pnlFormDevolucao.add(lblDataDoAluguel);
            pnlFormDevolucao.add(txtDataDoAluguel);

            pnlFormDevolucao.add(lblPlaca);
            pnlFormDevolucao.add(txtPlaca);


        }
        return pnlFormDevolucao;
    }

    protected void btnCadastrarVeiculo(ActionEvent ev) {
        escolha = "1";
        String marca = txtMarca.getText();
        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        String anoDeFabricacao = txtAnoDeFabricacao.getText();
        String tipoDeVeiculo = txtTipoDeVeiculo.getText();

        Veiculo veiculo = new Veiculo(modelo, placa, marca, anoDeFabricacao, tipoDeVeiculo);
        repositorioDeVeiculos.salvar(veiculo);

        JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso", "Confirmação", JOptionPane.WARNING_MESSAGE);
        setVisible(false);
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }

    protected void btnLimparCampos(ActionEvent ev) {

        txtMarca.setText("");
        txtPlaca.setText("");
        txtModelo.setText("");
        txtAnoDeFabricacao.setText("");
        txtTipoDeVeiculo.setText("");

    }

    protected void btnBotaoSair(ActionEvent ev) {
        this.setVisible(false);
        this.dispose();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    protected void setBtnVoltar(ActionEvent ev) {
        escolha = "0";
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
        tela.setLocationRelativeTo(null);
    }

    protected void setBtnVoltarTelaClientes(ActionEvent ev) {
        escolha = "0";
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesClientes tela = new TelaDeAcoesClientes(escolha);
        tela.setLocationRelativeTo(null);
    }

    public void setBtnAlugar(ActionEvent ev) {

        escolha = "10";
        JOptionPane.showMessageDialog(null, "Veiculo Alugado com sucesso", "Confirmação", JOptionPane.WARNING_MESSAGE);
        String placa = txtPlaca.getText();
        Veiculo veiculo = repositorioDeVeiculos.consultar(placa);
        veiculo.setAlugado(true);
        veiculo.setCliente(cliente);
        cliente.setVeiculos(veiculo);
        repositorioDeClientes.atualizar(cliente);
        Aluguel aluguel = new Aluguel(veiculo, cliente);
        veiculo.setAluguel(aluguel);
        repositorioDeVeiculos.atualizar(veiculo);
        repositorioDeAlugueis.salvar(aluguel);
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }

    protected void setBtnDevolver(ActionEvent ev) {
        escolha = "3";
        Veiculo veiculo = repositorioDeVeiculos.consultar(txtPlaca.getText());
        String idAluguel = txtDataDoAluguel.getText();
        Aluguel aluguel = (Aluguel) repositorioDeAlugueis.consultar(idAluguel);
        Devolucao devolucao = new Devolucao(veiculo, cliente, aluguel);
        veiculo.setAlugado(false);
        veiculo.setCliente(null);
        cliente.removeVeiculo(veiculo);
        repositorioDeClientes.atualizar(cliente);
        repositorioDeVeiculos.atualizar(veiculo);
        String valorAPagar = devolucao.getValorAPagar().toString();
        JOptionPane.showMessageDialog(null," O valor á pagar é-> " +valorAPagar);
        JOptionPane.showMessageDialog(null, " O valor a pagar foi Veiculo Devolvido com sucesso!", "Confirmação", JOptionPane.WARNING_MESSAGE);
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }


    public void setarValoresCampos(JTable table) {

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (table.getSelectedRow() != -1) {
                    String placa = table.getValueAt(table.getSelectedRow(), 1).toString();
                    Veiculo veiculo = repositorioDeVeiculos.consultar(placa);
                    txtModelo.setText(veiculo.getModelo());
                    txtPlaca.setText(veiculo.getId());
                    txtMarca.setText(veiculo.getMarca());
                    txtTipoDeVeiculo.setText(veiculo.getTipoDoVeiculo());
                    txtAnoDeFabricacao.setText(veiculo.getAnoDeFabricacao());
                    txtValorDoAluguel.setText(String.valueOf(veiculo.getValorAluguel()));

                }
            }
        });

    }

    public void setarValoresCamposDevolucao(JTable table) {

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (table.getSelectedRow() != -1) {
                    String placa = table.getValueAt(table.getSelectedRow(), 1).toString();
                    Veiculo veiculo = repositorioDeVeiculos.consultar(placa);
                    txtVeiculo.setText(veiculo.getModelo());
                    txtPlaca.setText(veiculo.getId());
                    txtClienteResponsavel.setText(veiculo.getCliente().getNome());
                    txtDataDoAluguel.setText(veiculo.getAluguel().getData().toString());
                    txtDataDeDevolucao.setText(LocalDateTime.now().toString());
                }
            }
        });

    }

    protected void setBtnAlterar(ActionEvent ev) {
        escolha = "2";
        String placa = txtPlaca.getText();
        Veiculo veiculo = repositorioDeVeiculos.consultar(placa);
        veiculo.setModelo(txtModelo.getText());
        veiculo.setAnoDeFabricacao(txtAnoDeFabricacao.getText());
        veiculo.setMarca(txtMarca.getText());
        repositorioDeVeiculos.atualizar(veiculo);
        JOptionPane.showMessageDialog(null, "Veiculo alterado com sucesso!", "Confirmação", JOptionPane.WARNING_MESSAGE);
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);
    }

    protected void setBtnDeletar(ActionEvent ev) {
        escolha = "2";
        String placa = txtPlaca.getText();
        repositorioDeVeiculos.deletar(placa);
        JOptionPane.showMessageDialog(null, "Veiculo deletado com sucesso!", "Confirmação", JOptionPane.WARNING_MESSAGE);
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
        tela.setVisible(true);
        tela.setLocationRelativeTo(null);

    }

    protected void setBtnPesquisar(ActionEvent ev) {
        escolha = "10";
        System.out.println(jTable.getRowCount());
        this.setVisible(false);
        this.dispose();
        String pesquisarNome = JOptionPane.showInputDialog("Digite um nome para pesquisar!");
        this.setVisible(false);
        this.dispose();

        if (pesquisarNome.length() > 0) {
            List<Veiculo> veiculos = repositorioDeVeiculos.listarTodos().stream().filter(v -> v.getModelo().equals(pesquisarNome)).collect(Collectors.toList());
            JTableModelVeiculo meuTable = new JTableModelVeiculo(veiculos);
            jTable = new JTable(meuTable);
            JScrollPane scrollPane = new JScrollPane(jTable);
            this.setVisible(false);

            pnlForm = getPnlFormAlugarVeiculo();
            this.setTitle("Tela de consulta Veiculos");
            this.setVisible(false);

            if (jTable.getRowCount() == 0) {
                JTextField texto = new JTextField("Não existem veículos com esse nome");
                this.getContentPane().add(texto, BorderLayout.LINE_START);
                this.getContentPane().add(pnlForm, BorderLayout.CENTER);
                this.getContentPane().add(pnlRodape.getPnlRodapeAlugarVeiculo(btnAlugar, btnPesquisar, btnVoltarTelaClientes, btnBotaoSair), BorderLayout.PAGE_END);
                setarValoresCampos(jTable);
                this.setVisible(true);
                this.setResizable(false);
                this.setLocationRelativeTo(null);
                this.pack();
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            } else {

                this.getContentPane().add(scrollPane, BorderLayout.LINE_START);
                this.getContentPane().add(pnlForm, BorderLayout.CENTER);
                this.getContentPane().add(pnlRodape.getPnlRodapeAlugarVeiculo(btnAlugar, btnPesquisar, btnVoltarTelaClientes, btnBotaoSair), BorderLayout.PAGE_END);
                setarValoresCampos(jTable);
                this.setVisible(true);
                this.setResizable(false);
                this.setLocationRelativeTo(null);
                this.pack();
                this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            }
        } else {
            TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha, cliente);
            tela.setVisible(true);
            tela.setLocationRelativeTo(null);
        }
    }
}

