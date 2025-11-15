package model;

import java.util.Date;

public class OutrasSaidas extends SaidaProduto{

    private String outraSaida;
    public OutrasSaidas(float valorUnitario, Date data, int qtd, Produto produto, String outraSaida) {
        super(valorUnitario, data, qtd, produto);
        this.outraSaida = outraSaida;
    }

    public String getOutraSaida() {
        return outraSaida;
    }
}
