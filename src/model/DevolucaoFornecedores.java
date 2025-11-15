package model;

import java.time.LocalDateTime;
import java.util.Date;

public class DevolucaoFornecedores extends SaidaProduto{

    private Fornecedor fornecedor;
    public DevolucaoFornecedores(float valorUnitario, LocalDateTime data, int qtd, Produto produto, Fornecedor fornecedor) {
        super(valorUnitario, data, qtd, produto);
        this.fornecedor = fornecedor;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }
}
