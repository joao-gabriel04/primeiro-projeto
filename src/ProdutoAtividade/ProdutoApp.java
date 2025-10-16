package ProdutoAtividade;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoApp {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Produto> produtos = new ArrayList<>();

	public static void main(String[] args) {
		
		 System.out.println("---------SISTEMA DE PRODUTOS---------");
		 
		 System.out.println("Quantos Produtos Voce deseja Cadastrar");
		 int qtdProduto = Integer.parseInt(scanner.nextLine());
		 
		 for(int i = 0; i < qtdProduto; i++) {
			 System.out.println("\n-----Produto " + (i + 1) + ": ");
			 cadastrarProduto();
			 System.out.println("==================================");	 
			 
		 }	 
		 listarProduto();
		 System.out.println("==================================");
		 System.out.println("Valor total de todos os produtos: R$ " + calcularValorTotal());
		 
		 System.out.println("Sistema Encerrado!");
	}
	
	public static void cadastrarProduto() {
		System.out.println("Digite o nome do produto: ");
		String nomeProduto = scanner.nextLine();
		
		System.out.println("Digite o Preço do produto: ");
		double precoProduto = Double.parseDouble(scanner.nextLine());
		
		System.out.println("Digite a quantidade em estoque: ");
		int quantidade = Integer.parseInt(scanner.nextLine());
		
		Produto produto = new Produto (nomeProduto, precoProduto, quantidade);
		produtos.add(produto);
		
		System.out.println("Produto adicionado com sucesso!");		
	}
	
	public static void listarProduto() {
		if(produtos.isEmpty()) {
			System.out.println("Nenhum Produto Cadastrado!");
		}else {
			System.out.println("==========Lista de Produtos==========");
			for(Produto p : produtos) {
				System.out.println(p);
			}
		}
	}
	private static double calcularValorTotal() {
		double total = 0;
		for(Produto p : produtos) {
			total += p.calcularValorTotal();
		}
		return total;
	}
	

}
