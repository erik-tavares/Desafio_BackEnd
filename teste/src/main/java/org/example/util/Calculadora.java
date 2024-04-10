package org.example.util;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Scanner;

public class Calculadora {
    public Calculadora() {
    }

    public static double soma(double num1, double num2) {
        return num1 + num2;
    }

    public static double subtracao(double num1, double num2) {
        return num1 - num2;
    }

    public static double multiplicacao(double num1, double num2) {
        return num1 * num2;
    }

    public static double divisao(double num1, double num2) {
        if (num2 != 0.0) {
            return num1 / num2;
        } else {
            throw new IllegalArgumentException("Não é possível dividir por zero!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o primeiro número: ");
        double num1 = scanner.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = scanner.nextDouble();
        double resultadoSoma = soma(num1, num2);
        System.out.println("Soma: " + resultadoSoma);
        double resultadoSubtracao = subtracao(num1, num2);
        System.out.println("Subtração: " + resultadoSubtracao);
        double resultadoMultiplicacao = multiplicacao(num1, num2);
        System.out.println("Multiplicação: " + resultadoMultiplicacao);

        try {
            double resultadoDivisao = divisao(num1, num2);
            System.out.println("Divisão: " + resultadoDivisao);
        } catch (IllegalArgumentException var14) {
            IllegalArgumentException e = var14;
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
