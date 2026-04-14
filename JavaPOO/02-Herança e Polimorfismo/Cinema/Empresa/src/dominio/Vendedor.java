package dominio;

public class Vendedor extends Funcionario{
    private int vendas;

    public Vendedor(String nome, String senha, String email) {
        super(nome,false, senha, email);
    }

    public void realizarVenda(){
        this.vendas +=1;
    }

    public void consultarVenda(){
        System.out.println("O numero de vendas é: "+this.vendas);
    }

    public int getVendas() {
        return vendas;
    }
}
