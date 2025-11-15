package model;

import java.util.Date;

public abstract class SaidaProduto extends MovimentoEstoque implements Movimentavel {

    public SaidaProduto(float valorUnitario, Date data, int qtd, Produto produto) {
        super(valorUnitario, data, qtd, produto);
    }

    @Override
    public void aplicarMovimento() {
        getProduto().aumentarEstoque(getQtd());
    }
}
