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
    private long quantidade;
    //LocalDateTime inicio = LocalDateTime.now();
    //LocalDateTime fim = inicio.plus(8, ChronoUnit.DAYS).plus(15, ChronoUnit.SECONDS);
    public Devolucao(Veiculo veiculo, Cliente cliente, Aluguel aluguel) {

        super(veiculo, cliente);
        Duration duration = Duration.between(aluguel.getData(), LocalDateTime.now());

        if(duration.toHours()%24!=0 || duration.toHours()==0){
            quantidade = (duration.toDays())+1l;
        }else {
            quantidade = duration.toDays();
        }
        String numeroDeDias = Long.toString(quantidade);
        valorAPagar = BigDecimal.valueOf((Integer.parseInt(numeroDeDias)) * veiculo.getValorAluguel());
    }

    public BigDecimal getValorAPagar() {
        return valorAPagar;
    }

    public void setValorAPagar(BigDecimal valorAPagar) {
        this.valorAPagar = valorAPagar;
    }

    public LocalDateTime getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public void setDataDeDevolucao(LocalDateTime dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }
}
