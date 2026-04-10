package dominio;

public class IngressoFamilia extends Ingresso{
    private int numeroDePessoas;

    public IngressoFamilia(double valor, String nomeFilme, IngressoTipo ingressoTipo, int numeroDePessoas) {
        super(valor, nomeFilme, ingressoTipo);
        this.numeroDePessoas = numeroDePessoas;
    }

    public double getNumeroDePessoas() {
        return numeroDePessoas;
    }

    public void setNumeroDePessoas(int numeroDePessoas) {
        this.numeroDePessoas = numeroDePessoas;
    }

    @Override
    public double calcularValor() {
        if(this.numeroDePessoas > 3){
            return (getValor()*this.numeroDePessoas)*0.95;
        }
        return getValor()*this.numeroDePessoas;
    }
}
