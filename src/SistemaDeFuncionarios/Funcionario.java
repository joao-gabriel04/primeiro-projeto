package SistemaDeFuncionarios;

public class Funcionario {
	private String nome;
	private String cargo;
	private double salarioBase;
	private double bonus;
	
	public Funcionario(String nome, String cargo, double salarioBase, double bonus ) {
		this.nome = nome;
		this.cargo =  cargo;
		this.salarioBase = salarioBase;
		this.bonus = bonus;
	}
		public String getNome() {
	        return nome;
	    }

	    public String getCargo() {
	        return cargo;
	    }

	    public double getSalarioBase() {
	        return salarioBase;
	    }

	    public double getBonus() {
	        return bonus;
	        
	    }
	    public double calcularSalarioFinal() {
	    	return salarioBase + bonus;
	    }
	    
	    @Override
	    public String toString() {
	        return "Nome: " + nome +
	               " | Cargo: " + cargo +
	               " | Salário Base: R$ " + salarioBase +
	               " | Bônus: R$ " + bonus +
	               " | Salário Final: R$ " + calcularSalarioFinal();
	    }
	    
}
