package folhapagamentorh;

/** Funcionario que recebe de acordo com as horas trabalhadas. */
public class Horista extends Funcionario {
    private double horasTrabalhadas;
    private double valorHora;

    public Horista(String nome, String cpf, String endereco, String telefone,
                   String setor, double horasTrabalhadas, double valorHora) {
        super(nome, cpf, endereco, telefone, setor);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    public double getHorasTrabalhadas() { return horasTrabalhadas; }
    public void setHorasTrabalhadas(double horasTrabalhadas) { this.horasTrabalhadas = horasTrabalhadas; }
    public double getValorHora() { return valorHora; }
    public void setValorHora(double valorHora) { this.valorHora = valorHora; }

    @Override
    public double calcularPagamento() {
        return horasTrabalhadas * valorHora;
    }

    @Override
    public void aplicarAumento(double percentual) {
        valorHora += valorHora * (percentual / 100.0);
    }

    @Override
    public void mostrarDados() {
        System.out.println("Tipo: Horista");
        super.mostrarDados();
        System.out.printf("Horas trabalhadas: %.2f%n", horasTrabalhadas);
        System.out.printf("Valor da hora: R$ %.2f%n", valorHora);
    }
}
