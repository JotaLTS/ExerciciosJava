package dominio;

public class MaquinaDeBanho {
    private double agua;
    private double shampoo;
    private Pet pet;
    private boolean estaMaquinaLimpa;

    private static final double AGUA_BANHO = 10;
    private static final double AGUA_MAXIMA = 30;
    private static final double AGUA_LIMPEZA = 3;
    private static final double SHAMPOO_BANHO = 2;
    private static final double SHAMPOO_MAXIMO = 10;
    private static final double SHAMPOO_LIMPEZA = 1;
    private static final double ABASTECIMENTO = 2;

    public MaquinaDeBanho() {
        this.agua = AGUA_MAXIMA;
        this.shampoo = SHAMPOO_MAXIMO;
        this.estaMaquinaLimpa = true;
        this.pet = null;
    }

    public void darBanhoPet(){
        this.agua -= AGUA_BANHO;
        this.shampoo -= SHAMPOO_BANHO;
        pet.setEstaPetLimpo(true);
        this.estaMaquinaLimpa = false;
    }

    public void limparMaquina(){
        this.agua -= AGUA_LIMPEZA;
        this.shampoo -= SHAMPOO_LIMPEZA;
        this.estaMaquinaLimpa = true;
    }
    public double getAgua() {
        return agua;
    }

    public void abastecerAgua() {
        if(this.agua >= 29) {
            System.out.println("Não é possivel abastecer com agua, tank cheio");
            return;
        }
        this.agua += ABASTECIMENTO;

    }

    public double getShampoo() {
        return shampoo;
    }

    public void abastecerShampoo() {
        if(this.shampoo >= 9){
            System.out.println("Não é possível abastecer com shampoo, tank cheio");
            return;
        }
        this.shampoo += ABASTECIMENTO;
    }

    public boolean isEstaMaquinaLimpa() {
        return estaMaquinaLimpa;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
