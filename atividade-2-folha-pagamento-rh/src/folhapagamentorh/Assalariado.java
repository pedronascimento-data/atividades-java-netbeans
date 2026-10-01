package folhapagamentorh;

/** Funcionario que recebe um salario mensal fixo. */
public class Assalariado extends Funcionario {
    private double salarioMensal;

    public Assalariado(String nome, String cpf, String endereco, String telefone,
                       String setor, double salarioMensal) {
        super(nome, cpf, endereco, telefone, setor);
        this.salarioMensal = salarioMensal;
    }

    public double getSalarioMensal() { return salarioMensal; }
    public void setSalarioMensal(double salarioMensal) { this.salarioMensal = salarioMensal; }

    @Override
    public double calcularPagamento() {
        return salarioMensal;
    }

    @Override
    public void aplicarAumento(double percentual) {
        salarioMensal += salarioMensal * (percentual / 100.0);
    }

    @Override
    public void mostrarDados() {
        System.out.println("Tipo: Assalariado");
        super.mostrarDados();
        System.out.printf("Salario mensal: R$ %.2f%n", salarioMensal);
    }
}
