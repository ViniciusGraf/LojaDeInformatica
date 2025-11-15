package model;

public class Produto {
    // teste

    private static int contador = 0;

    private int id;
    private String nome;
    private float valorUnitario;
    private int qtdEstoque;
    private Categoria categoria;

    public Produto(String nome, float valorUnitario, int qtdEstoque, Categoria categoria) {
        if (valorUnitario < 0) throw new IllegalArgumentException("Valor não pode ser negativo");
        if (qtdEstoque < 0) throw new IllegalArgumentException("Estoque não pode ser negativo");

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
        if (qtd > qtdEstoque) {
            throw new IllegalArgumentException("Quantidade insuficiente em estoque.");
        }
        this.qtdEstoque -= qtd;
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
