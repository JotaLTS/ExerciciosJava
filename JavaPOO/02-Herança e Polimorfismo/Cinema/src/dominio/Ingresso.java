package dominio;

public abstract class Ingresso {
    private double valor;
    private String nomeFilme;
    private IngressoTipo ingressoTipo;

    public Ingresso(double valor, String nomeFilme, IngressoTipo ingressoTipo) {
        this.valor = valor;
        this.nomeFilme = nomeFilme;
        this.ingressoTipo = ingressoTipo;
    }

    public abstract double calcularValor();

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public IngressoTipo getIngressoTipo() {
        return ingressoTipo;
    }

    public void setIngressoTipo(IngressoTipo ingressoTipo) {
        this.ingressoTipo = ingressoTipo;
    }
}
