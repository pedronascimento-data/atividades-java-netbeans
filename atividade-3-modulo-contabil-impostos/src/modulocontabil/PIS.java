package modulocontabil;

public class PIS implements Imposto {
    private double totalDebito;
    private double totalCredito;
    private static final double ALIQUOTA = 1.65;

    public PIS() {
    }

    public PIS(double totalDebito, double totalCredito) {
        this.totalDebito = totalDebito;
        this.totalCredito = totalCredito;
    }

    public double getTotalDebito() {
        return totalDebito;
    }

    public void setTotalDebito(double totalDebito) {
        this.totalDebito = totalDebito;
    }

    public double getTotalCredito() {
        return totalCredito;
    }

    public void setTotalCredito(double totalCredito) {
        this.totalCredito = totalCredito;
    }

    public double getAliquota() {
        return ALIQUOTA;
    }

    @Override
    public String getDescricao() {
        return "PIS";
    }

    @Override
    public double calcularImposto() {
        return (totalDebito - totalCredito) * (ALIQUOTA / 100.0);
    }
}
