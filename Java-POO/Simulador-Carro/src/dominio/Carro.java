package dominio;

public class Carro {
    private boolean isCarroLigado = false;
    private double velocidade = 0;
    private int marcha = 0;

    private static final double VELOCIDADE_MAXIMA = 120;
    private static final int MARCHA_MAXIMA = 6;

    public int getMarcha() {
        return marcha;
    }

    public void setMarcha(int marcha) {
        this.marcha = marcha;
    }

    public boolean getisCarroLigado() {
        return isCarroLigado;
    }

    public void setisCarroLigado(boolean carroLigado) {
        isCarroLigado = carroLigado;
    }

    public double getVelocidade() {
        return velocidade;
    }

    public void acelerar(){
        if(this.velocidade <= VELOCIDADE_MAXIMA) this.velocidade += 1;
    }

    public void desacelerar(){
        if(this.velocidade > 0) this.velocidade -= 1;
    }

    public void aumentarMarcha(){
        if(this.marcha <= MARCHA_MAXIMA) this.marcha += 1;
    }

    public void diminuirMarcha(){
        if(this.marcha > 0) this.marcha -= 1;
    }
}
