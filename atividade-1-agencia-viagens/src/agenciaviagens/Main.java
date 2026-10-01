package agenciaviagens;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("      CADASTRO DE VENDA DE VIAGEM");
        System.out.println("========================================");
        System.out.println("\n--- DADOS DO TRANSPORTE ---");
        System.out.print("Tipo de transporte (aéreo, rodoviário, marítimo etc.): ");
        String tipoTransporte = entrada.nextLine();
        double valorTransporte = lerDoubleNaoNegativo(entrada, "Valor do transporte em dólar (US$): ");
        Transporte transporte = new Transporte(tipoTransporte, valorTransporte);
        System.out.println("\n--- DADOS DA HOSPEDAGEM ---");
        System.out.print("Descrição da hospedagem: ");
        String descricaoHospedagem = entrada.nextLine();
        double valorDiaria = lerDoubleNaoNegativo(entrada, "Valor da diária em dólar (US$): ");
        Hospedagem hospedagem = new Hospedagem(descricaoHospedagem, valorDiaria);
        System.out.println("\n--- DADOS DO PACOTE ---");
        System.out.print("Destino: ");
        String destino = entrada.nextLine();
        int quantidadeDias = lerInteiroPositivo(entrada, "Quantidade de dias: ");
        double margemLucro = lerDoubleNaoNegativo(entrada, "Margem de lucro (%): ");
        double taxasAdicionais = lerDoubleNaoNegativo(entrada, "Taxas adicionais em dólar (US$): ");
        PacoteViagem pacote = new PacoteViagem(transporte, hospedagem, destino, quantidadeDias);
        double totalHospedagem = pacote.calcularTotalHospedagem();
        double subtotal = transporte.getValor() + totalHospedagem;
        double subtotalComLucro = pacote.calcularValorComLucro(margemLucro, subtotal);
        double valorLucro = subtotalComLucro - subtotal;
        double totalPacote = pacote.calcularTotalPacote(margemLucro, taxasAdicionais);
        System.out.println("\n========================================");
        System.out.println("       INFORMAÇÕES DO PACOTE");
        System.out.println("========================================");
        System.out.println("Destino: " + pacote.getDestino());
        System.out.println("Quantidade de dias: " + pacote.getQuantidadeDias());
        System.out.println("Transporte: " + transporte.getTipo());
        System.out.printf("Valor do transporte: US$ %.2f%n", transporte.getValor());
        System.out.println("Hospedagem: " + hospedagem.getDescricao());
        System.out.printf("Valor da diária: US$ %.2f%n", hospedagem.getValorDiaria());
        System.out.printf("Total da hospedagem: US$ %.2f%n", totalHospedagem);
        System.out.printf("Margem de lucro: %.2f%%%n", margemLucro);
        System.out.printf("Valor do lucro: US$ %.2f%n", valorLucro);
        System.out.printf("Taxas adicionais: US$ %.2f%n", taxasAdicionais);
        System.out.printf("TOTAL DO PACOTE: US$ %.2f%n", totalPacote);
        System.out.println("\n--- DADOS DA VENDA ---");
        System.out.print("Nome do cliente: ");
        String nomeCliente = entrada.nextLine();
        System.out.print("Forma de pagamento: ");
        String formaPagamento = entrada.nextLine();
        System.out.print("Data da venda (dd/mm/aaaa): ");
        String dataVenda = entrada.nextLine();
        double cotacaoDolar = lerDoublePositivo(entrada, "Cotação do dólar no dia (R$): ");
        Venda venda = new Venda(nomeCliente, formaPagamento, dataVenda, pacote);
        double totalReais = venda.converterDolarParaReal(totalPacote, cotacaoDolar);
        System.out.println("\n========================================");
        System.out.println("          RESUMO DA VENDA");
        System.out.println("========================================");
        System.out.println("Cliente: " + venda.getNomeCliente());
        System.out.println("Forma de pagamento: " + venda.getFormaPagamento());
        System.out.println("Data da venda: " + venda.getDataVenda());
        System.out.println("Destino: " + venda.getPacoteViagem().getDestino());
        System.out.printf("Cotação utilizada: R$ %.2f%n", cotacaoDolar);
        venda.mostrarTotais(margemLucro, taxasAdicionais, cotacaoDolar);
        System.out.println("========================================");
        System.out.printf("Valor final em reais: R$ %.2f%n", totalReais);
        entrada.close();
    }
    private static double lerDoubleNaoNegativo(Scanner entrada, String mensagem) {
        double valor;
        do {
            System.out.print(mensagem);
            while (!entrada.hasNextDouble()) { System.out.println("Valor inválido. Digite um número."); entrada.next(); System.out.print(mensagem); }
            valor = entrada.nextDouble(); entrada.nextLine();
            if (valor < 0) System.out.println("O valor não pode ser negativo.");
        } while (valor < 0);
        return valor;
    }
    private static double lerDoublePositivo(Scanner entrada, String mensagem) {
        double valor;
        do { valor = lerDoubleNaoNegativo(entrada, mensagem); if (valor == 0) System.out.println("O valor deve ser maior que zero."); } while (valor == 0);
        return valor;
    }
    private static int lerInteiroPositivo(Scanner entrada, String mensagem) {
        int valor;
        do {
            System.out.print(mensagem);
            while (!entrada.hasNextInt()) { System.out.println("Valor inválido. Digite um número inteiro."); entrada.next(); System.out.print(mensagem); }
            valor = entrada.nextInt(); entrada.nextLine();
            if (valor <= 0) System.out.println("A quantidade deve ser maior que zero.");
        } while (valor <= 0);
        return valor;
    }
}
