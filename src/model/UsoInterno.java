package model;

import java.util.Date;

public class UsoInterno extends SaidaProduto{

    private String destino;
    public UsoInterno(float valorUnitario, Date data, int qtd, Produto produto, String destino) {
        super(valorUnitario, data, qtd, produto);
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }
}
