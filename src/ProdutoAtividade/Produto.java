package ProdutoAtividade;

public class Produto {
	String nome;
	
	double preco;
	
	int quantidade;
	
	public Produto(String nome, double preco, int quantidade) {
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double calcularValorTotal() {
        return preco * quantidade;
    }
    
    @Override
    public String toString() {
        return "Nome: " + nome +
               " | Preço: R$ " + preco +
               " | Quantidade: " + quantidade +
               " | Valor Total: R$ " + calcularValorTotal();
    }

}
