package dominio;

public class RelogioBrasileiro extends RelogioGlobal{

    public RelogioBrasileiro(int hora,int minuto,int segundo) {
        super(hora, minuto,segundo);
    }

    @Override
    public void conversorHora(RelogioGlobal outroRelogio) {
        if(outroRelogio.getHora() >= 12){
            setHora(0);
            setMinuto(outroRelogio.getMinuto());
            setSegundo(outroRelogio.getSegundo());
            return;
        }
        int horaInvertida = outroRelogio.getHora() + 12;
        setHora(horaInvertida);
        setMinuto(outroRelogio.getMinuto());
        setSegundo(outroRelogio.getSegundo());
    }

    @Override
    public boolean validarHora(int hora) {
        return hora >= 0 && hora <= 23;
    }
}
