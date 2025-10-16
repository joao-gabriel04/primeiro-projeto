package TreinamentoCadastro;

import java.util.ArrayList;
import java.util.Scanner;

public class ProdutoApp {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList <Produto> produtos = new ArrayList<>();

	public static void main(String[] args) {
		System.out.println("==============CADASTRO DE PRODUTOS==============");
		
		System.out.println("Digite a Quantidade de Produtos que Você Deseja cadastrar: ");
		int qtdProduto = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < qtdProduto; i++) {
			System.out.println("---------PRODUTO " + (i + 1) + ": ");
			cadastrarProduto();
			System.out.println("========================================");
		}
		listarProdutos();
		System.out.println("========================================");
		System.out.println("Valor total do estoque: R$ " + calcularValorEstoque());
		
		System.out.println("Sistema encerrado!");
		
	}
	public static void cadastrarProduto() {
		System.out.println("Diigite o nome do produto: ");
		String nome = scanner.nextLine();
		
		System.out.println("Digite o valor do produto: ");
		double valor = Double.parseDouble(scanner.nextLine());
		
		System.out.println("Digite a quantidade de produto: ");
		int quantidade = Integer.parseInt(scanner.nextLine());
		
		Produto produto = new Produto(nome, valor, quantidade);
		produtos.add(produto);
		
		System.out.println("Produto adicionado com sucesso!");
	}
	public static void listarProdutos() {
		if(produtos.isEmpty()) {
			System.out.println("produto não cadastrado!");
		}else {
			for(Produto p : produtos) {
				System.out.println(p);
				
			}
		}
	}
	public static double calcularValorEstoque() {
		double total = 0;
		for(Produto p : produtos) {
			total += p.calcularValorTotal();
			
		}
		return total;
	}
}
