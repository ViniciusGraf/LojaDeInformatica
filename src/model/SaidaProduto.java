package model;

import java.time.LocalDateTime;
import java.util.Date;

public abstract class SaidaProduto extends MovimentoEstoque implements Movimentavel {

    public SaidaProduto(float valorUnitario, LocalDateTime data, int qtd, Produto produto) {
        super(valorUnitario, data, qtd, produto);
    }

    @Override
    public void aplicarMovimento() {
        getProduto().aumentarEstoque(getQtd());
    }
}
