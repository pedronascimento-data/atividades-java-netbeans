package agenciaviagens;

public class Venda {
    private String nomeCliente;
    private String formaPagamento;
    private String dataVenda;
    private PacoteViagem pacoteViagem;

    public Venda(String nomeCliente, String formaPagamento, String dataVenda, PacoteViagem pacoteViagem) {
        this.nomeCliente = nomeCliente;
        this.formaPagamento = formaPagamento;
        this.dataVenda = dataVenda;
        this.pacoteViagem = pacoteViagem;
    }

    public double converterDolarParaReal(double valorDolar, double cotacaoDolar) { return valorDolar * cotacaoDolar; }
    public double converterRealParaDolar(double valorReal, double cotacaoDolar) { return cotacaoDolar <= 0 ? 0 : valorReal / cotacaoDolar; }
    public void mostrarTotais(double margemPercentual, double taxasAdicionais, double cotacaoDolar) {
        double totalDolar = pacoteViagem.calcularTotalPacote(margemPercentual, taxasAdicionais);
        double totalReal = converterDolarParaReal(totalDolar, cotacaoDolar);
        System.out.printf("Total do pacote em dólar: US$ %.2f%n", totalDolar);
        System.out.printf("Total do pacote em reais: R$ %.2f%n", totalReal);
    }
    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }
    public String getFormaPagamento() { return formaPagamento; }
    public void setFormaPagamento(String formaPagamento) { this.formaPagamento = formaPagamento; }
    public String getDataVenda() { return dataVenda; }
    public void setDataVenda(String dataVenda) { this.dataVenda = dataVenda; }
    public PacoteViagem getPacoteViagem() { return pacoteViagem; }
    public void setPacoteViagem(PacoteViagem pacoteViagem) { this.pacoteViagem = pacoteViagem; }
}
