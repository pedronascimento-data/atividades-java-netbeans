package modulocontabil;

import java.util.ArrayList;
import java.util.List;

public class Pagamentos {
    private String nomeEmpresa;
    private List<Imposto> impostos;

    public Pagamentos() {
        this.impostos = new ArrayList<>();
    }

    public Pagamentos(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
        this.impostos = new ArrayList<>();
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public List<Imposto> getImpostos() {
        return impostos;
    }

    public void setImpostos(List<Imposto> impostos) {
        this.impostos = impostos;
    }

    public void adicionarImposto(Imposto imposto) {
        impostos.add(imposto);
    }

    public double calcularTotalImpostos() {
        double total = 0.0;
        for (Imposto imposto : impostos) {
            total += imposto.calcularImposto();
        }
        return total;
    }
}
