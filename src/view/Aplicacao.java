package view;
import javax.swing.*;
import java.time.Duration;

public class Aplicacao {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            TelaInicial inicio = new TelaInicial();
            inicio.setVisible(true);
        });
    }}
