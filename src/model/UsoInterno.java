package model;

import java.time.LocalDateTime;

public class UsoInterno extends SaidaProduto{

    private String destino;
    public UsoInterno(float valorUnitario, LocalDateTime data, int qtd, Produto produto, String destino) {
        super(valorUnitario, data, qtd, produto);
        this.destino = destino;
    }

    public String getDestino() {
        return destino;
    }

    @Override
    public String getTipoSaida() {
        return "Uso Interno";
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nDestino: " + destino;
    }
}
