import java.util.Scanner;

public class Pessoa {

    /*
     * Classe Pessoa está representando
     * tanto uma pessoa física --> Responsável
     * quanto uma pessoa jurídica --> Empresa / Fabricante
     */

    // Atributos da classe Pessoa

    private String nome;
    private String telefone;

    // Construtores da classe Pessoa

    public Pessoa(String nome) {

        Scanner sc = new Scanner(System.in);

        System.out.println("\n   -- Registre as Informações do " + nome + " --");
        System.out.println("\nNome: ");
        this.nome = sc.nextLine();
        System.out.println("\nTelefone: ");
        telefone = sc.nextLine();
    }

    // Métodos da classe Pessoa

    public void exibir(String nome) {
        System.out.println("\n   -- Informações do " + nome +"--");
        System.out.println("\nNome: " + this.nome);
        System.out.println("\nTelefone: " + telefone);
    }

}