package agenciaviagens;

public class Hospedagem {
    private String descricao;
    private double valorDiaria;

    public Hospedagem(String descricao, double valorDiaria) {
        this.descricao = descricao;
        setValorDiaria(valorDiaria);
    }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public double getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(double valorDiaria) {
        if (valorDiaria < 0) this.valorDiaria = 0; else this.valorDiaria = valorDiaria;
    }
}
