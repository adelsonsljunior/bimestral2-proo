import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    // Atributos da classe Menu

    private ArrayList<Setor> setores = new ArrayList<Setor>();

    private Scanner sc = new Scanner(System.in);
    private Scanner sc2 = new Scanner(System.in);

    // Construtores da classe Menu

    public Menu() {

        int opcao;

        do {

            System.out.println("\n***************************************************");
            System.out.println("                          MENU");
            System.out.println("***************************************************");
            System.out.println("1 - Cadastrar setor");
            System.out.println("2 - Cadastrar equipamento em um determinado setor");
            System.out.println("3 - Exibir setores");
            System.out.println("4 - Exibir equipamentos de um setor");
            System.out.println("5 - Usar equipamento de um setor");
            System.out.println("6 - Mandar equipamento para manutenção");
            System.out.println("7 - Remover equipamento de um setor");
            System.out.println("8 - Remover setor");
            System.out.println("9 - Encerrar");
            System.out.println("***************************************************");
            opcao = sc.nextInt();
            System.out.println("***************************************************\n");

            switch (opcao) {

                case 1:

                    cadastrarSetor();

                    break;

                case 2:

                    if (setores.isEmpty()) {
                        semSetores();
                    } else {
                        cadastarEquipamentoDoSetor();
                    }

                    break;

                case 3:

                    if (setores.isEmpty()) {
                        semSetores();
                    } else {
                        exibirSetores();
                    }

                    break;

                case 4:

                    if (setores.isEmpty()) {
                        semSetores();
                    } else {
                        exibirEquipamentosDoSetor();
                    }

                    break;

                case 5:

                    if (setores.isEmpty()) {
                        semSetores();
                    } else {
                        usarEquipamentoDoSetor();
                    }

                    break;

                case 6:

                    if (setores.isEmpty()) {
                        semSetores();
                    } else {
                        manutencaoEquipamentoDoSetor();
                    }

                    break;

                case 7:

                    if (setores.isEmpty()) {
                        semSetores();
                    } else {
                        removerEquipamentoDoSetor();
                    }

                    break;

                case 8:

                    if (setores.isEmpty()) {
                        semSetores();
                    } else {
                        removerSetor();
                    }

                    break;

                case 9:

                    System.out.println("Encerrando programa...");
                    break;

                default:

                    System.out.println("\n----------------------");
                    System.out.println("   Opção Inválida !");
                    System.out.println("----------------------\n");
                    break;
            }

        } while (opcao != 10);

    }

    // Métodos da classe Menu

    private void cadastrarSetor() {
        Setor setorAux = new Setor();
        setores.add(setorAux);
    }

    private void cadastarEquipamentoDoSetor() {

        System.out.println("\nDigite o nome do setor que deseja cadastrar o equipamento: ");
        String nome = sc2.nextLine();

        for (int i = 0; i < setores.size(); i++) {
            if (setores.get(i).getNome().equalsIgnoreCase(nome)) {
                setores.get(i).cadastrarEquipamento();
                break;
            }
        }
    }

    private void exibirSetores() {
        for (int i = 0; i < setores.size(); i++) {
            setores.get(i).exibir();
        }
    }

    private void exibirEquipamentosDoSetor() {
        System.out.println("\nDigite o nome do setor que deseja exibir: ");
        String nome = sc2.nextLine();

        for (int i = 0; i < setores.size(); i++) {
            if (setores.get(i).getNome().equalsIgnoreCase(nome)) {
                setores.get(i).exibir();

                System.out.println("\n   -- Equipamentos do Setor --\n");

                for (int j = 0; j < setores.get(i).getEquipamentos().size(); j++) {
                    setores.get(i).getEquipamentos().get(j).exibir();
                }
            }
        }
    }

    private void usarEquipamentoDoSetor() {
        System.out.println("\nDigite o nome do setor que deseja usar um equipamento: ");
        String nome = sc2.nextLine();

        for (int i = 0; i < setores.size(); i++) {
            if (setores.get(i).getNome().equalsIgnoreCase(nome)) {
                setores.get(i).usarEquipamento();
            }
        }
    }

    private void manutencaoEquipamentoDoSetor() {
        System.out.println("\nDigite o nome do setor que deseja mandar o equipamento para manutenção: ");
        String nome = sc2.nextLine();

        for (int i = 0; i < setores.size(); i++) {
            if (setores.get(i).getNome().equalsIgnoreCase(nome)) {
                setores.get(i).usarEquipamento();
            }
        }
    }

    private void removerEquipamentoDoSetor() {
        System.out.println("\nDigite o nome do setor que deseja remover o equipamento : ");
        String nome = sc2.nextLine();

        for (int i = 0; i < setores.size(); i++) {
            if (setores.get(i).getNome().equalsIgnoreCase(nome)) {
                setores.get(i).removerEquipamento();
                System.out.println("\n----------------------------------------------");
                System.out.println("   O equipamento foi removido com sucesso !");
                System.out.println("----------------------------------------------\n");
            }
        }
    }

    private void removerSetor() {

        if (setores.size() > 1) {
            System.out.println("\nDigite o nome do setor que deseja remover: ");
            String nome = sc2.nextLine();

            for (int i = 0; i < setores.size(); i++) {
                if (setores.get(i).getNome().equalsIgnoreCase(nome)) {

                    for (int j = 0; j < setores.get(i).getEquipamentos().size(); j++) {
                        Equipamento equipamentoAux = setores.get(i).getEquipamentos().get(j);

                        System.out.println("\nDigite o nome do setor para realocar o(s) equipamento(s):");
                        String nome2 = sc2.nextLine();

                        for (int k = 0; k < setores.size(); k++) {
                            if (setores.get(k).getNome().equalsIgnoreCase(nome2)) {
                                setores.get(k).getEquipamentos().add(equipamentoAux);
                                break;
                            }

                        }
                    }

                    setores.remove(i);
                    break;

                }
            }

        } else {
            System.out.println("\n---------------------------------------");
            System.out.println("   Só há um setor cadastrado !");
            System.out.println("   É impossível remover o único setor !");
            System.out.println("---------------------------------------\n");
        }
    }

    private void semSetores() {
        System.out.println("\n----------------------------------");
        System.out.println("   Não há setores cadastrados !");
        System.out.println("----------------------------------\n");
    }

}