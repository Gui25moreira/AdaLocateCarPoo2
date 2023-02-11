//package view.services;
//import model.veiculos.Veiculo;
//import view.veiculos.TelaCadastroVeiculo;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//
//public class CadastrarVeiculoService extends TelaCadastroVeiculo {
//    protected void btnCadastrarVeiculo(ActionEvent ev){
//
//        String nome = txtModelo.getText();
//        String marca = txtMarca.getText();
//        String placa = txtPlaca.getText();
//        String anoDeFabricação = txtAnoDeFabricacao.getText();
//        String tipoDeVeiculo = txtTipoDeVeiculo.getText();
//
//        Veiculo veiculo = new Veiculo(nome, marca,placa,anoDeFabricação,tipoDeVeiculo);
//
//        repositorioDeVeiculos.salvar(veiculo);
//        setVisible(false);
//        TelaCadastroVeiculo tela = new CadastrarVeiculoService();
//        tela.setVisible(true);
//    }
//
//    @Override
//    protected void btnBotaoSair(ActionEvent ev){
//        this.setVisible(false);
//        this.dispose();
//        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//    }
//
//    @Override
//    protected void btnLimparCampos(ActionEvent ev) {
//
//        txtModelo.setText("");
//        txtMarca.setText("");
//        txtPlaca.setText("");
//        txtAnoDeFabricacao.setText("");
//        txtTipoDeVeiculo.setText("");
//
//    }
//
//}
