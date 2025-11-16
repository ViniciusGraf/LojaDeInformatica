import model.*;

import javax.swing.*;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        ControleEstoque controle = new ControleEstoque();

        Produto p1 = new Produto("Celular",2.999f,5, Categoria.outrosProdutos);
        Cliente c1 = new Cliente("Carlos Mota","Rua do Alho 123");
        Fornecedor f1 = new Fornecedor("Super Celulares LTA", "Rua Antonio Veiga 123");

        //Verifica quantidade atual do estoque
        System.out.println(p1.getQtdEstoque());

        //Cria uma entrada de produto - +20
        EntradaProduto ep1 = new EntradaProduto(2.999f,LocalDateTime.now(),20,p1,f1);
        //Faz a operação de aumentar a quantidade
        controle.registrarMovimento(ep1);

        //Verifica quantidade atual do estoque após a operação
        System.out.println(p1.getQtdEstoque());

        //Faz saida de produto
        VendasClientes vc1 = new VendasClientes(2.999f, LocalDateTime.now(),2,p1,c1);
        UsoInterno ui1 = new UsoInterno(2.999f, LocalDateTime.now(),5,p1,"Entregadores");
        DevolucaoFornecedores df1 = new DevolucaoFornecedores(2.999f,LocalDateTime.now(),8,p1,f1);
        OutrasSaidas os1 = new OutrasSaidas(2.999f,LocalDateTime.now(),5,p1,"Perda do estoque");

        //REGISTRA — o ControleEstoque chama aplicarMovimento()
        controle.registrarMovimento(vc1);
        controle.registrarMovimento(ui1);
        controle.registrarMovimento(df1);
        controle.registrarMovimento(os1);

        controle.exibirEntradas();
        controle.exibirSaidas();
        controle.exibirTodosMovimentos();
        controle.exibirSaldoAtual();

    }
}