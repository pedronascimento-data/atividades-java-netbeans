package modulocontabil;

public class IPI implements Imposto {
    private double aliquota;
    private double valorProduto;
    private double frete;
    private double seguro;
    private double outrasDespesas;

    public IPI() {
    }

    public IPI(double aliquota, double valorProduto, double frete,
               double seguro, double outrasDespesas) {
        this.aliquota = aliquota;
        this.valorProduto = valorProduto;
        this.frete = frete;
        this.seguro = seguro;
        this.outrasDespesas = outrasDespesas;
    }

    public double getAliquota() {
        return aliquota;
    }

    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    public double getValorProduto() {
        return valorProduto;
    }

    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }

    public double getFrete() {
        return frete;
    }

    public void setFrete(double frete) {
        this.frete = frete;
    }

    public double getSeguro() {
        return seguro;
    }

    public void setSeguro(double seguro) {
        this.seguro = seguro;
    }

    public double getOutrasDespesas() {
        return outrasDespesas;
    }

    public void setOutrasDespesas(double outrasDespesas) {
        this.outrasDespesas = outrasDespesas;
    }

    public double calcularBaseCalculo() {
        return valorProduto + frete + seguro + outrasDespesas;
    }

    @Override
    public String getDescricao() {
        return "IPI";
    }

    @Override
    public double calcularImposto() {
        return calcularBaseCalculo() * (aliquota / 100.0);
    }
}
