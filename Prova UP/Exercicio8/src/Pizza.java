import java.util.ArrayList;
import java.util.Scanner;

class Pizza {
    private String nome;
    private double valor;
    private String ingredientes;

    public Pizza(String nome, double valor, String ingredientes) {
        this.nome = nome;
        this.valor = valor;
        this.ingredientes = ingredientes;
    }

    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return nome + " - R$" + valor;
    }
}

class Pedido {
    private ArrayList<Pizza> pizzas;
    private String tamanho;
    private double valorTotal;
    private String enderecoEntrega;

    public Pedido() {
        this.pizzas = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public void adicionarPizza(Pizza pizza) {
        pizzas.add(pizza);
        valorTotal += pizza.getValor();
    }

    public void cancelarPedido() {
        pizzas.clear();
        valorTotal = 0.0;
    }

    public double calcularMediaPreco() {
        if (pizzas.size() == 0) return 0.0;
        return valorTotal / pizzas.size();
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public void exibirDetalhes() {
        System.out.println("Pedido:");
        for (Pizza pizza : pizzas) {
            System.out.println("- " + pizza.getNome() + " - R$" + pizza.getValor());
        }
        System.out.println("Tamanho: " + tamanho);
        System.out.println("Valor total: R$" + valorTotal);
        System.out.println("Endereço de entrega: " + enderecoEntrega);
    }
}
