package agenciaviagens;

public class Transporte {
    private String tipo;
    private double valor;

    public Transporte(String tipo, double valor) {
        this.tipo = tipo;
        setValor(valor);
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public double getValor() { return valor; }
    public void setValor(double valor) {
        if (valor < 0) this.valor = 0; else this.valor = valor;
    }
}
