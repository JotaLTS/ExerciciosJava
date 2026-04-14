package dominio;

import java.util.Scanner;
public abstract class Funcionario {
    private String nome;
    private String email;
    private String senha;
    private final boolean isAdministrador;

    public Funcionario(String nome, boolean isAdministrador, String senha, String email) {
        this.nome = nome;
        this.isAdministrador = isAdministrador;
        this.senha = senha;
        this.email = email;
    }

    public void realizarLogin(Scanner sc) {
        System.out.print("Digite o nome cadastrado: ");
        String testeNome = sc.nextLine();
        System.out.print("Digite o email cadastrado: ");
        String testeEmail = sc.nextLine();
        System.out.print("Digite a senha cadastrada: ");
        String testeSenha = sc.nextLine();

        if(testeNome.equals(this.nome) && testeEmail.equals(this.email) && testeSenha.equals(this.senha)){
            System.out.println("Login realizado com sucesso");
            return;
        }
        System.out.println("ERRO, LOGIN INCORRETO");
    }

    public void realizarLogoff() {
        System.out.println("Logoff realizado com sucesso");
    }

    public void alterarDados(Scanner sc) {
        System.out.println("Digite sua senha antes de alterar seus dados: ");
        String testeSenha = sc.nextLine();
        if(testeSenha.equals(this.senha)){
            System.out.print("Qual será seu novo nome: ");
            this.nome = sc.nextLine();
            System.out.print("Qual será seu novo email: ");
            this.email = sc.nextLine();
            return;
        }
        System.out.println("Senha incorreta");
    }

    public void alteraSenha(Scanner sc) {
        System.out.println("Digite sua senha antes de alterar seus dados: ");
        String testeSenha = sc.nextLine();
        if(testeSenha.equals(this.senha)){
            System.out.println("Qual será sua nova senha: ");
            this.senha = sc.nextLine();
        }
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "nome='" + nome;
    }
}
