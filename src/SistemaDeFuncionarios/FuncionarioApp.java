package SistemaDeFuncionarios;

import java.util.ArrayList;
import java.util.Scanner;

public class FuncionarioApp {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	

	public static void main(String[] args) {
		System.out.println("---------SISTEMA DE FUNCIONARIOS---------");
		System.out.println("Digite a quantidade de Funcionairos que deseja cadastrar: ");
		int qtdFuncionarios = Integer.parseInt(scanner.nextLine());
		
		for(int i = 0; i < qtdFuncionarios; i++) {
			System.out.println("\n-----Funcionario " + (i + 1) + ": ");
			cadastrarFuncionario();
		}
		listarFuncionario();
		
		
		
	}
	
	public static void cadastrarFuncionario() {
		
		System.out.println("Digite o nome do novo funcionario: ");
		String nome = scanner.nextLine();
		
		System.out.println("Digite o cargo do funcionario: ");
		String cargo = scanner.nextLine();
		
		System.out.println("Digite o salário base: ");
		double salarioBase = Double.parseDouble(scanner.nextLine());
		
		System.out.println("Digite o bônus: ");
		double bonus = Double.parseDouble(scanner.nextLine());
		
		Funcionario funcionario = new Funcionario(nome, cargo, salarioBase, bonus);
		funcionarios.add(funcionario);
		
		System.out.println("Funcionário cadastrado com sucesso!");
	}
	
	public static void listarFuncionario() {
		if(funcionarios.isEmpty()) {
			System.out.println("Nenhum funcionário cadastrado!");
		}else {
			System.out.println("\n========== Lista de Funcionários ==========");
			for(Funcionario f : funcionarios) {
				System.out.println(f);
				
			}
		}
	}
	
	public static double calcularTotalSalarios() {
		double total = 0;
		for(Funcionario f : funcionarios) {
			total += f.calcularSalarioFinal();
		}
		return total;
	}

}
