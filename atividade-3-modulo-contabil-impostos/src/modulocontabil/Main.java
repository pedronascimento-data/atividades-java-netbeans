package modulocontabil;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(java.util.Locale.US);

        System.out.println("========================================");
        System.out.println("     MODULO CONTABIL - IMPOSTOS");
        System.out.println("========================================");

        System.out.print("Informe o nome da empresa: ");
        String nomeEmpresa = entrada.nextLine().trim();
        Pagamentos pagamentos = new Pagamentos(nomeEmpresa);

        while (true) {
            System.out.println("\nDigite o tipo de imposto que deseja cadastrar:");
            System.out.println("- PIS");
            System.out.println("- IPI");
            System.out.println("- PARE para encerrar");
            System.out.print("Opcao: ");

            String tipo = entrada.nextLine().trim().toUpperCase();

            if (tipo.equals("PARE")) {
                break;
            }

            switch (tipo) {
                case "PIS":
                    cadastrarPIS(entrada, pagamentos);
                    break;

                case "IPI":
                    cadastrarIPI(entrada, pagamentos);
                    break;

                default:
                    System.out.println("Tipo invalido. Digite PIS, IPI ou PARE.");
                    break;
            }
        }

        System.out.println("\n========================================");
        System.out.println("        IMPOSTOS CADASTRADOS");
        System.out.println("========================================");
        System.out.println("Empresa: " + pagamentos.getNomeEmpresa());

        if (pagamentos.getImpostos().isEmpty()) {
            System.out.println("Nenhum imposto foi cadastrado.");
        } else {
            int numero = 1;
            for (Imposto imposto : pagamentos.getImpostos()) {
                System.out.printf("%d. %s - Total: R$ %.2f%n",
                        numero, imposto.getDescricao(), imposto.calcularImposto());
                numero++;
            }

            System.out.printf("\nTotal geral de impostos: R$ %.2f%n",
                    pagamentos.calcularTotalImpostos());
        }

        entrada.close();
    }

    private static void cadastrarPIS(Scanner entrada, Pagamentos pagamentos) {
        System.out.println("\n--- Cadastro de PIS ---");
        double debito = lerValorNaoNegativo(entrada, "Informe o valor total de debito (R$): ");
        double credito = lerValorNaoNegativo(entrada, "Informe o valor total de credito (R$): ");

        PIS pis = new PIS(debito, credito);
        pagamentos.adicionarImposto(pis);

        System.out.printf("PIS cadastrado. Valor calculado: R$ %.2f%n", pis.calcularImposto());
    }

    private static void cadastrarIPI(Scanner entrada, Pagamentos pagamentos) {
        System.out.println("\n--- Cadastro de IPI ---");
        double valorProduto = lerValorNaoNegativo(entrada, "Informe o valor do produto (R$): ");
        double frete = lerValorNaoNegativo(entrada, "Informe o valor do frete (R$): ");
        double seguro = lerValorNaoNegativo(entrada, "Informe o valor do seguro (R$): ");
        double outrasDespesas = lerValorNaoNegativo(entrada, "Informe outras despesas (R$): ");
        double aliquota = lerValorNaoNegativo(entrada, "Informe a aliquota do IPI (%): ");

        IPI ipi = new IPI(aliquota, valorProduto, frete, seguro, outrasDespesas);
        pagamentos.adicionarImposto(ipi);

        System.out.printf("Base de calculo: R$ %.2f%n", ipi.calcularBaseCalculo());
        System.out.printf("IPI cadastrado. Valor calculado: R$ %.2f%n", ipi.calcularImposto());
    }

    private static double lerValorNaoNegativo(Scanner entrada, String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String texto = entrada.nextLine().trim().replace(",", ".");

            try {
                double valor = Double.parseDouble(texto);
                if (valor >= 0) {
                    return valor;
                }
                System.out.println("O valor nao pode ser negativo.");
            } catch (NumberFormatException e) {
                System.out.println("Valor invalido. Digite apenas numeros.");
            }
        }
    }
}
