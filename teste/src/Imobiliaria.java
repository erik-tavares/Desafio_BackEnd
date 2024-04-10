import java.util.Scanner;

class Imovel {
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

    public String getTipo() {
        return tipo;
    }

    public double getArea() {
        return area;
    }

    public double getValor() {
        return valor;
    }

    public int getComodos() {
        return comodos;
    }

    @Override
    public String toString() {
        if (tipo.equals("Casa")) {
            return "Casa: Área do imóvel: " + area + " - Valor do imóvel: R$" + valor + " - Cômodos: " + comodos + " - Área do Terreno: " + area;
        } else if (tipo.equals("Apartamento")) {
            return "Apartamento: Área do imóvel: " + area + " - Valor do imóvel: R$" + valor + " - Cômodos: " + comodos;
        } else if (tipo.equals("Terreno")) {
            return "Terreno: Área do imóvel: " + area + " - Valor do imóvel: R$" + valor;
        } else {
            return "Tipo de imóvel inválido!";
        }
    }
}

public class Imobiliaria {
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
