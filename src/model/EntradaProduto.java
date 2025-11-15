package model;

import java.util.Date;

public class EntradaProduto  extends MovimentoEstoque implements Movimentavel {


    public EntradaProduto(float valorUnitario, Date data, int qtd,Produto produto) {
        super(valorUnitario, data, qtd, produto);
    }

    @Override
    public void aplicarMovimento() {
        getProduto().aumentarEstoque(getQtd());
    }
}
