package execucao;

import dominio.Ingresso;
import dominio.IngressoFamilia;
import dominio.IngressoTipo;
import dominio.MeiaEntrada;

public class Main {
    public static void main(String[] args) {
        IngressoFamilia ingressoFamilia = new IngressoFamilia(25,"Motoqueiro Fantasma",IngressoTipo.DUBLADO,10);
        MeiaEntrada meiaEntrada = new MeiaEntrada(25,"Vingadores",IngressoTipo.LEGENDADO);
        System.out.println("O valor que devera pagar no ingresso familia é: "+ingressoFamilia.calcularValor());
        System.out.println("O valor que devera pagar no meiaEntrada é: "+meiaEntrada.calcularValor());
    }
}
