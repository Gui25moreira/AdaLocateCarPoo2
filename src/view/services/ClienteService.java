package view.services;
import model.clientes.Cliente;
import model.clientes.ClienteFisico;
import model.clientes.Contato;
import model.clientes.Endereco;
import view.clientes.TelaCadastroCliente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClienteService extends TelaCadastroCliente{

    protected void btnCadastrarCliente(ActionEvent ev){

        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String dataDeNascimento = txtDataDeNascimento.getText();
        Endereco endereco = new Endereco(txtRua.getText(),txtBairro.getText(),txtNumero.getText(),txtEstado.getText());
        Contato contato = new Contato(txtNumeroDeTelefone.getText(),txtEmail.getText());

        Cliente cliente = new Cliente(nome,cpf,endereco,contato);
        repositorioDeClientes.salvar(cliente);
        JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso", "Confirmação", JOptionPane.WARNING_MESSAGE);
        setVisible(false);
        TelaCadastroCliente tela = new ClienteService();
        tela.setVisible(true);
        this.setLocationRelativeTo(null);
    }

    @Override
    protected void btnBotaoSair(ActionEvent ev){
        this.setVisible(false);
        this.dispose();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
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
}
