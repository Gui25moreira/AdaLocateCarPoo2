package model.sistema;

import model.clientes.Cliente;
import model.veiculos.Veiculo;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Devolucao extends Sistema {
    private BigDecimal valorAPagar;
    private LocalDateTime dataDeDevolucao;
    private Aluguel aluguel;
    public Devolucao (Veiculo veiculo, Cliente cliente, Aluguel aluguel) {

        super(veiculo, cliente);
        dataDeDevolucao = LocalDateTime.now();
        Duration duration = Duration.between(aluguel.getData(),dataDeDevolucao);
        String numeroDeDias = Long.toString(duration.toDays());

        valorAPagar = BigDecimal.valueOf((Integer.parseInt(numeroDeDias))*veiculo.getValorAluguel());
    }

    public boolean devolverVeiculo(){
     return true;
 }

}
