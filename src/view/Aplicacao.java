package view;

import javax.swing.*;


public class Aplicacao {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaInicial inicio = new TelaInicial();
            inicio.setVisible(true);
        });
    }}
