package view.veiculos;

import model.JTableModelCliente;
import model.JTableModelVeiculo;
import model.clientes.Cliente;
import model.clientes.Contato;
import model.clientes.Endereco;
import model.repositorys.veiculos.VeiculoEmArquivoRepository;
import model.veiculos.Veiculo;
import view.services.GeraRodape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TelaDeAcoesVeiculos extends JFrame {

        protected JButton btnBotaoSair = new JButton("Sair");
        protected JButton btnVoltar = new JButton("Voltar");
        protected JButton btnLimparCampos = new JButton("Limpar campos");
        protected JButton btnDeletar = new JButton("Deletar");
        protected JButton btnAtualizar = new JButton("Atualizar");
        protected VeiculoEmArquivoRepository repositorioDeVeiculos = new VeiculoEmArquivoRepository();
        protected JButton btnCadastro = new JButton("Cadastrar");

        protected GeraRodape pnlRodape = new GeraRodape();
        protected JPanel pnlFormCadastroVeiculo;

        protected JPanel pnlForm = new JPanel();
        protected int tamanhoColunasTextField = 20;
        protected String escolha;
        protected JLabel lblModelo;
        JTextField txtModelo;


        protected JLabel lblMarca;
        protected JTextField txtMarca;

        protected JLabel lblPlaca;
        protected JTextField txtPlaca;

        protected JLabel lblAnoDeFabricacao;
        protected JTextField txtAnoDeFabricacao;

        protected JLabel lblTipoDeVeiculo;
        protected JTextField txtTipoDeVeiculo;

        public TelaDeAcoesVeiculos(String escolha){
            this.escolha = escolha;
            if (escolha.equals("1")) {
                incializarTelaCadastroDeVeiculo();
                this.eventos();
            }else if (escolha.equals("2")){
                incializarTelaDeConsulta();
                this.eventos();
            }
        }
        private void eventos(){
            btnCadastro.addActionListener(this::btnCadastrarVeiculo);
            btnBotaoSair.addActionListener(this::btnBotaoSair);
            btnLimparCampos.addActionListener(this::btnLimparCampos);
    //        btnAtualizar.addActionListener(this::btnAtualizarDados);
    //        btnDeletar.addActionListener(this::btnDeletarCliente);
    }

    protected void atualizarVeiculo(){

    }
    protected void deletarVeiculo(){

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
        this.getContentPane().add(pnlRodape.getPnlRodapeComum(btnCadastro, btnBotaoSair, btnLimparCampos), BorderLayout.PAGE_END);
        this.pack();
    }
    private void incializarTelaDeConsulta(){

        List<Veiculo> veiculos = repositorioDeVeiculos.listarTodos();
        JTableModelVeiculo meuTable = new JTableModelVeiculo(veiculos);
        JTable jTable = new JTable(meuTable);
        JScrollPane scrollPane = new JScrollPane(jTable);
        pnlForm = getPnlFormCadastroVeiculo();
        this.setTitle("Tela de consulta Veiculos");
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
        public JPanel getPnlFormCadastroVeiculo() {

        if (pnlFormCadastroVeiculo == null) {

            pnlFormCadastroVeiculo = new JPanel();
            pnlFormCadastroVeiculo.setLayout(new GridLayout(5, 1, 20, 15));

            lblMarca = new JLabel("Marca do veículo");
            txtMarca = new JTextField(tamanhoColunasTextField);

            lblPlaca = new JLabel("Placa Do veículo");
            txtPlaca = new JTextField(tamanhoColunasTextField);

            lblModelo = new JLabel("Modelo do veículo");
            txtModelo= new JTextField(tamanhoColunasTextField);

            lblTipoDeVeiculo = new JLabel("Tipo do veículo");
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
    protected void btnCadastrarVeiculo(ActionEvent ev){
        escolha = "1";
        String marca = txtMarca.getText();
        String placa = txtPlaca.getText();
        String modelo = txtModelo.getText();
        String anoDeFabricacao = txtAnoDeFabricacao.getText();
        String tipoDeVeiculo = txtTipoDeVeiculo.getText();

        Veiculo veiculo = new Veiculo(modelo,placa,marca,anoDeFabricacao,tipoDeVeiculo);
        repositorioDeVeiculos.salvar(veiculo);

        JOptionPane.showMessageDialog(null, "Veiculo cadastrado com sucesso", "Confirmação", JOptionPane.WARNING_MESSAGE);
        setVisible(false);
        TelaDeAcoesVeiculos tela = new TelaDeAcoesVeiculos(escolha);
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
    protected void btnBotaoSair(ActionEvent ev){
        this.setVisible(false);
        this.dispose();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void setarValoresCampos(JTable table){

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e){
                System.out.println("Clicou");
                if(table.getSelectedRow() !=-1) {
                    String cpf = table.getValueAt(table.getSelectedRow(), 1).toString();
                    Veiculo veiculo = repositorioDeVeiculos.consultar(cpf);
                    txtModelo.setText(veiculo.getModelo());
                    txtPlaca.setText(veiculo.getId());
                    txtMarca.setText(veiculo.getMarca());
                    txtTipoDeVeiculo.setText(veiculo.getTipoDoVeiculo());
                    txtAnoDeFabricacao.setText(veiculo.getAnoDeFabricacao());

                }
            }
        });

    }
}
