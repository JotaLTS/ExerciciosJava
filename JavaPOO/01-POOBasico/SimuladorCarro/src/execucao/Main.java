package execucao;

import dominio.Carro;

import java.util.Scanner;

public class Main {
    public static void main() {
        Carro carro = new Carro();
        var sc = new Scanner(System.in);
        while (!processarOpcao(sc, carro)) ;
    }

    private static void menu() {
        System.out.println("------------------------------");
        System.out.println("1 - Ligar o Carro");
        System.out.println("2 - Desligar o Carro");
        System.out.println("3 - Acelerar");
        System.out.println("4 - Diminuir Velocidade");
        System.out.println("5 - Virar para esquerda/direita");
        System.out.println("6 - Verificar Velocidade");
        System.out.println("7 - Trocar a marcha");
        System.out.println("8 - Descer do Carro");
        System.out.println("------------------------------");
    }


    private static boolean processarOpcao(Scanner sc, Carro carro) {
        menu();
        System.out.print("Digite uma opcao: ");
        var opcao = sc.nextInt();
        switch (opcao) {
            case 1:
                if (!carro.getisCarroLigado()) {
                    System.out.println("Ligando o Carro");
                    carro.setisCarroLigado(true);
                    return false;
                }
                System.out.println("O carro já está ligado");
                return false;
            case 2:
                if (carro.getMarcha() == 0 && carro.getVelocidade() == 0) {
                    System.out.println("Desligando Carro");
                    carro.setisCarroLigado(false);
                    return false;
                }
                System.out.println("Não foi possivel desligar o carro, verefique sua velocidade e/ou marcha");
                return false;
            case 3:
                if (carroAcao(carro, "Não é possivel acelerar o carro, pois o carro está desligado")) return false;
                carro.acelerar();
                System.out.printf("Acelerando o carro, atualmente você está a %.2fKm/h\n",carro.getVelocidade());
                return false;
            case 4:
                if (carroAcao(carro, "Não é possivel desacelerar o carro, pois o carro está desligado")) return false;
                carro.desacelerar();
                System.out.printf("Desacelerando o carro, atualmente você está a %.2fKm/h\n",carro.getVelocidade());
                return false;
            case 5:
                if (carroAcao(carro, "Não é possivel virar para a esquerda/direita, pois o carro está desligado")) return false;
                System.out.println("Você deseja virar para qual lado?");
                var lado = sc.nextLine();
                if(virarLado(carro)){
                    System.out.println("Você virou para a "+ lado);
                    return false;
                }
                System.out.println("Não foi possível virar para a esquerda/direira, verifique sua velocidade");
                return false;
            case 6:
                System.out.printf("Você está atualmente a %.2fKm/h\n",carro.getVelocidade());
                return false;
            case 7:
                if(carroAcao(carro,"Não é possivel trocar de marcha, pois o carro está desligado")) return false;
                System.out.println("Você deseja aumentar ou diminuir a marcha?");
                var escolha = sc.next().charAt(0);
                if(escolha == 'a'){
                    carro.aumentarMarcha();
                    System.out.println("Você está agora na marcha "+carro.getMarcha());
                    return false;
                }
                carro.diminuirMarcha();
                System.out.println("Você está agora na marcha "+carro.getMarcha());
                return false;
            case 8:
                if(!carro.getisCarroLigado()){
                    System.out.println("Descendo do carro");
                    return true;
                }
                System.out.println("Não é possivel descer do carro, pois ele está ligado");
                return false;
            default:
                System.out.println("Digite uma opcao valida");
                return false;
        }
    }

    private static boolean carroAcao(Carro carro, String texto) {
        if (!carro.getisCarroLigado()) {
            System.out.println(texto);
            return true;
        }
        return false;
    }

    private static boolean virarLado(Carro carro){
        if(carro.getVelocidade() >= 1 && carro.getVelocidade() <= 40){
            return true;
        }
        return false;
    }
}