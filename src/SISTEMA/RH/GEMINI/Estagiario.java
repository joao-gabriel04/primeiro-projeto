package SISTEMA.RH.GEMINI;

public class Estagiario extends Funcionario {
	
	public Estagiario(int id, String nome, String setor, double salario) {
		super(id, nome, setor, salario);
	}
	@Override 
	public double calcularBonus() {
		return 100.0;
	}
	@Override
	public void aumentarSalario(double percentual) {
		if(percentual > 5.0) {
			System.out.println("AVISO: O aumento para estagiários é limitado a 5%.");
			percentual = 5.0;
		} 
		super.aumentarSalario(percentual);
	}
}
