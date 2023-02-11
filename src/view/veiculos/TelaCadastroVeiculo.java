//package view.veiculos;
//
//import model.repositorys.veiculos.VeiculoEmArquivoRepository;
//import view.services.GeraRodape;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//
//public abstract class TelaCadastroVeiculo extends JFrame{
//
//
//        protected VeiculoEmArquivoRepository repositorioDeVeiculos = new VeiculoEmArquivoRepository();
//        protected JButton btnBotaoSair = new JButton("Sair");
//        protected JButton btnCadastro = new JButton("Cadastrar");
//        protected JButton btnLimparCampos = new JButton("Limpar campos");
//        protected GeraRodape pnlRodape = new GeraRodape();
//
//        protected int tamanhoColunasTextField = 20;
//        protected JLabel lblModelo;
//        protected JTextField txtModelo;
//
//        protected JLabel lblMarca;
//        protected JTextField txtMarca;
//
//        protected JLabel lblPlaca;
//        protected JTextField txtPlaca;
//
//        protected JLabel lblAnoDeFabricacao;
//        protected JTextField txtAnoDeFabricacao;
//
//        protected JLabel lblTipoDeVeiculo;
//        protected JTextField txtTipoDeVeiculo;
//
//
//        protected JPanel pnlFormCadastroVeiculo;
//
//        public TelaCadastroVeiculo() {
//            this.incializar();
//            this.eventos();
//        }
//
//        private void incializar() {
//            setLayout(null);
//            this.setTitle("Cadastro - Veiculo");
//            this.getContentPane().setLayout(new BorderLayout());
//            this.setResizable(false);
//            this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//            this.getContentPane().add(getPnlFormCadastroVeiculo(), BorderLayout.CENTER);
//            this.getContentPane().add(pnlRodape.getPnlRodapeComum(btnCadastro, btnBotaoSair, btnLimparCampos), BorderLayout.PAGE_END);
//            this.pack();
//        }
//
//        protected abstract void btnCadastrarVeiculo(ActionEvent ev);
//        protected abstract void btnBotaoSair(ActionEvent ev);
//        protected abstract void btnLimparCampos(ActionEvent ev);
//        private void eventos(){
//            btnCadastro.addActionListener(this::btnCadastrarVeiculo);
//            btnBotaoSair.addActionListener(this::btnBotaoSair);
//            btnLimparCampos.addActionListener(this::btnLimparCampos);
//        }
//
//        public JPanel getPnlFormCadastroVeiculo() {
//
//            if (pnlFormCadastroVeiculo == null) {
//
//                pnlFormCadastroVeiculo = new JPanel();
//                pnlFormCadastroVeiculo.setLayout(new GridLayout(5, 1, 20, 15));
//
//                lblModelo = new JLabel("Modelo");
//                txtModelo = new JTextField(tamanhoColunasTextField);
//
//                lblMarca = new JLabel("Marca");
//                txtMarca = new JTextField(tamanhoColunasTextField);
//
//                lblPlaca = new JLabel("Placa");
//                txtPlaca = new JTextField(tamanhoColunasTextField);
//
//                lblAnoDeFabricacao = new JLabel("Ano De Fabricação");
//                txtAnoDeFabricacao= new JTextField(tamanhoColunasTextField);
//
//                lblTipoDeVeiculo= new JLabel("Tipo do veiculo");
//                txtTipoDeVeiculo = new JTextField(tamanhoColunasTextField);
//
//                pnlFormCadastroVeiculo.add(lblModelo);
//                pnlFormCadastroVeiculo.add(txtModelo);
//
//                pnlFormCadastroVeiculo.add(lblMarca);
//                pnlFormCadastroVeiculo.add(txtMarca);
//
//                pnlFormCadastroVeiculo.add(lblPlaca);
//                pnlFormCadastroVeiculo.add(txtPlaca);
//
//                pnlFormCadastroVeiculo.add(lblAnoDeFabricacao);
//                pnlFormCadastroVeiculo.add(txtAnoDeFabricacao);
//
//                pnlFormCadastroVeiculo.add(lblTipoDeVeiculo);
//                pnlFormCadastroVeiculo.add(txtTipoDeVeiculo);
//
//
//            }
//            return pnlFormCadastroVeiculo;
//        }
//
//    }
//
