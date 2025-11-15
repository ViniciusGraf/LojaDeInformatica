package model;

import java.util.Date;

public abstract class MovimentoEstoque{
    private float valorUnitario;
    private Date data;
    private int qtd;
    private Produto produto;

    public MovimentoEstoque(float valorUnitario, Date data, int qtd, Produto produto) {
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

    public Date getData() {
        return data;
    }
}
