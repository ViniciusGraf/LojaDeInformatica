package model;

import java.time.LocalDateTime;

public abstract class SaidaProduto extends MovimentoEstoque{

    public SaidaProduto(float valorUnitario, LocalDateTime data, int qtd, Produto produto) {
        super(valorUnitario, data, qtd, produto);
    }

    @Override
    public void aplicarMovimento() {
        getProduto().diminuirEstoque(getQtd());
    }

    public String getTipoSaida(){return null;}

    @Override
    public String toString() {
        return "\n== Saida de Produto ==" +
                "\nTipo: " + getTipoSaida() +
                "\nProduto: " + getProduto().getNome() +
                "\nQuantidade: " + getQtd();

    }


}
