package agenciaviagens;

public class PacoteViagem {
    private Transporte transporte;
    private Hospedagem hospedagem;
    private String destino;
    private int quantidadeDias;

    public PacoteViagem(Transporte transporte, Hospedagem hospedagem, String destino, int quantidadeDias) {
        this.transporte = transporte;
        this.hospedagem = hospedagem;
        this.destino = destino;
        setQuantidadeDias(quantidadeDias);
    }

    public double calcularTotalHospedagem() { return hospedagem.getValorDiaria() * quantidadeDias; }
    public double calcularValorComLucro(double margemPercentual, double valor) { return valor + valor * (margemPercentual / 100.0); }
    public double calcularTotalPacote(double margemPercentual, double taxasAdicionais) {
        double subtotal = transporte.getValor() + calcularTotalHospedagem();
        return calcularValorComLucro(margemPercentual, subtotal) + taxasAdicionais;
    }
    public Transporte getTransporte() { return transporte; }
    public void setTransporte(Transporte transporte) { this.transporte = transporte; }
    public Hospedagem getHospedagem() { return hospedagem; }
    public void setHospedagem(Hospedagem hospedagem) { this.hospedagem = hospedagem; }
    public String getDestino() { return destino; }
    public void setDestino(String destino) { this.destino = destino; }
    public int getQuantidadeDias() { return quantidadeDias; }
    public void setQuantidadeDias(int quantidadeDias) { this.quantidadeDias = quantidadeDias <= 0 ? 1 : quantidadeDias; }
}
