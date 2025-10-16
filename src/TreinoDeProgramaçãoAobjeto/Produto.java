package TreinoDeProgramaçãoAobjeto;

public class Produto {
	String nome;
	
	Double preco;
	
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
    
    public double getValorTotalDoEstoque() {
    	return preco * quantidade;
    }
    
    
	

}
