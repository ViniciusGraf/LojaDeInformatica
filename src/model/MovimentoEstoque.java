package model;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class MovimentoEstoque{
    private float valorUnitario;
    private LocalDateTime data;
    private int qtd;
    private Produto produto;

    public MovimentoEstoque(float valorUnitario, LocalDateTime data, int qtd, Produto produto) {
        this.valorUnitario = valorUnitario;
        this.data = data;
        this.qtd = qtd;
        this.produto = produto;
    }

    public int getQtd() {
        return qtd;
    }

    public Produto getProduto() {
        return produto;
    }

    public LocalDateTime getData() {
        return data;
    }
}
