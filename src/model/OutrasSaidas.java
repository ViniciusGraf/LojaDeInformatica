package model;

import java.time.LocalDateTime;
import java.util.Date;

public class OutrasSaidas extends SaidaProduto{

    private String outraSaida;
    public OutrasSaidas(float valorUnitario, LocalDateTime data, int qtd, Produto produto, String outraSaida) {
        super(valorUnitario, data, qtd, produto);
        this.outraSaida = outraSaida;
    }

    public String getOutraSaida() {
        return outraSaida;
    }

    @Override
    public String getTipoSaida() {
        return "Outra Saida";
    }

    @Override
    public String toString() {
        return super.toString() +
                "Outra Saida: " + outraSaida;
    }
}
