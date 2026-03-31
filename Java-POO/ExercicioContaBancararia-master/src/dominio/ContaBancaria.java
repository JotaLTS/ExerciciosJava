package dominio;

public class ContaBancaria {
    private double saldo;
    private double chequeEspecial;
    private double chequeUsado;
    private boolean isChequeEspecialUso;


    private static final double SALDO_LIMITE = 500;
    private static final double CHEQUE_MINIMO = 50;
    private static final double DIVISOR_CHEQUE = 2;

    public ContaBancaria(double saldo){
        this.saldo = saldo;
        if(this.saldo <= SALDO_LIMITE){
            this.chequeEspecial = CHEQUE_MINIMO;
        }else{
            this.chequeEspecial = this.saldo/DIVISOR_CHEQUE;
        }
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositarDinheiro(double valorDeposito){
        if(valorDeposito <= 0) {
            System.out.println("Não é possível depositar valores menores ou iguais a zero");
            return;
        }
        if(chequeUsado > 0){
            if(valorDeposito >= chequeUsado){
                double taxa = chequeUsado * 0.20;
                valorDeposito -= taxa;
                chequeUsado = 0;
            }else {
                System.out.println("Não pode depositar até o valor ser mairo que " + chequeUsado);
                return;
            }
        }
        this.saldo += valorDeposito;
        atualizarChequeEspecialUso();
    }

    public void sacarDinheiro(double valorSaque){
        if(!valorEhValido(valorSaque,this.saldo)){
            System.out.println("Não foi possível sacar, verefique seu saldo e/ou o valor do saque");
            return;
        }
        this.saldo -= valorSaque;
        atualizarChequeEspecialUso();
    }

    public void pagarBoleto(double valorBoleto){
        if(!valorEhValido(valorBoleto,this.saldo)){
            System.out.println("Não foi possível pagar o boleto, verefique seu saldo e/ou o valor do boleto");
            return;
        }
        this.saldo -= valorBoleto;
        atualizarChequeEspecialUso();
    }

    public void pagarBoletoCheque(double valorBoleto){
        if(!valorEhValido(valorBoleto,this.chequeEspecial)){
            System.out.println("Não foi possível pagar o boleto, verefique o saldo do seu cheque e/ou o valor do boleto");
            return;
        }
        this.chequeEspecial -= valorBoleto;
        chequeUsado += valorBoleto;
    }

    private boolean valorEhValido(double valor, double saldoDisponivel) {
        return !(valor > saldoDisponivel || valor <= 0);
    }
    private void atualizarChequeEspecialUso(){
        if(this.saldo == 0) {
            setChequeEspecialUso(true);
            return;
        }
        setChequeEspecialUso(false);
    }

    private void setChequeEspecialUso(boolean isChequeEspecialUso){
        this.isChequeEspecialUso = isChequeEspecialUso;
    }

    public boolean getIsChequeEspecialUso() {
        return isChequeEspecialUso;
    }
}
