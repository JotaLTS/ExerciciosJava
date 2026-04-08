package dominio;

public class Pet {
    private boolean estaPetLimpo;
    private String nome;


    public Pet(String nome, boolean estaPetLimpo) {
        this.nome = nome;
        this.estaPetLimpo = estaPetLimpo;
    }

    public boolean isEstaPetLimpo() {
        return estaPetLimpo;
    }

    public void setEstaPetLimpo(boolean estaPetLimpo) {
        this.estaPetLimpo = estaPetLimpo;
    }

    @Override
    public String toString() {
        return "Pet: " + this.nome + " | Limpo: " + this.estaPetLimpo;
    }
}
