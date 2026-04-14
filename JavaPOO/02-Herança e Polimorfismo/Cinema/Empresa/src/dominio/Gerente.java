package dominio;

public class Gerente extends Funcionario{

    public Gerente(String nome, String senha, String email) {
        super(nome, true,senha, email);
    }

    public void gerarRelatorioFinanceiro(Vendedor vendedor,Atendente atendente){
        System.out.println("------------------------------------------");
        System.out.println("Total de vendas: "+ vendedor.getVendas());
        System.out.println("Valor em caixa: "+ atendente.getValorEmCaixa());
        System.out.println("------------------------------------------");
    }

    public void consultarVendas(Vendedor vendedor){
        System.out.println("Total de vendasd: " + vendedor.getVendas());
    }

}
