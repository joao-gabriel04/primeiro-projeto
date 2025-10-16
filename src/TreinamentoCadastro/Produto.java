package TreinamentoCadastro;

public class Produto {
	private String nome;
	private double valor;
	private int quantidade;
	
	public Produto(String nome, double valor, int quantidade) {
		this.nome = nome;
		this.valor = valor;
		this.quantidade = quantidade;
	}
	public String getNome() {
		return nome;
	}
	public double getValor() {
		return valor;
	}
	public int quantidade() {
		return quantidade;
	}
	public double calcularValorTotal() {
		return quantidade * valor;
	}
	@Override
	public String toString () {
		return "Nome: " + nome +
	               " | Preço: R$ " + valor +
	               " | Quantidade: " + quantidade +
	               " | Valor Total: R$ " + calcularValorTotal();
	}
}
