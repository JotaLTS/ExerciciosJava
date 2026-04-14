package execucao;

import dominio.Atendente;
import dominio.Gerente;
import dominio.Vendedor;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Gerente gerente = new Gerente("Clovis","123321","clovis@gmail.com");
        Vendedor vendedor = new Vendedor("Binha","12356","binha@gmail.com");
        Atendente atendente = new Atendente("Zeka","09876","zeka@gmail.com");

        // demonstrando login
        gerente.realizarLogin(sc);

        // demonstrando vendas
        vendedor.realizarVenda();
        gerente.consultarVendas(vendedor);

        // demonstrando caixa
        atendente.receberPagamento(150.00);
        gerente.gerarRelatorioFinanceiro(vendedor, atendente);

        // demonstrando alteração de dados/senha e logoff
        gerente.realizarLogoff();
        gerente.alterarDados(sc);
        gerente.alteraSenha(sc);

        // demonstrando consultar venda e fechamento do caixa
        vendedor.consultarVenda();
        System.out.println(atendente.fecharCaixa());

    }
}