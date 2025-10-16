		package SISTEMA.BANCARIO.GEMINI;
		
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;


		
		public class BancoApp {
			private static Scanner scanner = new Scanner(System.in);
			private static ArrayList<ContaBancaria> contas = new ArrayList<>();
			private static int proximoNumeroDaConta = 01;
			
			public static void main(String[] args) {
				System.out.println("--- BEM VINDO AO BANCO GEMINI ---");
				boolean executando = true;
				
				
				while(executando) {
					mostrarMenu();
					String opcao = scanner.nextLine();
					
					
				switch(opcao) {
				case "1" :
					criarConta();
					break;
				case "2": 
					listarContas();
					break;
				case "3":
					realizarDeposito();
					break;
				case "4" :
					realizarSaque();
					break;
				case "5":
					realizarTransferencia();
					break;
				case "6":
					removerConta();
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
			private static void mostrarMenu() {
				final String RESET = "\u001B[0m";
			    final String AZUL = "\u001B[34m";
			    final String VERDE = "\u001B[32m";
			    final String AMARELO = "\u001B[33m";
			    final String VERMELHO = "\u001B[31m";
			    final String CIANO = "\u001B[36m";

			    System.out.println("\n" + AZUL + "====================================" + RESET);
			    System.out.println(VERDE + "          BANCO GEMINI - MENU" + RESET);
			    System.out.println(AZUL + "====================================" + RESET);
			    System.out.println(CIANO + "1️  - Criar Nova Conta" + RESET);
			    System.out.println(CIANO + "2️  - Listar Todas as Contas" + RESET);
			    System.out.println(CIANO + "3️  - Realizar um Depósito" + RESET);
			    System.out.println(CIANO + "4️  - Realizar um Saque" + RESET);
			    System.out.println(CIANO + "5️  - Realizar uma Transferência" + RESET);
			    System.out.println(CIANO + "6️  - Remover Conta" + RESET);
			    System.out.println(VERMELHO + "0️  - Sair do Sistema" + RESET);
			    System.out.println(AZUL + "====================================" + RESET);
			    System.out.print(AMARELO + "👉 Escolha uma opção: " + RESET);
			}
			private static void criarConta() {
				System.out.println("Digite o Nome e Sobrenome do Titular: ");
				String nome = scanner.nextLine();
				
				int novoNumero = proximoNumeroDaConta;
				
				ContaBancaria novaConta = new ContaBancaria(nome, novoNumero);
				
				contas.add(novaConta);
				
				proximoNumeroDaConta++;
				
				System.out.println("\n------------------------------------");
			    System.out.println("Conta criada com sucesso!");
			    System.out.println(novaConta);
			    System.out.println("------------------------------------");
			}
			public static void listarContas() {
				if(contas.isEmpty()) {
					System.out.println("Nenhuma conta cadastrada!");
				}else{
					System.out.println("--------- Contas Cadastradas --------");
					for(ContaBancaria c : contas) {
						System.out.println(c);
						
					}
				}
			}
			private static void realizarDeposito() {
				System.out.println("Digite o Numero da conta de Destino: ");
				int numeroDaConta;
				try {
					numeroDaConta = Integer.parseInt(scanner.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
					return;
				}
				
				ContaBancaria contaEncontrada = encontrarContaPorNumero(numeroDaConta);
				
				
				if(contaEncontrada != null) {
					System.out.println("Digite o valor Do Deposito: ");
					double valorParaDepositar;
					try {
						valorParaDepositar = Double.parseDouble(scanner.nextLine());
					}catch(NumberFormatException e) {
						System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
						return;
					}
					
					contaEncontrada.depositar(valorParaDepositar);
				}else {
			        // Se a conta não foi encontrada...
			        System.out.println("\nErro: Conta número " + numeroDaConta + " não encontrada.");
			    }
			}
			private static void realizarSaque() {
				System.out.println("Digite o numero da conta que Deseja Realizer o saque: ");
				int numeroConta;
				try {
					numeroConta = Integer.parseInt(scanner.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
					return;
				}
				
				ContaBancaria contaEncontrada = encontrarContaPorNumero(numeroConta);
				
				
				if(contaEncontrada != null) {
					System.out.println("Digite o valor de saque: " );
					double valorParaSaque;
					try {
						valorParaSaque = Double.parseDouble(scanner.nextLine());
					}catch(NumberFormatException e) {
						System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
						return;
					}
					
					
		
					if(contaEncontrada.sacar(valorParaSaque)) {
						System.out.println("Operação finalizada.");

						System.out.printf("Saldo atual: R$ %.2f%n", contaEncontrada.getSaldo());
						
					}
				}else {
					System.out.println("\nErro: Conta número " + numeroConta + " não encontrada.");
				}
			}
			private static void realizarTransferencia() {
				System.out.println("Digite o numero da conta de ORIGEM: ");
				int numeroContaOrigem;
				
				try{
					numeroContaOrigem = Integer.parseInt(scanner.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
					return;
				}
				
				System.out.println("Digite o numero da conta de DESTINO: ");
				int numeroContaDestino;
				
				try{
					numeroContaDestino = Integer.parseInt(scanner.nextLine());
				}catch(NumberFormatException e) {
					System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
					return;
				}
				ContaBancaria obejetoContaOrigem = encontrarContaPorNumero(numeroContaOrigem);
				ContaBancaria obejetoContaDestino = encontrarContaPorNumero(numeroContaDestino);
				
				
				if(obejetoContaOrigem == null || obejetoContaDestino == null) {
					System.out.println("Erro: Conta de origem ou destino inválida/não encontrada.");
				}else if (obejetoContaOrigem.getNumeroDaConta() == obejetoContaDestino.getNumeroDaConta()) {
					System.out.println("Erro: A conta de origem e destino não podem ser a mesma.");
				}else {
					System.out.println("Digite o valor Da transferencia");
					double valorTransferencia;
					
					try {
						valorTransferencia = Double.parseDouble(scanner.nextLine());
					}catch(NumberFormatException e) {
						System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
						return;
					}
						if(obejetoContaOrigem.sacar(valorTransferencia)) {
							obejetoContaDestino.depositar(valorTransferencia);
							System.out.println("Transferência realizada com sucesso");
							System.out.printf("Novo saldo da conta de origem: R$ %.2f%n", obejetoContaOrigem.getSaldo());
					}
				}
			}
			private static void removerConta() {
				System.out.println("Digite o numero da conta que voce deseja remover: ");
				int nmrContaRemover ;
				try {
					nmrContaRemover = Integer.parseInt(scanner.nextLine());
				}catch(NumberFormatException e) {
				System.out.println("Erro: Número da conta inválido. Por favor, digite apenas números.");
				return;
				}
				ContaBancaria obejtoNmrRemover = encontrarContaPorNumero(nmrContaRemover);
				
				
				if(obejtoNmrRemover != null) {
					contas.remove(obejtoNmrRemover);
					System.out.println("Conta Removida com sucesso.");
				}else {
					System.out.println("Conta não encontrada");
				}
			}
			private static ContaBancaria encontrarContaPorNumero(int numeroConta) {
				for(ContaBancaria c : contas) {
					if(c.getNumeroDaConta() == numeroConta) {
						return c;
					}
				}
				return null;
			}
			private static void salvarContas() {
				try (PrintWriter writer = new PrintWriter(new FileWriter("Contasssss.txt"))){
					for(ContaBancaria conta : contas) {
						String linha = conta.getNumeroDaConta() + "," + conta.getNome() + "," + conta.getSaldo();
						
						writer.println(linha);
					}
					System.out.println("... Dados Salvo com sucesso!");
				}catch(IOException e) {
					System.out.println("ERRO ao salvar os dados no arquivo: " +  e.getMessage());
				}
			}
		}