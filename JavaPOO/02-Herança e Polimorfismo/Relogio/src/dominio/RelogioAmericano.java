package dominio;

public class RelogioAmericano extends RelogioGlobal{

    public RelogioAmericano(int hora, int minuto, int segundo) {
        super(hora, minuto,segundo);
    }

    @Override
    public void conversorHora(RelogioGlobal outroRelogio) {
        if(outroRelogio.getHora() == 0){
            setHora(12);
            setMinuto(outroRelogio.getMinuto());
            setSegundo(outroRelogio.getSegundo());
            return;
        }
        if(outroRelogio.getHora() > 12){
            int horaConvertida = outroRelogio.getHora() - 12;
            setHora(horaConvertida);
            setMinuto(outroRelogio.getMinuto());
            setSegundo(outroRelogio.getSegundo());
            return;
        }
        int horaConvertida = outroRelogio.getHora();
        setHora(horaConvertida);
        setMinuto(outroRelogio.getMinuto());
        setSegundo(outroRelogio.getSegundo());
    }

    @Override
    public boolean validarHora(int hora) {
        return hora >= 1 && hora <=12;
    }
}
