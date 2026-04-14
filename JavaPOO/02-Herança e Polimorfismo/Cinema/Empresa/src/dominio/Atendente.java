package dominio;

public class Atendente extends Funcionario{
    private double valorEmCaixa;
    private static final double SALDO_INICIAL = 100;
    private static final double SANGRIA = 300;
    public Atendente(String nome, String senha, String email) {
        super(nome, false, senha, email);
    }


    public void receberPagamento(double valor){
        this.valorEmCaixa += valor;
    }

    public double fecharCaixa(){
        return SALDO_INICIAL + this.valorEmCaixa - SANGRIA;
    }

    public double getValorEmCaixa() {
        return valorEmCaixa;
    }
}
