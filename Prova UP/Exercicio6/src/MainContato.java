import java.util.Scanner;

public class MainContato {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);
        Agenda agenda = new Agenda();

        boolean executando = true;
        while (executando) {
            System.out.println("\n-- Menu Agenda --");
            System.out.println("1. Adicionar contato");
            System.out.println("2. Remover contato");
            System.out.println("3. Buscar contato");
            System.out.println("4. Exibir contatos");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int escolha = leitor.nextInt();
            leitor.nextLine(); 

            switch (escolha) {
                case 1:
                    System.out.print("Digite o nome do contato: ");
                    String nome = leitor.nextLine();
                    System.out.print("Digite o telefone do contato: ");
                    String telefone = leitor.nextLine();
                    agenda.adicionarContato(new Contato(nome, telefone));
                    break;
                case 2:
                    System.out.print("Digite o nome do contato que deseja remover: ");
                    String nomeRemover = leitor.nextLine();
                    agenda.removerContato(nomeRemover);
                    break;
                case 3:
                    System.out.print("Digite o nome do contato que deseja buscar: ");
                    String nomeBuscar = leitor.nextLine();
                    agenda.buscarContato(nomeBuscar);
                    break;
                case 4:
                    agenda.exibirContatos();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }
        leitor.close();
    }
}