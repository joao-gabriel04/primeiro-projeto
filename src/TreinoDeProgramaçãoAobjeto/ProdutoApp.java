package TreinoDeProgramaçãoAobjeto;

import java.util.Scanner;

public class ProdutoApp {

	public static void main(String[] args) {
		Scanner scanner =  new Scanner(System.in);
		
		System.out.print("Digite o nome do produto: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do produto: ");
        double preco = scanner.nextDouble();

        System.out.print("Digite a quantidade em estoque: ");
        int quantidade = scanner.nextInt();
        
        Produto produto = new Produto(nome, preco, quantidade);
        
        System.out.println("\n--- Dados do Produto ---");
        System.out.println("Nome do Produto: " + produto.getNome());
        System.out.println("Valor: " + produto.getPreco());
        System.out.println("Quantidade que tem em Estoque: " + produto.quantidade);
        System.out.println("Valor total em estoque: R$ " + produto.getValorTotalDoEstoque());
        
        scanner.close();
	}
	

}
