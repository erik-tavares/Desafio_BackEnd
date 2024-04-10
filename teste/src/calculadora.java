import java.util.Scanner;

public class calculadora {

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
        if (num2 != 0) {
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

        // Operação de soma
        double resultadoSoma = soma(num1, num2);
        System.out.println("Soma: " + resultadoSoma);

        // Operação de subtração
        double resultadoSubtracao = subtracao(num1, num2);
        System.out.println("Subtração: " + resultadoSubtracao);

        // Operação de multiplicação
        double resultadoMultiplicacao = multiplicacao(num1, num2);
        System.out.println("Multiplicação: " + resultadoMultiplicacao);

        // Operação de divisão
        try {
            double resultadoDivisao = divisao(num1, num2);
            System.out.println("Divisão: " + resultadoDivisao);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}