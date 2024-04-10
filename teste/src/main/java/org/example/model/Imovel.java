package org.example.model;

import lombok.Data;

@Data
public class Imovel {
    private String tipo;
    private double area;
    private double valor;
    private int comodos;

    public Imovel(String tipo, double area, double valor, int comodos) {
        this.tipo = tipo;
        this.area = area;
        this.valor = valor;
        this.comodos = comodos;
    }

    @Override
    public String toString() {
        if (this.tipo.equals("Casa")) {
            return "Casa: area do imovel: " + this.area + " - Valor do imovel: R$" + this.valor + " - Comodos: " + this.comodos + " - area do Terreno: " + this.area;
        } else if (this.tipo.equals("Apartamento")) {
            return "Apartamento: area do imovel: " + this.area + " - Valor do imovel: R$" + this.valor + " - Comodos: " + this.comodos;
        } else {
            return this.tipo.equals("Terreno") ? "Terreno: area do imovel: " + this.area + " - Valor do imovel: R$" + this.valor : "Tipo de imovel invalido!";
        }
    }
}
