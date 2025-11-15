package model;

import java.util.Date;

public class VendasClientes extends SaidaProduto{

    private Cliente cliente;
    public VendasClientes(float valorUnitario, Date data, int qtd, Produto produto, Cliente cliente) {
        super(valorUnitario, data, qtd, produto);
        this.cliente = cliente;
    }

    @Override
    public void aplicarMovimento() {
        getProduto().aumentarEstoque(getQtd());
    }

    public Cliente getCliente() {
        return cliente;
    }
}
