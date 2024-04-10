import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Veiculo {
    private String tipo;
    private String marca;
    private String modelo;
    private int ano;
    private double precoVenda;

    public Veiculo(String tipo, String marca, String modelo, int ano, double precoVenda) {
        if (tipo.equalsIgnoreCase("carro") || tipo.equalsIgnoreCase("moto") || tipo.equalsIgnoreCase("caminhão")) {
            this.tipo = tipo;
        } else {
            throw new IllegalArgumentException("Tipo de veículo inválido!");
        }
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.precoVenda = precoVenda;
    }

    // Getters e Setters
    // ...

    @Override
    public String toString() {
        return "Tipo: " + tipo + ", Marca: " + marca + ", Modelo: " + modelo + ", Ano: " + ano + ", Preço de Venda: " + precoVenda;
    }
}

public class revendaDeVeiculos {
    private List<Veiculo> veiculos;

    public revendaDeVeiculos() {
        this.veiculos = new ArrayList<>();
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        veiculos.add(veiculo);
    }

    public void excluirVeiculo(int indice) {
        veiculos.remove(indice);
    }

    public void editarVeiculo(int indice, Veiculo veiculoAtualizado) {
        veiculos.set(indice, veiculoAtualizado);
    }

    public void mostrarVeiculos() {
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println("Veículo " + (i + 1) + ": " + veiculos.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        revendaDeVeiculos revenda = new revendaDeVeiculos();

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar veículo");
            System.out.println("2. Excluir veículo");
            System.out.println("3. Editar veículo");
            System.out.println("4. Mostrar veículos");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Digite o tipo do veículo (carro, moto ou caminhão):");
                    String tipo = scanner.next();
                    System.out.println("Digite a marca do veículo:");
                    String marca = scanner.next();
                    System.out.println("Digite o modelo do veículo:");
                    String modelo = scanner.next();
                    System.out.println("Digite o ano do veículo:");
                    int ano = scanner.nextInt();
                    System.out.println("Digite o preço de venda do veículo:");
                    double precoVenda = scanner.nextDouble();

                    Veiculo novoVeiculo;
                    try {
                        novoVeiculo = new Veiculo(tipo, marca, modelo, ano, precoVenda);
                        revenda.adicionarVeiculo(novoVeiculo);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Digite o índice do veículo que deseja excluir:");
                    int indiceExclusao = scanner.nextInt();
                    revenda.excluirVeiculo(indiceExclusao - 1);
                    break;

                case 3:
                    System.out.println("Digite o índice do veículo que deseja editar:");
                    int indiceEdicao = scanner.nextInt();
                    System.out.println("Digite o tipo do veículo (carro, moto ou caminhão):");
                    tipo = scanner.next();
                    System.out.println("Digite a marca do veículo:");
                    marca = scanner.next();
                    System.out.println("Digite o modelo do veículo:");
                    modelo = scanner.next();
                    System.out.println("Digite o ano do veículo:");
                    ano = scanner.nextInt();
                    System.out.println("Digite o preço de venda do veículo:");
                    precoVenda = scanner.nextDouble();

                    Veiculo veiculoEditado;
                    try {
                        veiculoEditado = new Veiculo(tipo, marca, modelo, ano, precoVenda);
                        revenda.editarVeiculo(indiceEdicao - 1, veiculoEditado);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 4:
                    revenda.mostrarVeiculos();
                    break;

                case 5:
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
