import model.Categoria;
import model.Cliente;
import model.Produto;
import model.VendasClientes;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

    Produto p1 = new Produto("Celular",2.999f,4, Categoria.outrosProdutos);
    Cliente c1 = new Cliente("Super Celulares LTA","Rua do Alho 123");

    p1.aumentarEstoque(12);
    System.out.println(p1.getQtdEstoque());

    VendasClientes vc1 = new VendasClientes(2.999f, LocalDateTime.now(),1,p1,c1);

        System.out.println(p1.getQtdEstoque());
    }
}