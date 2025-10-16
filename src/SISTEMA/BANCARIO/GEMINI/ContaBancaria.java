package SISTEMA.BANCARIO.GEMINI;

public class ContaBancaria {
	private String nome;
	private int numeroDaConta;
	private double saldo;
	
	public ContaBancaria(String nome, int numeroDaConta) {
		this.nome = nome;
		this.numeroDaConta = numeroDaConta;
		this.saldo = 0.0;
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
		return "Conta: " + this.numeroDaConta +
				" | Titular: " + this.nome +
				" | Saldo: R$ " + String.format("%.2f", this.saldo);
	}
	public int getNumeroDaConta() {
		return numeroDaConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public String getNome() {
		return nome;
	}
}
