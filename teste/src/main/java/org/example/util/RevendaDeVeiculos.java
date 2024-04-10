package org.example.util;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
import org.example.model.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RevendaDeVeiculos {
    private List<Veiculo> veiculos = new ArrayList();

    public void revendaDeVeiculos() {
    }

    public void adicionarVeiculo(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public void excluirVeiculo(int indice) {
        this.veiculos.remove(indice);
    }

    public void editarVeiculo(int indice, Veiculo veiculoAtualizado) {
        this.veiculos.set(indice, veiculoAtualizado);
    }

    public void mostrarVeiculos() {
        for(int i = 0; i < this.veiculos.size(); ++i) {
            System.out.println("Veículo " + (i + 1) + ": " + String.valueOf(this.veiculos.get(i)));
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RevendaDeVeiculos revenda = new RevendaDeVeiculos();

        while(true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Adicionar veículo");
            System.out.println("2. Excluir veículo");
            System.out.println("3. Editar veículo");
            System.out.println("4. Mostrar veículos");
            System.out.println("5. Sair");
            int opcao = scanner.nextInt();
            String tipo;
            String marca;
            String modelo;
            int ano;
            double precoVenda;
            switch (opcao) {
                case 1:
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

                    try {
                        Veiculo novoVeiculo = new Veiculo(tipo, marca, modelo, ano, precoVenda);
                        revenda.adicionarVeiculo(novoVeiculo);
                    } catch (IllegalArgumentException var16) {
                        IllegalArgumentException e = var16;
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

                    try {
                        Veiculo veiculoEditado = new Veiculo(tipo, marca, modelo, ano, precoVenda);
                        revenda.editarVeiculo(indiceEdicao - 1, veiculoEditado);
                    } catch (IllegalArgumentException var15) {
                        IllegalArgumentException e = var15;
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
