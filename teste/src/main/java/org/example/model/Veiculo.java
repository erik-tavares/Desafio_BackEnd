package org.example.model;

import lombok.Data;

@Data
public class Veiculo {
    private String tipo;
    private String marca;
    private String modelo;
    private int ano;
    private double precoVenda;

    public Veiculo(String tipo, String marca, String modelo, int ano, double precoVenda) {
        if (!tipo.equalsIgnoreCase("carro") && !tipo.equalsIgnoreCase("moto") && !tipo.equalsIgnoreCase("caminhão")) {
            throw new IllegalArgumentException("Tipo de veículo inválido!");
        } else {
            this.tipo = tipo;
            this.marca = marca;
            this.modelo = modelo;
            this.ano = ano;
            this.precoVenda = precoVenda;
        }
    }
}
