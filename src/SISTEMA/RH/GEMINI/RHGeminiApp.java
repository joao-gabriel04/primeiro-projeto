package SISTEMA.RH.GEMINI;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class RHGeminiApp {

	private static Scanner scanner = new Scanner(System.in);
	private static ArrayList<Funcionario> funcionarios = new ArrayList<>();
	private static int proximoIdDoFuncionario = 1;

	public static void main(String[] args) {
		carregarFuncionarios();
		System.out.println("---------- Bem Vindo ao RH Gemini ----------");
		boolean executando = true;

		while (executando) {
			mostrarMenu();
			String opcao = scanner.nextLine();
			switch (opcao) {
			case "1":cadastrarFuncionario();break;
			case "2": listarFuncionarios(); break;
			case "3": aumentarSalario(); break;
			case "4":calcularBonusIndividual();break;
			case "5":transferirFuncionario();break;
			case "6":demitirFuncionario();break;
			case "7":buscarFuncionarioPorNome();break;
			case "8":gerarRelatorioEstatisticas();break;		
			case "0":
				salvarFuncionarios();
				executando = false;
				System.out.println("Obrigado por usar o RH GEMINI!");
				break;
			default:
				System.out.println("Opção invalida! Tente Novamente");
			}
		}

	}

	public static void mostrarMenu() {
		final String AZUL = "\u001B[34m";
	    final String VERDE = "\u001B[32m";
	    final String AMARELO = "\u001B[33m";
	    final String VERMELHO = "\u001B[31m";
	    final String CIANO = "\u001B[36m";
	    final String RESET = "\u001B[0m";
	    
		System.out.println(AMARELO + "--- SISTEMA RH GEMINI ---" + RESET);
		System.out.println(VERDE + "1 - Cadastrar Funcionário (Comum, Gerente ou Estagiário)");
		System.out.println("2 - Listar todos Funcionários");
		System.out.println("3 - Aumentar salário");
		System.out.println("4 - Calcular bônus individual");
		System.out.println("5 - Transferir funcionário de setor");
		System.out.println("6 - Remover funcionário");
		System.out.println("7 - Pesquisar funcionário por nome");
		System.out.println("8 - Relatório de estatísticas da empresa");
		System.out.println("0 - Sair");
		System.out.println(CIANO + "👉 Escolha uma opção: " + RESET);
	}

	public static void cadastrarFuncionario() {
		 System.out.print("Qual o tipo de funcionário a ser cadastrado? (1-Comum, 2-Gerente, 3-Estagiário): ");
		 String tipo = scanner.nextLine();
		
		 System.out.print("Digite o Nome do Funcionário: ");
		 String nome = scanner.nextLine();
		 
		 System.out.print("Digite o Setor: ");
		 String setor = scanner.nextLine();
		 
		 double salarioInicial = lerDouble("Digite o Salario Inicial Do Funcionario: ");
		 
		 Funcionario novoFuncionario = null;
		 
		 switch (tipo) {
		case "1":
			novoFuncionario = new Funcionario(proximoIdDoFuncionario, nome, setor, salarioInicial);
			break;
		case "2":
			novoFuncionario = new Gerente(proximoIdDoFuncionario, nome, setor, salarioInicial);
			break;
		case "3":
			novoFuncionario = new Estagiario(proximoIdDoFuncionario, nome, setor, salarioInicial);
			break;
			default:
				System.out.println("Tipo de funcionário inválido. Cadastro cancelado.");
	            return;
		}
		funcionarios.add(novoFuncionario);
		proximoIdDoFuncionario++;
		
		System.out.println("--------------------------------------");
	    System.out.println("Funcionário cadastrado com sucesso!");
	    System.out.println(novoFuncionario);
	    System.out.println("--------------------------------------");
	}

	private static void listarFuncionarios() {
		if (funcionarios.isEmpty()) {
			System.out.println("Nenhum Funcionario Cadastrado!");
		} else {
			System.out.println("Lista de Funcionarios: ");
			for (Funcionario f : funcionarios) {
				System.out.println(f);

			}
		}
	}

	private static void aumentarSalario() {
		System.out.println("Digite o Numero Do ID do Funcionario que deseja aumentar o salario:");
		int idFuncionario;
		try {
			idFuncionario = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Erro: Número de ID Invalido. Por favor, digite apenas números.");
			return;
		}

		Funcionario funcionarioEncontrado = null;

		for (Funcionario f : funcionarios) {
			if (f.getId() == idFuncionario) {
				funcionarioEncontrado = f;
				break;
			}
		}
		if (funcionarioEncontrado != null) {
			System.out.println("Digite o percentual de Do aumento(ex: 10 para 10%): ");
			double valorAumento;
			try {
				valorAumento = Double.parseDouble(scanner.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("Erro: Percentual Invalido. Por favor, digite apenas números.");
				return;
			}

			funcionarioEncontrado.aumentarSalario(valorAumento);
			System.out.println("\nSalário aumentado com sucesso!");
			System.out.println("Novos dados do funcionário:");
			System.out.println(funcionarioEncontrado);
		} else {
			System.out.println("\nErro: Funcionário com ID " + idFuncionario + " não encontrado.");
		}
	}

	private static void calcularBonusIndividual() {
		System.out.println("Digite o Numero Do ID do Funcionario que deseja ver o valor do bônus:");
		int idFuncionario;
		try {
			idFuncionario = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Erro: Número de ID Invalido. Por favor, digite apenas números.");
			return;
		}

		Funcionario funcionarioEncontrado = null;

		for (Funcionario f : funcionarios) {
			if (f.getId() == idFuncionario) {
				funcionarioEncontrado = f;
				break;
			}
		}
		if (funcionarioEncontrado != null) {
			double valorDoBonus = funcionarioEncontrado.calcularBonus();

			System.out.println("\n--- Bônus Calculado ---");
			System.out.println("Funcionário: " + funcionarioEncontrado.getNome());
			System.out.printf("Valor do Bônus: R$ %.2f%n", valorDoBonus);

		} else {
			System.out.println("\nFuncionário com ID " + idFuncionario + " não encontrado.");
		}
	}

	private static void transferirFuncionario() {
		System.out.println("Digite o Numero Do ID do Funcionario que deseja trocar de Setor:");
		int idFuncionario;
		try {
			idFuncionario = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Erro: Número de ID Invalido. Por favor, digite apenas números.");
			return;
		}
		Funcionario funcionarioEncontrado = null;

		for (Funcionario f : funcionarios) {
			if (f.getId() == idFuncionario) {
				funcionarioEncontrado = f;
				break;
			}
		}
		if (funcionarioEncontrado != null) {
			System.out.print("Informe o novo setor do funcionário: ");
			String novoSetor = scanner.nextLine();

			funcionarioEncontrado.setSetor(novoSetor);

			System.out.println("\nTransferência realizada com sucesso!");
			System.out.println("Funcionário " + funcionarioEncontrado.getNome() + " foi transferido para o setor de "
					+ novoSetor + ".");

		} else {
			System.out.println("\nErro: Funcionário com ID " + idFuncionario + " não encontrado.");
		}
	}

	private static void demitirFuncionario() {
		System.out.println("Digite o Numero Do ID do Funcionario que deseja DEMITIR:");
		int idFuncionario;
		try {
			idFuncionario = Integer.parseInt(scanner.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Erro: Número de ID Invalido. Por favor, digite apenas números.");
			return;
		}

		Funcionario funcionarioEncontrado = null;

		for (Funcionario f : funcionarios) {
			if (f.getId() == idFuncionario) {
				funcionarioEncontrado = f;
				break;
			}
		}
		if (funcionarioEncontrado != null) {
			funcionarios.remove(funcionarioEncontrado);
			System.out.println("Funcionario Demitido com sucesso!");
		} else {
			System.out.println("\nErro: Funcionário com ID " + idFuncionario + " não encontrado.");
		}
	}

	private static void buscarFuncionarioPorNome() {
		System.out.println("Digite o nome do Fincionario que deseja Encontrar: ");
		String nomeBusca = scanner.nextLine();

		boolean encontrouAlgem = false;

		System.out.println("\n--- Resultados da Busca ---");
		for (Funcionario f : funcionarios) {
			if (f.getNome().equalsIgnoreCase(nomeBusca)) {
				System.out.println(f);
				encontrouAlgem = true;
			}
		}
		if (!encontrouAlgem) {
			System.out.println("Nenhum funcionário encontrado com o nome '" + nomeBusca + "'.");
		}
	}

	private static void gerarRelatorioEstatisticas() {
		if (funcionarios.isEmpty()) {
			System.out.println("Nenhum funcionário cadastrado para gerar estatísticas.");
			return;
			
		}

		int qtdGerentes = 0, qtdEstagiarios = 0, qtdComuns = 0;
		double somaDeSalario = 0;
		double maiorSalario = Double.MIN_VALUE; // Começa com o menor valor possível
		double menorSalario = Double.MAX_VALUE; // Começa com o maior valor possível
		
		for(Funcionario f : funcionarios) {
			if(f instanceof Gerente) qtdGerentes++;
			else if(f instanceof Estagiario) qtdEstagiarios++; 
			else qtdComuns++;
		}
		
		for (Funcionario f : funcionarios) {
			double salario = f.getSalario();
			somaDeSalario += salario;

			if (salario > maiorSalario) {
				maiorSalario = salario;
			}
			if (salario < menorSalario) {
				menorSalario = salario;
			}
		}
		double media = somaDeSalario / funcionarios.size();

		System.out.println("\n========== RELATÓRIO DE ESTATÍSTICAS ==========");
		System.out.println("Total de Funcionários: " + funcionarios.size());
		System.out.printf("Soma total dos salários: R$ %.2f%n", somaDeSalario);
		System.out.printf("Média salarial: R$ %.2f%n", media);
		System.out.printf("Maior salário: R$ %.2f%n", maiorSalario);
		System.out.printf("Menor salário: R$ %.2f%n", menorSalario);
		System.out.println("Funcionários Comuns: " + qtdComuns);
		System.out.println("Gerentes: " + qtdGerentes);
		System.out.println("Estagiários: " + qtdEstagiarios);
		System.out.println("===============================================");

	}

	private static void carregarFuncionarios() {
		File arquivo = new File("Funcionarios.txt");
	    if (!arquivo.exists()) return;

	    try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
	        String linha;
	        int maiorId = 0;
	        while ((linha = reader.readLine()) != null) {
	            String[] partes = linha.split(",");
	            if (partes.length == 5) { // Agora esperamos 5 partes!
	                int id = Integer.parseInt(partes[0]);
	                String nome = partes[1];
	                String setor = partes[2];
	                double salario = Double.parseDouble(partes[3]);
	                String tipo = partes[4];

	                Funcionario f = null;
	                switch (tipo) {
	                    case "GERENTE":
	                        f = new Gerente(id, nome, setor, salario);
	                        break;
	                    case "ESTAGIARIO":
	                        f = new Estagiario(id, nome, setor, salario);
	                        break;
	                    default: // ou "COMUM"
	                        f = new Funcionario(id, nome, setor, salario);
	                        break;
	                }
	                funcionarios.add(f);
	                if (id > maiorId) maiorId = id;
	            }
	        }
	        proximoIdDoFuncionario = maiorId + 1;
	        System.out.println(funcionarios.size() + " funcionários carregados.");
	    } catch (IOException | NumberFormatException e) {
	        System.out.println("ERRO ao carregar os dados: " + e.getMessage());
	    }
	}

	private static void salvarFuncionarios() {
		try (PrintWriter writer = new PrintWriter(new FileWriter("Funcionarios.txt"))) {
			for (Funcionario f : funcionarios) {
				String tipoDeFuncionario = "COMUM";
				if(f instanceof Gerente) {
					tipoDeFuncionario = "GERENTE";
				}else if(f instanceof Estagiario) {
					tipoDeFuncionario = "ESTAGIARIO";
				}
				String salarioFormatado = String.format(Locale.US, "%.2f", f.getSalario());
				
				String linha = f.getId() + "," + f.getNome() + "," + f.getSetor() + "," + salarioFormatado + "," + tipoDeFuncionario;
				writer.println(linha);
			}	
			System.out.println("...Dados salvos com sucesso!");

		} catch (IOException e) {
			System.out.println("ERRO CRÍTICO: Não foi possível salvar os dados no arquivo.");
		}
	}
	private static double lerDouble(String mensagem) {
		while(true) {
		System.out.println(mensagem);
		try {
			double valor;
			valor = Double.parseDouble(scanner.nextLine());
			if(valor >= 0) {
			return valor;
			}else {
				System.out.println("Erro: O valor não pode ser negativo. Tente novamente.");
			}
		}catch(NumberFormatException e){
			System.out.println("Erro: Entrada inválida. Por favor, digite um número.");
		   }
		}
	}
}
