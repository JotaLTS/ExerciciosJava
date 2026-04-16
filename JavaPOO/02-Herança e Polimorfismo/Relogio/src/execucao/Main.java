package execucao;

import dominio.RelogioAmericano;
import dominio.RelogioBrasileiro;

public class Main {
    public static void main(String[] args) {
        RelogioAmericano relogioAmericano = new RelogioAmericano(4,50,40);
        RelogioAmericano relogioAmericano2 = new RelogioAmericano(4,50,40);
        RelogioBrasileiro relogioBrasileiro = new RelogioBrasileiro(13,30,0);
        //Chama os metodos de conversão
        relogioAmericano.conversorHora(relogioBrasileiro);
        relogioBrasileiro.conversorHora(relogioAmericano2);
        //Printa os resultados
        System.out.println(relogioAmericano.retornarHora());
        System.out.println(relogioBrasileiro.retornarHora());
    }
}