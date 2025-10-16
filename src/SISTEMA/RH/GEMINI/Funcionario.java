package SISTEMA.RH.GEMINI;

public class Funcionario {
	private int id;
	private String nome;
	private String setor;
	private double salario;
	
	public Funcionario(int id, String nome, String setor, double salario) {
		this.id = id;
		this.nome = nome;
		this.salario = salario;
		this.setor = setor;
	}
	
	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	public String getSetor() {
		return setor;
	}
	
	void setSetor(String novoSetor) {
		this.setor = novoSetor;
	}

	public double getSalario() {
		return salario;
	}
	public double calcularBonus() {
		double valorDoBonus = this.salario * 0.10;
		return valorDoBonus;
	}
	public void aumentarSalario(double percentual) {
		if(percentual > 0 ) {
		double valorDoAumento = (percentual / 100.0) * this.salario;
		this.salario += valorDoAumento;
		System.out.printf("Salário de %s aumentado em %.2f%%. Novo salário: R$ %.2f%n", nome, percentual, salario);
		}else {
			System.out.println("Percentual Invalido!");
		}
	}
	public String toString() {
		return "ID: " + this.getId() +
				" | Nome: " + this.getNome() +  
				" | Setor: " + this.getSetor() + 
				" | Salario: R$ " + String.format("%.2f", this.salario);
	}

}
