package folhapagamentorh;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Funcionario[] funcionarios = new Funcionario[10];
        int quantidade;

        System.out.println("========================================");
        System.out.println("   SISTEMA DE RH - FOLHA DE PAGAMENTO");
        System.out.println("========================================");

        do {
            System.out.print("Quantos funcionarios deseja cadastrar (1 a 10)? ");
            quantidade = lerInteiro(entrada);

            if (quantidade < 1 || quantidade > 10) {
                System.out.println("Quantidade invalida. Informe um numero entre 1 e 10.");
            }
        } while (quantidade < 1 || quantidade > 10);

        for (int i = 0; i < quantidade; i++) {
            System.out.println("\n--- Cadastro do funcionario " + (i + 1) + " ---");

            int tipo;
            do {
                System.out.print("Tipo [1 - Assalariado / 2 - Horista]: ");
                tipo = lerInteiro(entrada);
                if (tipo != 1 && tipo != 2) {
                    System.out.println("Opcao invalida. Digite 1 ou 2.");
                }
            } while (tipo != 1 && tipo != 2);

            System.out.print("Nome: ");
            String nome = entrada.nextLine();
            System.out.print("CPF: ");
            String cpf = entrada.nextLine();
            System.out.print("Endereco: ");
            String endereco = entrada.nextLine();
            System.out.print("Telefone: ");
            String telefone = entrada.nextLine();
            System.out.print("Setor: ");
            String setor = entrada.nextLine();

            if (tipo == 1) {
                double salarioMensal = lerDoublePositivo(entrada, "Salario mensal: R$ ");
                funcionarios[i] = new Assalariado(nome, cpf, endereco, telefone, setor, salarioMensal);
            } else {
                double horasTrabalhadas = lerDoubleNaoNegativo(entrada, "Horas trabalhadas: ");
                double valorHora = lerDoublePositivo(entrada, "Valor da hora: R$ ");
                funcionarios[i] = new Horista(nome, cpf, endereco, telefone, setor, horasTrabalhadas, valorHora);
            }
        }

        System.out.println("\n========================================");
        System.out.println("     FUNCIONARIOS E PAGAMENTOS ATUAIS");
        System.out.println("========================================");
        mostrarFuncionarios(funcionarios, quantidade);

        double percentualAumento;
        do {
            System.out.print("\nInforme o percentual de aumento geral: ");
            percentualAumento = lerDouble(entrada);
            if (percentualAumento < 0) {
                System.out.println("O percentual nao pode ser negativo.");
            }
        } while (percentualAumento < 0);

        for (int i = 0; i < quantidade; i++) {
            funcionarios[i].aplicarAumento(percentualAumento);
        }

        System.out.println("\n========================================");
        System.out.printf(" PAGAMENTOS APOS AUMENTO DE %.2f%%%n", percentualAumento);
        System.out.println("========================================");

        for (int i = 0; i < quantidade; i++) {
            System.out.printf("%d. %s - R$ %.2f%n",
                    i + 1,
                    funcionarios[i].getNome(),
                    funcionarios[i].calcularPagamento());
        }

        entrada.close();
    }

    private static void mostrarFuncionarios(Funcionario[] funcionarios, int quantidade) {
        for (int i = 0; i < quantidade; i++) {
            System.out.println("\nFuncionario " + (i + 1));
            System.out.println("----------------------------------------");
            funcionarios[i].mostrarDados();
            System.out.printf("Pagamento: R$ %.2f%n", funcionarios[i].calcularPagamento());
        }
    }

    private static int lerInteiro(Scanner entrada) {
        while (true) {
            String texto = entrada.nextLine().trim();
            try {
                return Integer.parseInt(texto);
            } catch (NumberFormatException e) {
                System.out.print("Valor invalido. Digite um numero inteiro: ");
            }
        }
    }

    private static double lerDouble(Scanner entrada) {
        while (true) {
            String texto = entrada.nextLine().trim().replace(',', '.');
            try {
                return Double.parseDouble(texto);
            } catch (NumberFormatException e) {
                System.out.print("Valor invalido. Digite um numero: ");
            }
        }
    }

    private static double lerDoublePositivo(Scanner entrada, String mensagem) {
        double valor;
        do {
            System.out.print(mensagem);
            valor = lerDouble(entrada);
            if (valor <= 0) {
                System.out.println("O valor deve ser maior que zero.");
            }
        } while (valor <= 0);
        return valor;
    }

    private static double lerDoubleNaoNegativo(Scanner entrada, String mensagem) {
        double valor;
        do {
            System.out.print(mensagem);
            valor = lerDouble(entrada);
            if (valor < 0) {
                System.out.println("O valor nao pode ser negativo.");
            }
        } while (valor < 0);
        return valor;
    }
}
