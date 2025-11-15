package model;

import java.time.LocalDateTime;
import java.util.Date;

public class EntradaProduto  extends MovimentoEstoque implements Movimentavel {

    private Fornecedor fornecedor;
    public EntradaProduto(float valorUnitario, LocalDateTime data, int qtd, Produto produto, Fornecedor fornecedor) {
        super(valorUnitario, data, qtd, produto);
        this.fornecedor = fornecedor;
    }

    @Override
    public void aplicarMovimento() {
        getProduto().aumentarEstoque(getQtd());
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
}
