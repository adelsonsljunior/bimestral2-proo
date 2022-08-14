import java.util.Scanner;

public class Equipamento {

    // Atributos da classe Equipamento

    private String nome;
    private String descricao;
    private int quantidade;
    private Pessoa fabricante;
    private boolean status; // status de funcionamento (true: funcionando / false: necessária manutenção)

    private int contUsado; // número de vezes que o equipamento foi usado antes da manutenção
    private int contManutencao; // número de vezes que o equipamento foi para manutenção

    // Construtores da classe Equipamento

    public Equipamento() {

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("\n   -- Registre as Informações do Equipamento -- ");
        System.out.println("\nNome: ");
        nome = sc.nextLine();
        System.out.println("\nDescrição: ");
        descricao = sc.nextLine();
        System.out.println("\nQuantidade: ");
        quantidade = sc2.nextInt();
        fabricante = new Pessoa("Fabricante");

        status = true;
        contUsado = 0;
        contManutencao = 0;

    }

    // Métodos da classe Equipamento

    public void exibir() {
        System.out.println("\n   -- Informações do Equipamento --");
        System.out.println("\nNome: " + nome);
        System.out.println("\nDescrição: " + descricao);
        System.out.println("\nQuantidade: " + quantidade);
        fabricante.exibir("Fabricante");
    }

    public void usar() {
        if (contUsado < 5) {
            contUsado++;

            System.out.println("\n-------------------------------");
            System.out.println("   O equipamento foi usado !");
            System.out.println("-------------------------------\n");

        } else {
            status = false;

            System.out.println("\n-----------------------------------------------");
            System.out.println("   O equipamento precisa ir para manutenção !");
            System.out.println("-----------------------------------------------\n");

        }
    }

    public void manutencao() {
        if (status == false) {
            if (contManutencao < 5) {
                contUsado = 0;
                contManutencao++;

                System.out.println("\n------------------------------------");
                System.out.println("   O equipamento foi concertado !");
                System.out.println("------------------------------------\n");

            } else {

                System.out.println("\n-----------------------------------------------");
                System.out.println("   O equipe atingiu o limite de manutenção ! ");
                System.out.println("   Remova-o do setor !");
                System.out.println("-----------------------------------------------\n");

            }

        } else {

            System.out.println("\n-----------------------------------------------");
            System.out.println("   O equipamento não precisa de manutenção !");
            System.out.println("-----------------------------------------------\n");

        }
    }

    // Métodos getters e setters da classe Equipamento

    public String getNome() {
        return nome;
    }

}
