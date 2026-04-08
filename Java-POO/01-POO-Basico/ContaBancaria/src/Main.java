import dominio.ContaBancaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        System.out.println("Para criar uma conta, é necessário um deposito");
        double deposito = verificarDeposito(sc);
        var cliente = new ContaBancaria(deposito);
        while (!processarOpcao(sc, cliente)) ;
    }

    private static void menu() {
        System.out.println("-----------------------------------");
        System.out.println("1 - Consultar Saldo");
        System.out.println("2 - Consultar Cheque Especial");
        System.out.println("3 - Depositar Dinheiro");
        System.out.println("4 - Sacar Dinheiro");
        System.out.println("5 - Pagar um Boleto");
        System.out.println("6 - Uso do Cheque Especial");
        System.out.println("7 - Usar Valor do Cheque Especial");
        System.out.println("8 - sair");
        System.out.println("-----------------------------------");
    }

    private static double verificarDeposito(Scanner sc) {
        System.out.print("Qual valor desejas depositar: R$ ");
        double valor = sc.nextDouble();
        while (valor <= 0) {
            System.out.print("Valor invalido, digite um novo valor: ");
            valor = sc.nextDouble();
        }
        return valor;
    }

    private static boolean processarOpcao(Scanner sc, ContaBancaria cliente) {
        menu();
        System.out.print("Digite a opcção desejada: ");
        int opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                System.out.println("Seu saldo é de R$ " + cliente.getSaldo());
                return false;
            case 2:
                System.out.println("Seu Cheque especial tem o valor de R$ " + cliente.getChequeEspecial());
                return false;
            case 3:
                System.out.print("Qual o valor que você deseja depositar? R$ ");
                double depositarDinheiro = sc.nextDouble();
                cliente.depositarDinheiro(depositarDinheiro);
                return false;
            case 4:
                System.out.print("Qual o valor que você deseja sacar? R$");
                double saque = sc.nextDouble();
                cliente.sacarDinheiro(saque);
                return false;
            case 5:
                System.out.print("Digite o valor do Boleto: R$ ");
                double boleto = sc.nextDouble();
                cliente.pagarBoleto(boleto);
                return false;
            case 6:
                String uso = cliente.getIsChequeEspecialUso() ? "Ativado" : "Reprovado";
                System.out.println(uso);
                return false;
            case 7:
                if (cliente.getIsChequeEspecialUso()) {
                    System.out.println("Você pode pagar um boleto usando seu Cheque Especial e voce tem: R$" + cliente.getChequeEspecial());
                    System.out.print("Digite o valor do Boleto: R$ ");
                    double boleto2 = sc.nextDouble();
                    cliente.pagarBoletoCheque(boleto2);
                    return false;
                } else {
                    System.out.println("Você não pode usar o valor do seu cheque, só podera ser usado em caso de saldo zerado");
                    return false;
                }
            case 8:
                System.out.println("MUITO OBRIGADO POR USAR O NOSSO BANCO");
                return true;
            default:
                System.out.println("OPÇÂO INVALIDA");
                return false;
        }
    }
}


