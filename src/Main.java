import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Integer quantidadeHomens = 0;
        Integer quantidadeMulheres = 0;

        String atletaMaisAlto = "";
        Double maiorAltura = 0.0;
        Double alturaTotalMulheres = 0.0;

        Double pesoTotal = 0.0;

        System.out.print("Qual a quantidade de atletas? ");
        Integer quantidadeAtletas = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < quantidadeAtletas; i++) {
            System.out.println("Digite os dados do atleta " + (i + 1) + ":");
            // Nome
            System.out.print("Nome: ");
            String nome = scanner.nextLine();

            // Sexo
            System.out.print("Sexo: ");
            Character sexo = scanner.next().charAt(0);
            scanner.nextLine();
            while (sexo != 'M' && sexo != 'F') {
                System.out.print("Valor invalido! Favor digitar F ou M: ");
                sexo = scanner.next().charAt(0);
                scanner.nextLine();
            }

            // Quantidade de Homens e Mulheres
            if (sexo == 'M') {
                quantidadeHomens++;
            } else {
                quantidadeMulheres++;
            }

            // Altura
            System.out.print("Altura: ");
            Double altura = scanner.nextDouble();
            scanner.nextLine();
            while (altura <= 0.0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                altura = scanner.nextDouble();
                scanner.nextLine();
            }

            // Verificando Atleta mais alto
            if (altura > maiorAltura) {
                maiorAltura = altura;
                atletaMaisAlto = nome;
            }

            // Somando altura de todas as mulheres
            if (sexo == 'F') {
                alturaTotalMulheres += altura;
            }

            // Peso
            System.out.print("Peso: ");
            Double peso = scanner.nextDouble();
            scanner.nextLine();
            while (peso <= 0.0) {
                System.out.print("Valor invalido! Favor digitar um valor positivo: ");
                peso = scanner.nextDouble();
                scanner.nextLine();
            }
            pesoTotal += peso;
        }

        System.out.println("\n");
        System.out.println("RELATORIO: ");
        // Calculando Peso Medio
        Double pesoMedioAtleta = pesoTotal / quantidadeAtletas;
        System.out.printf("Peso medio dos atletas: %.2f%n", pesoMedioAtleta);

        // Atleta mais alto
        System.out.println("Atleta mais alto: " + atletaMaisAlto);

        // Porcentagem de Homens
        if (quantidadeHomens > 0) {
            // Calculando porcentagem homens
            Double porcentagemHomens = (quantidadeHomens / (double) quantidadeAtletas) * 100.0;
            System.out.printf("Porcentagem de homens: %.1f %%%n", porcentagemHomens);
        } else {
            System.out.println("Nao ha homens cadastrados");
        }

        // Altura media mulheres
        if (quantidadeMulheres > 0) {
            // Calculando altura media mulheres
            Double alturaMediaMulheres = alturaTotalMulheres / quantidadeMulheres;
            System.out.println("Altura media das mulheres: " + alturaMediaMulheres);
        } else {
            System.out.println("Nao ha mulheres cadastradas");
        }

        scanner.close();
    }
}
