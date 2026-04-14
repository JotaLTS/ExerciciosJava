package dominio;

public class MeiaEntrada extends Ingresso{
    public MeiaEntrada(double valor, String nomeFilme, IngressoTipo ingressoTipo) {
        super(valor, nomeFilme, ingressoTipo);
    }

    @Override
    public double calcularValor() {
        return getValor()/2;
    }


}
