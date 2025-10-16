package SISTEMA.RH.GEMINI;

public class Gerente extends Funcionario {
	
	public Gerente(int id, String nome, String setor, double salario) {
		super(id, nome, setor, salario);
		
	}
	@Override
	public double calcularBonus() {
		double bonusBase = super.calcularBonus();
		return bonusBase + 500.0;
	}
}
