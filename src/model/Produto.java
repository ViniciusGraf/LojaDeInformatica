package model;

public class Produto {

    private static int contador = 0;

    private int id;
    private String nome;
    private float valorUnitario;
    private int qtdEstoque;
    private Categoria categoria;

    public Produto(String nome, float valorUnitario, int qtdEstoque, Categoria categoria) {
        this.id = ++contador;
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.qtdEstoque = qtdEstoque;
        this.categoria = categoria;
    }

    public void aumentarEstoque(int qtd) {
        if (qtd > 0) {
            this.qtdEstoque += qtd;
        }
    }

    public void diminuirEstoque(int qtd) {
        if (qtd > 0) {
            this.qtdEstoque -= qtd;
        }
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getValorUnitario() {
        return valorUnitario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
