import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Item {
    private String nome;
    private int quantidade;

    public Item(String nome, int quantidade) {
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int novaQuantidade) {
        quantidade = novaQuantidade;
    }
}

class Estoque {
    private Map<String, Item> itens;

    public Estoque() {
        itens = new HashMap<>();
    }

    public void adicionarItem(String nome, int quantidade) {
        if (itens.containsKey(nome)) {
            Item item = itens.get(nome);
            item.setQuantidade(item.getQuantidade() + quantidade);
        } else {
            Item novoItem = new Item(nome, quantidade);
            itens.put(nome, novoItem);
        }
    }

    public void removerItem(String nome, int quantidade) {
        if (itens.containsKey(nome)) {
            Item item = itens.get(nome);
            if (item.getQuantidade() >= quantidade) {
                item.setQuantidade(item.getQuantidade() - quantidade);
                if (item.getQuantidade() == 0) {
                    itens.remove(nome);
                }
            } else {
                System.out.println("Quantidade insuficiente para remover.");
            }
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
    }

    public void listarItens() {
        System.out.println("Itens no estoque:");
        for (Item item : itens.values()) {
            System.out.println(item.getNome() + ": " + item.getQuantidade());
        }
    }

    public void atualizarQuantidade(String nome, int novaQuantidade) {
        if (itens.containsKey(nome)) {
            Item item = itens.get(nome);
            item.setQuantidade(novaQuantidade);
        } else {
            System.out.println("Item não encontrado no estoque.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Estoque estoque = new Estoque();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Adicionar item");
            System.out.println("2. Remover item");
            System.out.println("3. Listar itens");
            System.out.println("4. Atualizar quantidade");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                    System.out.print("Nome do item: ");
                    String nome = scanner.next();
                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();
                    estoque.adicionarItem(nome, quantidade);
                    System.out.println("Item adicionado ao estoque.");
                    break;
                case 2:
                    System.out.print("Nome do item: ");
                    nome = scanner.next();
                    System.out.print("Quantidade: ");
                    quantidade = scanner.nextInt();
                    estoque.removerItem(nome, quantidade);
                    System.out.println("Item removido do estoque.");
                    break;
                case 3:
                    estoque.listarItens();
                    break;
                case 4:
                    System.out.print("Nome do item: ");
                    nome = scanner.next();
                    System.out.print("Nova quantidade: ");
                    int novaQuantidade = scanner.nextInt();
                    estoque.atualizarQuantidade(nome, novaQuantidade);
                    System.out.println("Quantidade atualizada.");
                    break;
                case 5:
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opção inválida. Escolha uma opção válida do menu.");
                    break;
            }
        }
    }
}
