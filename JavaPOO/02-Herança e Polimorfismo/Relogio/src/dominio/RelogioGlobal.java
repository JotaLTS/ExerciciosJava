package dominio;

public abstract class RelogioGlobal {
    private int hora;
    private int minuto;
    private int segundo;

    public RelogioGlobal(int hora, int minuto, int segundo) {
        setHora(hora);
        setMinuto(minuto);
        setSegundo(segundo);
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        if(validarHora(hora)){
            this.hora = hora;
            return;
        }
        System.out.println("ERRO");
    }

    public int getMinuto() {
        return minuto;
    }

    public void setMinuto(int minuto) {
        if(validarMinuto(minuto)){
            this.minuto = minuto;
            return;
        }
        System.out.println("Erro");
    }

    public int getSegundo() {
        return segundo;
    }

    public void setSegundo(int segundo) {
        if(validarSegundo(segundo)){
            this.segundo = segundo;
            return;
        }
        System.out.println("Erro");
    }

    public abstract void conversorHora(RelogioGlobal relogioGlobal);

    public String retornarHora(){
        return String.format("%02d:%02d:%02d", getHora(), getMinuto(), getSegundo());
    }

    public abstract boolean validarHora(int hora);

    public boolean validarMinuto(int minuto){
        return minuto >=0 && minuto <=59;
    }
    public boolean validarSegundo(int segundo){
        return segundo >=0 && segundo <=59;
    }
}
