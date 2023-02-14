import view.TelaInicial;

import javax.swing.*;

public class AplicacaoMain {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TelaInicial inicio = new TelaInicial();
            inicio.setVisible(true);
        });
    }}

// O projeto buscou atender todos os requisitos citados no enunciado do exercício.
// Além disso, foram utilizadas ferramentas de interface gráfica para a interação do usuário.
// O projeto com repositorios em arquivo e em memória, porém a classe VeiculoEmArquivoRepository...
// Apresentou inconstâncias e deve ser utilizado somente os dados em cache para testes.

