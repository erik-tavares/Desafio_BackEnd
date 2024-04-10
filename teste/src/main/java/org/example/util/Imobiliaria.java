package org.example.util;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.example.model.Imovel;

import java.util.Scanner;

public class Imobiliaria {
    public Imobiliaria() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Imovel casa = new Imovel("Casa", 100.0, 200000.0, 5);
        Imovel apartamento = new Imovel("Apartamento", 80.0, 150000.0, 3);
        Imovel terreno = new Imovel("Terreno", 500.0, 100000.0, 0);
        System.out.println("Digite o tipo de imóvel que deseja visualizar (Casa, Apartamento ou Terreno):");
        String tipoImovel = scanner.nextLine();
        if (tipoImovel.equalsIgnoreCase("Casa")) {
            System.out.println(casa);
        } else if (tipoImovel.equalsIgnoreCase("Apartamento")) {
            System.out.println(apartamento);
        } else if (tipoImovel.equalsIgnoreCase("Terreno")) {
            System.out.println(terreno);
        } else {
            System.out.println("Tipo de imóvel inválido!");
        }

        scanner.close();
    }
}
