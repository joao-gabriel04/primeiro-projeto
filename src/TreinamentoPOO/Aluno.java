package TreinamentoPOO;

public class Aluno extends Pessoa{
	private double nota1;
	
	private double nota2;

	public Aluno(String nome, String cpf, double nota1,  double nota2) {
		super(nome, cpf);
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	public double calcularMedia() {
		return (nota1 + nota2) / 2.0;
	}
	@Override
	public String getInfo() {
		return super.getInfo() + " | Tipo: Aluno | Média: " + calcularMedia();
	}
}
