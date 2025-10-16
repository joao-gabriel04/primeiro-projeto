package SISTEMA.BANCARIO.GEMINI;


import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class BancoApp1 {
	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<ContaBancaria1> conta = new ArrayList<>();
	private static int proximoNumeroConta = 1;

	public static void main(String[] args) {
	System.out.println("--------- BEM VINDO AO BANCO AO GEMINI ---------");
	boolean executando = true;
	
	while(executando) {
		mostrarMenu();
		String opcao = scanner.nextLine();
		
		switch(opcao) {
		case "1": 
			criarConta();
			break;
		case "2":
			listarContas();
			break;
		case "3":
			realizarDeposito();
			break;
		case "4":
			realizerSaque();
			break;
		case "5":
			realizarTransferencia();
			break;
		case "6":
			removerContas();
			break;
		case "0":
			salvarContas();
			executando = false;
		    System.out.println("Obrigado por usar o Banco GEMINI");
		    break;
		default:
			System.out.println("Opção invalida! Tente Novamente");
		}
		
	}
	
	}
	public static void mostrarMenu() {
		System.out.println("\n--- MENU PRINCIPAL ---");
	    System.out.println("1 - Criar Nova Conta");
	    System.out.println("2 - Listar Todas as Contas");
	    System.out.println("3 - Realizar um Depósito");
	    System.out.println("4 - Realizar um Saque");
	    System.out.println("5 - Realizar Transferencia");
	    System.out.println("6 - Remover Conta");
	    System.out.println("0 - Sair do Sistema");
	    System.out.print("Escolha uma opção: ");
	}
	public static void criarConta() {
		System.out.println("Digite o Nome e Sobrenome do Titular: ");
		String nome = scanner.nextLine();
		
		int novoNumero = proximoNumeroConta;
		
		ContaBancaria1 novaConta = new ContaBancaria1(nome, novoNumero);
		conta.add(novaConta);
		
		proximoNumeroConta++;
		
		System.out.println("---------------------------");
		System.out.println("Conta Criada com sucesso");
		System.out.println(novaConta);
		System.out.println("Obrigado Por escolher o banco gemini");
		System.out.println("---------------------------");
	}
	
	public static void listarContas() {
		if(conta.isEmpty()) {
			System.out.println("Nenhuma Conta Cadastrada");
		}else {
			System.out.println("\n--------- Contas Cadastradas --------");
		   for(ContaBancaria1 c : conta) {
			 System.out.println(c);
		     }
		}
	}
	private static void realizarDeposito() {
		System.out.println("Digite o numero da Conta que deseja realizar um deposito: ");
		int numeroConta;
		try {
			numeroConta = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
			return;
		}
		
		ContaBancaria1 contaEncontrada = encontrarContaPorNumero(numeroConta);

		if(contaEncontrada != null) {
				System.out.println("Digite o valor que Deseja Depositar: ");
				double valorParaDeposito;
				try {
					valorParaDeposito = Double.parseDouble(scanner.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("Erro: Valor de depósito inválido. Por favor, digite um número (ex: 50.75).");
		            return;
					
				}
				
				
				contaEncontrada.depositar(valorParaDeposito);
					System.out.println("Deposito no valor de " + valorParaDeposito + " Realizado Com Sucesso.");
					System.out.printf("Saldo atual: R$ %.2f%n", contaEncontrada.getSaldo());
			}else {
				System.out.println("\nErro: Conta número " + numeroConta + " não encontrada.");
			}
			
		}
	
	
	private static void realizerSaque() {
		System.out.println("Digite o numero da Conta que deseja realizar um deposito: ");
		int numeroDaConta;
		
		try {
			numeroDaConta = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Erro: Valor de saque inválido. Por favor, digite um número.");
			return;
		}
		
		ContaBancaria1 contaEncontrada = encontrarContaPorNumero(numeroDaConta);
		
		
		if(contaEncontrada != null) {
			System.out.println("Digite o valor que deseja Sacar");
			double valorSaque;
			
			try {
				valorSaque = Double.parseDouble(scanner.nextLine());
			}catch(NumberFormatException e) {
				System.out.println("Erro: Valor de saque inválido. Por favor, digite um número.");
				return;
			}
			
			
			if(contaEncontrada.sacar(valorSaque)) {
				System.out.println("Saque Realizado Com sucesso");
				System.out.printf("Saldo atual: R$ %.2f%n", contaEncontrada.getSaldo());
			}	
		}else {
			System.out.println("\nErro: Conta número " + numeroDaConta + " não encontrada.");
		}	
   }
	private static void realizarTransferencia() {
		System.out.println("Digite o número da conta de ORIGEM: ");
		int numeroContaOrigem;
		
		try {
			numeroContaOrigem = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Erro: Valor de saque inválido. Por favor, digite um número.");
			return;
		}
		
		
		System.out.println("Digite a Conta de destino: ");
		int numeroContaDestino;
		
		try {
			numeroContaDestino = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Erro: Valor de saque inválido. Por favor, digite um número.");
			return;
		}
		
		ContaBancaria1 objetoContaOrigem = encontrarContaPorNumero(numeroContaOrigem);
		ContaBancaria1 objetoContaDestino = encontrarContaPorNumero(numeroContaDestino);
		
	
		if(objetoContaOrigem == null || objetoContaDestino == null) {
			System.out.println("Erro: Conta de origem ou destino inválida/não encontrada.");
			
		}else if(objetoContaOrigem.getNumeroConta() == objetoContaDestino.getNumeroConta()) {
			System.out.println("Erro: A conta de origem e destino não podem ser a mesma.");
		}else {
			System.out.println("Digite o valor da transferencia: ");
			double valorTransferencia;
			
			try {
				valorTransferencia = Double.parseDouble(scanner.nextLine());
			}catch(NumberFormatException e){
				System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
				return;
			}
			
			if(objetoContaOrigem.sacar(valorTransferencia)) {
				objetoContaDestino.depositar(valorTransferencia);
				System.out.println("Transferência realizada com sucesso");
				System.out.printf("Novo saldo da conta de origem: R$ %.2f%n", objetoContaOrigem.getSaldo());
			}
	}
}
	private static void removerContas() {
		System.out.println("Digite o Numero da conta que deseja Remover: ");
		int nmrContaRemover;
		
		try {
			nmrContaRemover = Integer.parseInt(scanner.nextLine());
		}catch(NumberFormatException e) {
			System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
			return;
		}
		
		
		ContaBancaria1 objetoRemover = encontrarContaPorNumero(nmrContaRemover);
		
		
		if(objetoRemover != null) {
			conta.remove(objetoRemover);
			System.out.println("Conta removida com sucesso");	
		}else {
			System.out.println("Conta não encontrada");
		}
	}
	
	private static ContaBancaria1 encontrarContaPorNumero(int numeroConta) {
		for(ContaBancaria1 c : conta) {
			if(c.getNumeroConta() == numeroConta) {
				return c;
			}
		}
		return null;
	}
	private static void salvarContas() {
		// A sintaxe 'try-with-resources' é uma forma segura de trabalhar com arquivos.
	    // Ela garante que o 'escritor' (PrintWriter) seja fechado no final, mesmo que dê erro.
	    // Estamos dizendo: "Tente criar um escritor para o arquivo 'contas.txt'"
		try(PrintWriter writer = new PrintWriter(new FileWriter("contas.txt"))) {
			
		
		
		// Agora, para cada objeto 'c' do tipo 'ContaBancaria1' na nossa lista 'conta'...
		for(ContaBancaria1 c : conta) {
			 
			
			// ...nós montamos uma String com os dados, separados por vírgula.
            // Formato: numero,titular,saldo
			
			String linha = c.getNumeroConta() + "," + c.getNome() + "," + c.getSaldo();
			// ...e usamos o 'escritor' para imprimir essa linha no arquivo.
			writer.println(linha);
		    }
		System.out.println("...Dados das contas salvos com sucesso!");
		}catch(IOException e) {
			// Se acontecer qualquer erro durante a escrita do arquivo (ex: falta de permissão)...
	        // ...este bloco 'catch' é executado.
			System.out.println("ERRO ao salvar os dados no arquivo: " + e.getMessage());
		}
	}
}


