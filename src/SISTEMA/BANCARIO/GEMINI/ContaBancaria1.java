package SISTEMA.BANCARIO.GEMINI;

public class ContaBancaria1 {
	private String nome;
	private double saldo = 0.0;
	private int numeroConta;
	
	public ContaBancaria1(String nome, int numeroConta) {
		this.nome = nome;
		this.numeroConta = numeroConta;
		this.saldo = 0.0;
	}
	public String getNome() {
		return nome;
	}
	public int getNumeroConta() {
		return numeroConta;
	}
	public double getSaldo() {
		return saldo;
     }
	
	public void depositar(double valor) {
		if(valor > 0) {
			this.saldo += valor;
		}	
	} 
	
	public boolean sacar(double valor) {
		if(valor > 0 && valor <= this.saldo) {
			this.saldo -= valor;
			System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso.");
			return true;
		}else {
			System.out.println("Operação falhou: Saldo insuficiente ou valor de saque inválido.");
			return false;
		}	
	}
	
	public String toString() {
		return "Conta: " + this.numeroConta +
				" | Titular: " + this.nome +
				" | Saldo: R$ " + String.format("%.2f", this.saldo);
	}
	

}
