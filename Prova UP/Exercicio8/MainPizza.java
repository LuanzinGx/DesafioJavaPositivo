public class MainPizza {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        ArrayList<Pizza> pizzas = new ArrayList<>();
        pizzas.add(new Pizza("Margherita", 25.0, "Molho de tomate, muçarela e manjericão"));
        pizzas.add(new Pizza("Calabresa", 30.0, "Molho de tomate, muçarela e calabresa"));
        pizzas.add(new Pizza("Frango com Catupiry", 35.0, "Molho de tomate, muçarela, frango desfiado e catupiry"));


        Pedido pedido = new Pedido();

        boolean continuando = true;
        while (continuando) {
            System.out.println("\n--- Menu Pizzaria ---");
            System.out.println("1. Adicionar pizza ao pedido");
            System.out.println("2. Cancelar pedido");
            System.out.println("3. Exibir detalhes do pedido");
            System.out.println("4. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Pizzas Disponíveis ---");
                    for (int i = 0; i < pizzas.size(); i++) {
                        System.out.println((i + 1) + ". " + pizzas.get(i));
                    }
                    System.out.print("Escolha o número da pizza desejada: ");
                    int escolha = scanner.nextInt();
                    scanner.nextLine(); 

                    if (escolha >= 1 && escolha <= pizzas.size()) {
                        Pizza pizzaEscolhida = pizzas.get(escolha - 1);
                        pedido.adicionarPizza(pizzaEscolhida);

                        System.out.println("Pizza " + pizzaEscolhida.getNome() + " adicionada ao pedido.");
                    } else {
                        System.out.println("Opção inválida!");
                    }
                    break;
                case 2:
                    pedido.cancelarPedido();
                    System.out.println("Pedido cancelado com sucesso!");
                    break;
                case 3:
                    pedido.exibirDetalhes();
                    System.out.println("Média de preço das pizzas: R$" + pedido.calcularMediaPreco());
                    break;
                case 4:
                    continuando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }

        scanner.close();
    }
}