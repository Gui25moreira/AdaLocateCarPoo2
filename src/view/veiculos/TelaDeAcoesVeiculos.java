package view.veiculos;

import model.JTableModelCliente;
import model.JTableModelVeiculo;
import model.clientes.Cliente;
import model.clientes.Contato;
import model.clientes.Endereco;
import model.repositorys.sistema.AlugueEmArquivoRepository;
import model.repositorys.veiculos.VeiculoEmArquivoRepository;
import model.sistema.Aluguel;
import model.veiculos.Veiculo;
import view.clientes.TelaDeAcoesClientes;
import view.services.GeraRodape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    protected VeiculoEmArquivoRepository repositorioDeVeiculos = new VeiculoEmArquivoRepository();
    protected AlugueEmArquivoRepository repositorioDeAlugueis = new AlugueEmArquivoRepository();
    Random gerador = new Random();
    protected JButton btnCadastro = new JButton("Cadastrar");
    protected JButton btnAlugar = new JButton("Alugar");

    protected GeraRodape pnlRodape = new GeraRodape();
    protected Cliente cliente = new Cliente();
    protected JPanel pnlFormCadastroVeiculo;
    protected JPanel pnlFormAlugarVeicuo;

    protected JPanel pnlForm = new JPanel();
    protected int tamanhoColunasTextField = 20;
    protected String escolha;

    protected JLabel lblModelo;
    protected JTextField txtModelo;


    JLabel lblNomeCliente = new JLabel("Cliente responsável!");
    JTextField txtNomeCliente = new JTextField(tamanhoColunasTextField);
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




    public TelaDeAcoesVeiculos(String escolha,Cliente clienteLogado) {
        this.escolha = escolha;

        if(escolha.equals(("0"))){
            TelaInicialVeiculos tela = new TelaInicialVeiculos();
            tela.setVisible(true);
    }else if(escolha.equals("1")) {
            incializarTelaCadastroDeVeiculo();
            this.eventos();
        } else if (escolha.equals("2")) {
            incializarTelaDeConsulta();
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
        btnVoltarTelaClientes.addActionListener(this::setBtnVoltarTelaClientes);
        btnVoltar.addActionListener(this::setBtnVoltar);
        btnAlterar.addActionListener(this::setBtnAlterar);
        btnDeletar.addActionListener(this::setBtnDeletar);
        btnPesquisar.addActionListener(this::setBtnPesquisar);
    }


    protected void listarAlugueisEDevolucoes() {

    }

    private void incializarTelaCadastroDeVeiculo() {

        this.setLocationRelativeTo(null);
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

        List<Veiculo> veiculos = repositorioDeVeiculos.listarTodos().stream().filter(v -> !v.isAlugado()).collect(Collectors.toList());
        JTableModelVeiculo meuTable = new JTableModelVeiculo(veiculos);
        JTable jTable = new JTable(meuTable);
        JScrollPane scrollPane = new JScrollPane(jTable);
        pnlForm = getPnlFormAlugarVeiculo();
        this.setTitle("Tela de consulta Veiculos");
        if(jTable.getRowCount() == 0){
            JTextField texto = new JTextField("Não existem veículos disponíveis!");
            this.getContentPane().add(texto, BorderLayout.LINE_START);
            this.getContentPane().add(pnlForm, BorderLayout.CENTER);
            this.getContentPane().add(pnlRodape.getPnlRodapeAlugarVeiculo(btnAlugar,btnPesquisar, btnVoltarTelaClientes, btnBotaoSair), BorderLayout.PAGE_END);
            setarValoresCampos(jTable);
            this.setVisible(true);
            this.setResizable(false);
            this.setLocationRelativeTo(null);
            this.pack();
            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }else {
            this.getContentPane().add(scrollPane, BorderLayout.LINE_START);
            this.getContentPane().add(pnlForm, BorderLayout.CENTER);
            this.getContentPane().add(pnlRodape.getPnlRodapeAlugarVeiculo(btnAlugar,btnPesquisar, btnVoltarTelaClientes, btnBotaoSair), BorderLayout.PAGE_END);
            setarValoresCampos(jTable);
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

            lblMarca = new JLabel("Marca do veículo");
            txtMarca = new JTextField(tamanhoColunasTextField);
            txtMarca.setEditable(false);

            lblPlaca = new JLabel("Placa Do veículo");
            txtPlaca = new JTextField(tamanhoColunasTextField);
            txtPlaca.setEditable(false);

            lblModelo = new JLabel("Modelo do veículo");
            txtModelo = new JTextField(tamanhoColunasTextField);
            txtModelo.setEditable(false);

            lblTipoDeVeiculo = new JLabel("Tipo do veículo -> Pequeno, Medio, SUV.");
            txtTipoDeVeiculo = new JTextField(tamanhoColunasTextField);
            txtTipoDeVeiculo.setEditable(false);

            lblAnoDeFabricacao = new JLabel("Ano de fabricação do veículo");
            txtAnoDeFabricacao = new JTextField(tamanhoColunasTextField);
            txtAnoDeFabricacao.setEditable(false);

            lblValorDoAlguel = new JLabel("Valor do Aluguel");
            txtValorDoAluguel = new JTextField(tamanhoColunasTextField);
            txtValorDoAluguel .setEditable(false);

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
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha,cliente);
        this.setLocationRelativeTo(null);
        tela.setVisible(true);
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
    protected void setBtnVoltar(ActionEvent ev){
        escolha = "0";
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha,cliente);
    }
    protected void setBtnVoltarTelaClientes(ActionEvent ev){
        escolha = "0";
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesClientes tela = new TelaDeAcoesClientes(escolha);
    }

    public void setBtnAlugar(ActionEvent ev) {

        escolha = "10";
        System.out.println("Alugou");
        String placa = txtPlaca.getText();
        Veiculo veiculo = repositorioDeVeiculos.consultar(placa);
        veiculo.setAlugado(true);
        veiculo.setCliente(cliente);
        repositorioDeVeiculos.atualizar(veiculo);
        Aluguel aluguel = new Aluguel(veiculo,cliente);
        repositorioDeAlugueis.salvar(aluguel);
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha,cliente);
        tela.setVisible(true);

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
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha,cliente);
        tela.setVisible(true);
    }
    protected void setBtnDeletar(ActionEvent ev) {
        escolha = "2";
        String placa = txtPlaca.getText();
        repositorioDeVeiculos.deletar(placa);
        JOptionPane.showMessageDialog(null, "Veiculo deletado com sucesso!", "Confirmação", JOptionPane.WARNING_MESSAGE);
        this.setVisible(false);
        this.dispose();
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha,cliente);
        tela.setVisible(true);

    }
    protected void setBtnPesquisar(ActionEvent ev){
        List<Veiculo> veiculos = repositorioDeVeiculos.listarTodos();
        JTableModelVeiculo meuTable = new JTableModelVeiculo(veiculos);
        JTable jTable = new JTable(meuTable);
        String pesquisarNome = JOptionPane.showInputDialog("Digite um nome para pesquisar!");
        if(pesquisarNome.length()>0){
            for(int i=0;i<jTable.getRowCount();i++){
                if(pesquisarNome.equals(jTable.getValueAt(i,0))){
                    String placa = jTable.getValueAt(jTable.getSelectedRow(), 1).toString();
                    Veiculo veiculo = repositorioDeVeiculos.consultar(placa);
                    txtModelo.setText(veiculo.getModelo());
                    txtPlaca.setText(veiculo.getId());
                    txtMarca.setText(veiculo.getMarca());
                    txtTipoDeVeiculo.setText(veiculo.getTipoDoVeiculo());
                    txtAnoDeFabricacao.setText(veiculo.getAnoDeFabricacao());
                    txtValorDoAluguel.setText(String.valueOf(veiculo.getValorAluguel()));
                }
            }
        }
    }
}
