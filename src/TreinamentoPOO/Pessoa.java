package TreinamentoPOO;

public class Pessoa {
	private String nome;
	
	private String cpf;
	
	public Pessoa(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
		
	}
	
	public String getNome() {
		return nome;
	}
	public String getCpf() {
		return cpf;
	}
	// Método que pode ser sobrescrito pelas subclasses
	public String getInfo() {
		return "Nome: " + nome + "CPF: " + cpf; 
	}

}
