package view.clientes;

import model.JTableModel;
import model.clientes.Cliente;
import model.repositorys.clientes.ClienteFisicoEmArquivoRepository;
import view.services.ClienteService;
import view.services.GeraRodape;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class TelaConsultarCliente extends JFrame {
    protected JButton btnBotaoSair = new JButton("Sair");
    protected JButton btnVoltar = new JButton("Voltar");
    protected JButton btnLimparCampos = new JButton("Limpar campos");
    protected JButton btnDeletar = new JButton("Deletar");
    protected JButton btnAtualizar = new JButton("Atualizar");

    protected ClienteFisicoEmArquivoRepository repositorioDeClientes = new ClienteFisicoEmArquivoRepository();
    protected ClienteService service = new ClienteService();
    protected GeraRodape pnlRodape = new GeraRodape();
    protected JPanel pnlForm = new JPanel();

    public TelaConsultarCliente() {
        this.incializar();
    }
    private void incializar(){

        List<Cliente> clientes = repositorioDeClientes.listarTodos();
        JTableModel meuTable = new JTableModel(clientes);
        JTable jTable = new JTable(meuTable);
        JScrollPane scrollPane = new JScrollPane(jTable);
        pnlForm = service.getPnlFormCadastroCliente();
        this.setTitle("Tela de consulta Clientes");
        this.getContentPane().add(scrollPane,BorderLayout.LINE_START);
        this.getContentPane().add(pnlForm, BorderLayout.CENTER);
        this.getContentPane().add(pnlRodape.getPnlRodapeManipularCliente( btnAtualizar,  btnDeletar,  btnLimparCampos, btnBotaoSair, btnVoltar), BorderLayout.PAGE_END);
        service.setarValoresCampos(jTable);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

}

