package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ControleEstoque {

    private List<MovimentoEstoque> movimentos = new ArrayList<>();


    // ---------------------------------------------------
    // REGISTRAR MOVIMENTO (entrada ou saída)
    // ---------------------------------------------------
    public void registrarMovimento(Movimentavel mov) {
        // Aplica o impacto no estoque
        mov.aplicarMovimento();

        // Garante que é um movimento de estoque válido
        if (mov instanceof MovimentoEstoque) {
            movimentos.add((MovimentoEstoque) mov);
        } else {
            throw new IllegalArgumentException(
                    "O movimento registrado não é um MovimentoEstoque válido."
            );
        }
    }

    // ---------------------------------------------------
    // LISTAGENS SIMPLES
    // ---------------------------------------------------
    public List<EntradaProduto> listarEntradas() {
        List<EntradaProduto> lista = new ArrayList<>();
        for (MovimentoEstoque m : movimentos) {
            if (m instanceof EntradaProduto) {
                lista.add((EntradaProduto) m);
            }
        }
        return lista;
    }

    public List<SaidaProduto> listarSaidas() {
        List<SaidaProduto> lista = new ArrayList<>();
        for (MovimentoEstoque m : movimentos) {
            if (m instanceof SaidaProduto) {
                lista.add((SaidaProduto) m);
            }
        }
        return lista;
    }

    public List<MovimentoEstoque> listarMovimentosOrdenados() {
        List<MovimentoEstoque> lista = new ArrayList<>(movimentos);
        lista.sort(Comparator.comparing(MovimentoEstoque::getData));
        return lista;
    }

    // ---------------------------------------------------
    // SALDO (quantidade e valor total)
    // ---------------------------------------------------
    public int getSaldoAtualQuantidade() {
        int saldo = 0;

        for (MovimentoEstoque m : movimentos) {
            if (m instanceof EntradaProduto)
                saldo += m.getQtd();
            else
                saldo -= m.getQtd();
        }
        return saldo;
    }

    public float getSaldoAtualValor() {
        float total = 0f;

        for (MovimentoEstoque m : movimentos) {
            float valor = m.produto.getValorUnitario();

            if (m instanceof EntradaProduto)
                total += valor * m.getQtd();
            else
                total -= valor * m.getQtd();
        }
        return total;
    }

    // ---------------------------------------------------
    // CONSULTA POR PERÍODO
    // ---------------------------------------------------
    public float getSaldoPorPeriodo(LocalDateTime inicio, LocalDateTime fim) {
        float total = 0f;

        for (MovimentoEstoque m : movimentos) {
            if (!m.getData().isBefore(inicio) && !m.getData().isAfter(fim)) {

                float valor = m.produto.getValorUnitario();

                if (m instanceof EntradaProduto)
                    total += valor * m.getQtd();
                else
                    total -= valor * m.getQtd();
            }
        }
        return total;
    }

    // ---------------------------------------------------
    // MÉTODOS DE EXIBIÇÃO BONITOS
    // ---------------------------------------------------

    public void exibirEntradas() {
        System.out.println("\n====== ENTRADAS DE PRODUTOS ======");
        for (EntradaProduto e : listarEntradas()) {
            System.out.printf("Data: %s | Produto: %-12s | Qtd: %d | Valor Unitário: %.2f%n",
                    e.getData(), e.getProduto().getNome(), e.getQtd(), e.getProduto().getValorUnitario());
        }
    }

    public void exibirSaidas() {
        System.out.println("\n====== SAÍDAS DE PRODUTOS ======");
        for (SaidaProduto s : listarSaidas()) {
            System.out.printf("Data: %s | Produto: %-12s | Qtd: %d | Valor Unitário: %.2f%n",
                    s.getData(), s.getProduto().getNome(), s.getQtd(), s.getProduto().getValorUnitario());
        }
    }

    public void exibirTodosMovimentos() {
        System.out.println("\n====== EXTRATO COMPLETO DO ESTOQUE ======");

        for (MovimentoEstoque m : listarMovimentosOrdenados()) {

            String tipo = (m instanceof EntradaProduto) ? "ENTRADA" : "SAÍDA";
            int impacto = (m instanceof EntradaProduto) ? m.getQtd() : -m.getQtd();

            System.out.printf(
                    "Data: %s | Tipo: %-7s | Produto: %-12s | Qtd Impacto: %+d%n",
                    m.getData(), tipo, m.getProduto().getNome(), impacto
            );
        }
    }

    public void exibirSaldoAtual() {
        System.out.println("\n====== SALDO ATUAL DO ESTOQUE ======");
        System.out.println("Quantidade total: " + getSaldoAtualQuantidade());
        System.out.printf("Valor total: R$ %.2f%n", getSaldoAtualValor());
    }
}
