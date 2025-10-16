package AtividadePOOHeranca;

public class Aluno extends Pessoa {

    private double[] notas;
    private Double media;
    private String situacao;

    public Aluno(String nome, String cpf, double[] notas) {
        super(nome, cpf);
        this.notas = notas;
        calcularMedia();
        definirSituacao();
    }

    // ✅ ADICIONE ESTE MÉTODO AQUI
    public double getMedia() {
        return this.media;
    }

    private void definirSituacao() {
        if (media >= 60.0) { 
            this.situacao = "Aprovado";
        } else {
            this.situacao = "Reprovado";
        }
    }
    
    private void calcularMedia() {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        this.media = soma / notas.length;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
               " | Média: " + media +
               " | Situação: " + situacao;
    }
}