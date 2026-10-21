import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Bilheteria bilheteria = new Bilheteria();
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n===== BILHETERIA =====");
            System.out.println("1 - Cadastrar ingresso");
            System.out.println("2 - Remover ingresso");
            System.out.println("3 - Buscar ingresso por codigo");
            System.out.println("4 - Listar todos os ingressos");
            System.out.println("5 - Calcular arrecadacao total");
            System.out.println("6 - Listar beneficios dos ingressos");
            System.out.println("7 - Finalizar");
            System.out.print("Escolha uma opcao: ");
            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarIngresso(input, bilheteria);
                    break;
                case 2:
                    removerIngresso(input, bilheteria);
                    break;
                case 3:
                    buscarIngresso(input, bilheteria);
                    break;
                case 4:
                    bilheteria.listarIngressos();
                    break;
                case 5:
                    System.out.printf("Arrecadacao total: R$ %.2f%n", bilheteria.calcularArrecadacaoTotal());
                    break;
                case 6:
                    bilheteria.listarBeneficios();
                    break;
                case 7:
                    continuar = false;
                    System.out.println("Bilheteria finalizada.");
                    break;
                default:
                    System.out.println("Opcao invalida.");
            }
        }

        input.close();
    }

    private static void cadastrarIngresso(Scanner input, Bilheteria bilheteria) {
        System.out.println("\n--- Tipo de ingresso ---");
        System.out.println("1 - Comum");
        System.out.println("2 - Estudante");
        System.out.println("3 - VIP");
        System.out.print("Escolha o tipo: ");
        int tipo = input.nextInt();
        input.nextLine();

        if (tipo < 1 || tipo > 3) {
            System.out.println("Tipo invalido.");
            return;
        }

        System.out.print("Codigo: ");
        int codigo = input.nextInt();
        input.nextLine();

        if (bilheteria.buscarIngresso(codigo) != null) {
            System.out.println("Ja existe um ingresso com esse codigo.");
            return;
        }

        System.out.print("Nome do evento: ");
        String nomeEvento = input.nextLine();
        System.out.print("Setor: ");
        String setor = input.nextLine();
        System.out.print("Valor base: ");
        double valorBase = Double.parseDouble(input.nextLine().replace(",", "."));

        if (valorBase < 0) {
            System.out.println("Valor invalido.");
            return;
        }

        Ingresso ingresso;

        if (tipo == 1) {
            ingresso = new IngressoComum(codigo, nomeEvento, setor, valorBase);
        } else if (tipo == 2) {
            System.out.print("Instituicao de ensino: ");
            String instituicaoEnsino = input.nextLine();
            ingresso = new IngressoEstudante(codigo, nomeEvento, setor, valorBase, instituicaoEnsino);
        } else {
            System.out.print("Possui acesso ao backstage? (s/n): ");
            boolean acessoBackstage = input.nextLine().equalsIgnoreCase("s");
            System.out.print("Numero do lounge: ");
            int numeroLounge = input.nextInt();
            input.nextLine();
            ingresso = new IngressoVIP(codigo, nomeEvento, setor, valorBase, acessoBackstage, numeroLounge);
        }

        bilheteria.adicionarIngresso(ingresso);
        System.out.println("Ingresso cadastrado.");
    }

    private static void removerIngresso(Scanner input, Bilheteria bilheteria) {
        System.out.print("Codigo do ingresso a remover: ");
        int codigo = input.nextInt();
        input.nextLine();

        if (bilheteria.removerIngresso(codigo)) {
            System.out.println("Ingresso removido.");
        } else {
            System.out.println("Ingresso nao encontrado.");
        }
    }

    private static void buscarIngresso(Scanner input, Bilheteria bilheteria) {
        System.out.print("Codigo do ingresso: ");
        int codigo = input.nextInt();
        input.nextLine();

        Ingresso ingresso = bilheteria.buscarIngresso(codigo);
        if (ingresso == null) {
            System.out.println("Ingresso nao encontrado.");
        } else {
            ingresso.exibirInformacoes();
            System.out.println("Beneficios: " + ingresso.obterBeneficios());
        }
    }
}
