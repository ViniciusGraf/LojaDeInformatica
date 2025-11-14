package model;

public class Produto {

    private static int contador;
    private int id;
    private String nome;
    private float valorUnitario;
    private int qtdEstoque;
    private Categoria categoria;

    public Produto(String nome, float preco, int qtdEstoque, Categoria categoria) {
        this.id += contador;
        this.nome = nome;
        this.valorUnitario = preco;
        this.qtdEstoque = qtdEstoque;
        this.categoria = categoria;
    }

    public void aumentarEstoque(int qtd) {
        this.qtdEstoque += qtd;
    }

    public void diminuirEstoque(int qtd) {
        this.qtdEstoque -= qtd;
    }

    public int getQtdEstoque() {
        return qtdEstoque;
    }


    // Geters e Seters não sei se precisa de todos
    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return valorUnitario;
    }

    public void setPreco(float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
