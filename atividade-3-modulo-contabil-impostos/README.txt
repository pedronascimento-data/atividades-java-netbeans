ATIVIDADE 3 - MODULO CONTABIL DE IMPOSTOS

Estrutura principal:
- Imposto.java: interface com getDescricao() e calcularImposto().
- PIS.java: implementa o calculo (debito - credito) * 1,65%.
- IPI.java: implementa base = produto + frete + seguro + outras despesas e IPI = base * aliquota.
- Pagamentos.java: guarda o nome da empresa e uma List<Imposto> sem limite fixo.
- Main.java: entrada de dados, cadastro consecutivo ate o comando PARE e exibicao dos resultados.

Todos os atributos das classes concretas estao encapsulados com private e possuem getters/setters.
