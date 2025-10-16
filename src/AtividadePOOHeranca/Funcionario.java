package AtividadePOOHeranca;

public class Funcionario extends Pessoa {
    private double salarioBase;
    private double bonus;

    public Funcionario(String nome, String cpf, double salarioBase, double bonus) {
        super(nome, cpf);
        this.salarioBase = salarioBase;
        this.bonus = bonus;
    }
    
    public double calcularSalario() {
    	return salarioBase + bonus;
    }
    public double getBonus() {
    	return bonus;
    }
    @Override
    public String getInfo() {
    	return super.getInfo()+ 
                " | Tipo: Funcionário" +
                " | Salário Final: R$ " + calcularSalario();
    }
    
}