package execucao;

import dominio.MaquinaDeBanho;
import dominio.Pet;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        MaquinaDeBanho maquinaDeBanho = new MaquinaDeBanho();
        Pet pet = new Pet("Cotoco",false);
        var sc = new Scanner(System.in);
        while (!processarOpcao(sc,maquinaDeBanho,pet));
    }

    private static void menu() {
        System.out.println("------------------------------");
        System.out.println("1 - Dar banho no pet");
        System.out.println("2 - Abastecer com Agua");
        System.out.println("3 - Abastecer com Shampoo");
        System.out.println("4 - Verificar nivel da agua");
        System.out.println("5 - Verificar nivel de shampoo");
        System.out.println("6 - Verificar se tem pet no banho");
        System.out.println("7 - Colocar pet na maquina");
        System.out.println("8 - Retirar pet da maquina");
        System.out.println("9 - Limpar maquina");
        System.out.println("10 - Sair da loja");
        System.out.println("------------------------------");
    }

    private static boolean processarOpcao(Scanner sc, MaquinaDeBanho maquinaDeBanho, Pet pet){
        menu();
        System.out.print("Digite uma opcao: ");
        var opcao = sc.nextInt();
        switch (opcao){
            case 1:
                if(possoDarBanho(maquinaDeBanho)){
                    System.out.println("Dando banho no pet");
                    maquinaDeBanho.darBanhoPet();
                    return false;
                }
                System.out.println("Não foi possivel dar banho");
                return false;
            case 2:
                maquinaDeBanho.abastecerAgua();
                return false;
            case 3:
                maquinaDeBanho.abastecerShampoo();
                return false;
            case 4:
                System.out.printf("O nivel da agua é de %.2f\n",maquinaDeBanho.getAgua());
                return false;
            case 5:
                System.out.printf("O nível do shampoo é de %.2f\n",maquinaDeBanho.getShampoo());
                return false;
            case 6:
                if(maquinaDeBanho.getPet() != null){
                    System.out.println(pet.toString());
                    return false;
                }
                System.out.println("Não tem pet na maquina");
                return false;
            case 7:
                if(maquinaDeBanho.getPet() == null){
                    System.out.println("Colocando pet na maquina");
                    maquinaDeBanho.setPet(pet);
                    return false;
                }
                System.out.println("Já tem pet na maquina");
                return false;
            case 8:
                if(maquinaDeBanho.getPet() == null){
                    System.out.println("Não foi possivel retirar o pet, pois não tem pet");
                    return false;
                }
                if(pet.isEstaPetLimpo()){
                    System.out.println("Retirando o pet");
                    pet.setEstaPetLimpo(false);
                    maquinaDeBanho.setPet(null);
                    return false;
                }
                System.out.println("Retirando o pet");
                System.out.println("Voce retirou o pet estando sujo, lavando maquina automaticamente");
                maquinaDeBanho.limparMaquina();
                maquinaDeBanho.setPet(null);
                return false;
            case 9:
                if(maquinaDeBanho.isEstaMaquinaLimpa()){
                    System.out.println("A maquina já está limpa");
                    return false;
                }
                System.out.println("Limpando a maquina");
                maquinaDeBanho.limparMaquina();
                return false;
            case 10:
                System.out.println("Saindo da loja");
                return true;
            default:
                System.out.println("Digite uma opcao valida");
                return false;
        }
    }
    private static boolean possoDarBanho(MaquinaDeBanho maquinaDeBanho){
        return !(maquinaDeBanho.getAgua() <= 0 || maquinaDeBanho.getShampoo() <=0 || maquinaDeBanho.getPet() == null || !maquinaDeBanho.isEstaMaquinaLimpa());
    }
}