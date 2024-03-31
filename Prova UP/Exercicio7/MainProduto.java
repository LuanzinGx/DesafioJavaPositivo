import java.util.Scanner;

public class MainProduto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Produto[] produtos = new Produto[100]; // Capacidade inicial do estoque
        int numProdutos = 0;

        boolean executando = true;
        while (executando) {
            System.out.println("\n-- Menu do Mercado --");
            System.out.println("1. Adicionar Produto");
            System.out.println("2. Atualizar Produto");
            System.out.println("3. Remover Produto");
            System.out.println("4. Exibir Relatório de Estoque");
            System.out.println("5. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();
                    System.out.print("Código do produto: ");
                    int codigo = scanner.nextInt();
                    System.out.print("Quantidade em estoque: ");
                    int quantidade = scanner.nextInt();
                    System.out.print("Preço do produto: ");
                    double preco = scanner.nextDouble();
                    produtos[numProdutos++] = new Produto(nome, codigo, quantidade, preco);
                    break;
                case 2:
                    System.out.print("Digite o código do produto a ser atualizado: ");
                    int codigoAtualizar = scanner.nextInt();
                    for (int i = 0; i < numProdutos; i++) {
                        if (produtos[i].getCodigo() == codigoAtualizar) {
                            System.out.print("Novo nome: ");
                            produtos[i].setNome(scanner.next());
                            System.out.print("Nova quantidade em estoque: ");
                            produtos[i].setQuantidade(scanner.nextInt());
                            System.out.print("Novo preço: ");
                            produtos[i].setPreco(scanner.nextDouble());
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.print("Digite o código do produto a ser removido: ");
                    int codigoRemover = scanner.nextInt();
                    for (int i = 0; i < numProdutos; i++) {
                        if (produtos[i].getCodigo() == codigoRemover) {
                            for (int j = i; j < numProdutos - 1; j++) {
                                produtos[j] = produtos[j + 1];
                            }
                            numProdutos--;
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("-- Relatório de Estoque --");
                    for (int i = 0; i < numProdutos; i++) {
                        System.out.println(produtos[i]);
                    }
                    break;
                case 5:
                    System.out.println("Saindo do sistema...");
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }
        scanner.close();
    }
}
