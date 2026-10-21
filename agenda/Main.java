import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Agenda agenda = new Agenda();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n===== AGENDA =====");
            System.out.println("1 - Adicionar contato");
            System.out.println("2 - Remover contato");
            System.out.println("3 - Buscar contato por nome");
            System.out.println("4 - Buscar contato por email");
            System.out.println("5 - Buscar contato por telefone");
            System.out.println("6 - Consultar tamanho da agenda");
            System.out.println("7 - Finalizar");
            System.out.print("Escolha uma opcao: ");
            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    adicionarContato(input, agenda);
                    break;
                case 2:
                    removerContato(input, agenda);
                    break;
                case 3:
                    System.out.print("Nome: ");
                    exibirResultado(agenda.buscarPorNome(input.nextLine()));
                    break;
                case 4:
                    System.out.print("Email: ");
                    exibirResultado(agenda.buscarPorEmail(input.nextLine()));
                    break;
                case 5:
                    System.out.print("Telefone: ");
                    exibirResultado(agenda.buscarPorTelefone(input.nextLine()));
                    break;
                case 6:
                    if (agenda.getQuantidadeContatos() == 0) {
                        System.out.println("A agenda esta vazia.");
                    } else {
                        System.out.println("A agenda possui " + agenda.getQuantidadeContatos() + " contato(s).");
                    }
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Agenda finalizada.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }

        input.close();
    }

    private static void adicionarContato(Scanner input, Agenda agenda) {
        System.out.println("\n--- Tipo de contato ---");
        System.out.println("1 - Pessoal");
        System.out.println("2 - Profissional");
        System.out.println("3 - Emergencia");
        System.out.print("Escolha o tipo: ");
        int tipo = input.nextInt();
        input.nextLine();

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo invalido.");
            return;
        }

        System.out.print("Nome: ");
        String nome = input.nextLine();
        System.out.print("Email: ");
        String email = input.nextLine();
        System.out.print("Telefone: ");
        String telefone = input.nextLine();

        Contato contato;

        if (tipo == 1) {
            System.out.print("Data de aniversario (dd/mm/aaaa): ");
            String dataAniversario = input.nextLine();
            System.out.print("Parentesco: ");
            String parentesco = input.nextLine();
            contato = new ContatoPessoal(nome, email, telefone, dataAniversario, parentesco);
        } else if (tipo == 2) {
            System.out.print("Empresa: ");
            String empresa = input.nextLine();
            System.out.print("Cargo: ");
            String cargo = input.nextLine();
            contato = new ContatoProfissional(nome, email, telefone, empresa, cargo);
        } else {
            System.out.print("Grau de prioridade (1 a 5): ");
            int grauPrioridade = input.nextInt();
            input.nextLine();
            if (grauPrioridade < 1 || grauPrioridade > 5) {
                System.out.println("Prioridade invalida.");
                return;
            }
            System.out.print("Observacao: ");
            String observacao = input.nextLine();
            contato = new ContatoEmergencia(nome, email, telefone, grauPrioridade, observacao);
        }

        agenda.adicionarContato(contato);
        System.out.println("Contato adicionado.");
    }

    private static void removerContato(Scanner input, Agenda agenda) {
        System.out.print("Nome do contato a remover: ");
        String nome = input.nextLine();

        if (agenda.removerContato(nome)) {
            System.out.println("Contato removido.");
        } else {
            System.out.println("Contato nao encontrado.");
        }
    }

    private static void exibirResultado(Contato contato) {
        if (contato == null) {
            System.out.println("Contato nao encontrado.");
        } else {
            contato.exibirDados();
        }
    }
}
