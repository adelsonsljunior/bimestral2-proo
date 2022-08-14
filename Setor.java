import java.util.ArrayList;
import java.util.Scanner;

public class Setor {

    // Atributos da classe Setor
    
    private String nome;
    private Pessoa responsavel;
    private ArrayList<Equipamento> equipamentos = new ArrayList<Equipamento>();

    private Scanner sc = new Scanner(System.in);
    private Scanner sc2 = new Scanner(System.in);

    // Construtores da classe Setor

    public Setor() {

        System.out.println("\n   -- Registre as Informações do Setor --");
        System.out.println("\nNome: ");
        this.nome = sc2.nextLine();
        responsavel = new Pessoa("Responsável");
    }

    // Métodos da classe Setor

    public void exibir() {
        System.out.println("\n   == Informações do Setor ==");
        System.out.println("\nNome: " + nome);
        responsavel.exibir("Responsável");
    }

    public void cadastrarEquipamento() {
        Equipamento equipamentoAux = new Equipamento();
        equipamentos.add(equipamentoAux);
    }

    public void usarEquipamento() {

        System.out.println("\nDigite o nome do equipamento que deseja usar: ");
        String nome = sc2.nextLine();

        for (int i = 0; i < equipamentos.size(); i++) {
            if (equipamentos.get(i).getNome().equalsIgnoreCase(nome)) {
                equipamentos.get(i).usar();
            }
        }
    }

    public void manutencaoEquipamento() {

        System.out.println("\nDigite o nome do equipamento que deseja mandar para manutenção: ");
        String nome = sc2.nextLine();

        for (int i = 0; i < equipamentos.size(); i++) {
            if (equipamentos.get(i).getNome().equalsIgnoreCase(nome)) {
                equipamentos.get(i).manutencao();
            }

        }
    }

    public void removerEquipamento() {

        System.out.println("\nDigite o nome do equipamento que deseja remover: ");
        String nome = sc2.nextLine();

        for (int i = 0; i < equipamentos.size(); i++) {
            if (equipamentos.get(i).getNome().equalsIgnoreCase(nome)) {
                equipamentos.remove(i);
            }
        }
    }

    // Métodos getters e setters da classe Setor

    public String getNome() {
        return nome;
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setEquipamentos(ArrayList<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

}
