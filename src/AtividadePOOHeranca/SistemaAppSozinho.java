package AtividadePOOHeranca;

import java.util.ArrayList;
import java.util.Scanner;


public class SistemaAppSozinho {
	private static Scanner scanner =  new Scanner(System.in);
	private static ArrayList<Pessoa> pessoas = new ArrayList<>();
	
	public static void main(String[] args) {
		boolean executando = true;
		
		System.out.println("------- SISTEMA DE PESSOAS -------");
		while(executando) {
			mostrarMenu();
			String opcao = scanner.nextLine();
			
			switch(opcao) {
			case "1":
				cadastrarPessoa();
                break;
            case "2":
            	listarPessoas();
                break;
            case "3":
            	buscarPessoaPeloCPF();
                break;
            case "4":
            	removerPessoa();
                break;
            case "5":
            	mostrarBoletimGeral();
                break;
            case "6": 
            	calcularSalariosAltos();
            	break;
            case "7": 
            	calcularMaiorBonus();
            	break;
            	
            case "0": // CORRIGIDO - A opção de sair agora é a "0"
                executando = false;
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção Invalida!");
			}
			
			
		}
		
		
	}
	private static void mostrarMenu() {
		System.out.println("\n--- MENU ---");
        System.out.println("1 - Adicionar pessoa");
        System.out.println("2 - Listar pessoas");
        System.out.println("3 - Buscar pessoa pelo CPF");
        System.out.println("4 - Remover pessoa pelo CPF");
        System.out.println("5 - Boletim Geral dos Alunos"); 
        System.out.println("6 - Relatório: Salários Altos");
        System.out.println("7 - Relatório: Maior Bônus");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
	}
	private static void cadastrarPessoa() {
		System.out.println("Digite o Nome: ");
		String nome = scanner.nextLine();
		
		System.out.println("Digite o CPF: ");
		String cpf = scanner.nextLine();
		
		if(cpf.length() != 11) {
			System.out.println("ERRO: O CPF deve conter exatamente 11 dígitos. Cadastro cancelado.");
			return;
		}
		
		for(Pessoa p : pessoas) {
			if(p.getCpf().equals(cpf)) {
				System.out.println("ERRO: Este CPF já está cadastrado no sistema. Cadastro cancelado.");
				return;
			}
			
		}
		
		
		System.out.println("Você deseja cadastrar: (A) Aluno --- (F) Funcionario |");
		String tipo =  scanner.nextLine().trim().toUpperCase();
		if(tipo.equals("A")) {
			System.out.println("Digite quantas notas Você Deseja cadastar: ");
			int qtdNotas = Integer.parseInt(scanner.nextLine());
			
			double[] notasAluno = new double[qtdNotas];
			
			for(int i = 0; i < qtdNotas; i++) {
			System.out.println("Digite a nota " + (i + 1) + ": ");
			notasAluno[i] = Double.parseDouble(scanner.nextLine());
			}
		
		pessoas.add(new Aluno(nome, cpf, notasAluno));
		System.out.println("Aluno Cadastrado com Sucesso!");
		
	    }else if(tipo.equals("F")) {
	    	System.out.println("Digite o Salario Base: ");
	    	double salarioBase = Double.parseDouble(scanner.nextLine());
	    	
	    	System.out.println("Digite o valor do Bônus: ");
	    	double bonus = Double.parseDouble(scanner.nextLine());
	    	
	    	if(salarioBase < 0 || bonus < 0) {
	    		System.out.println("ERRO: Salário e bônus não podem ser negativos. Cadastro cancelado.");
	    		return;
	    	}
	    	
	    	pessoas.add(new Funcionario(nome, cpf, salarioBase, bonus));
	    	System.out.println("Funcionario Cadastrado com Sucesso");
	    }else {
	    	System.out.println("Tipo inválido, Pessoa não cadastrada.");
	    }
	}
	private static void listarPessoas() {
		if(pessoas.isEmpty()) {
			System.out.println("Nenhuma pessoa cadastrada");
		}else {
			System.out.println("\n========== Lista de Pessoas ==========");
			for(Pessoa p : pessoas) {
				System.out.println(p.getInfo());
			}
		}
	}
	public static void buscarPessoaPeloCPF() {
		System.out.println("Digite CPF da pessoa que você deseja buscar: ");
		String cpf = scanner.nextLine();
		
		boolean encontrada = false;
		for(Pessoa p : pessoas) {
			if(p.getCpf().equals(cpf)) {
				System.out.println("Pessoa encontrada:");
				System.out.println(p.getInfo());
				encontrada = true;
				break;
			}
		}
		if(!encontrada) {
			System.out.println("Nenhuma pessoa encontrada com esse CPF!");
		}
	}
	public static void removerPessoa() {
		System.out.println("Digite CPF da pessoa que deseja remover: ");
		String cpf = scanner.nextLine();
		
		Pessoa pessoaParaRemover = null;
		
		for(Pessoa p : pessoas) {
			if(p.getCpf().equals(cpf)) {
				pessoaParaRemover = p;
				break;
			}
		}
		
		if(pessoaParaRemover != null) {
			pessoas.remove(pessoaParaRemover);
			System.out.println("Pessoa removida com sucesso:");
			System.out.println(pessoaParaRemover.getInfo());
			
		}else {
			System.out.println("Nenhuma Pessoa encontrada com esse CPF.");
		    
		}
	}
	private static void mostrarBoletimGeral() {
		System.out.println("\n------- BOLETIM GERAL DOS ALUNOS -------");
		boolean encontrouAprovados = false;
		
		System.out.println("\n----- ALUNOS APROVADOS -----");
		boolean encontrouAluno = false;
		for(Pessoa p : pessoas) {
			if(p instanceof Aluno) {
			encontrouAluno = true;
			Aluno aluno = (Aluno) p;
			if(aluno.getMedia() >= 60.0) {
				System.out.println(aluno.getInfo());
				encontrouAprovados = true;
		     }
	   }

    }	
		
	
	if(!encontrouAprovados && encontrouAluno ) {
		System.out.println("Nenhum Aluno aprovado");
	    }
	System.out.println("\n----- ALUNOS REPROVADOS (Média < 60) -----");
	boolean encontrouReprovado = false;
	for(Pessoa p : pessoas) {
		if(p instanceof Aluno) {
			Aluno aluno = (Aluno) p;
			if(aluno.getMedia() < 60) {
				System.out.println(aluno.getInfo());
				encontrouReprovado = true;
			}	
		  }
	   }
	if(!encontrouReprovado && encontrouAluno) {
		System.out.println("Nenhum Aluno Reprovado");
	}
	if(!encontrouAluno) {
		System.out.println("Nenhum aluno cadastrado no sistema para gerar o boletim.");
		
	    }
	}
	private static void calcularSalariosAltos() {
		System.out.println("\n------------ RELATORIO: SALARIOS ACIMA DE 3000 ------------");
		boolean encontrouFuncionario = false;
		
		for(Pessoa p : pessoas) {
			if(p instanceof Funcionario) {
			Funcionario func = (Funcionario) p;
			if(func.calcularSalario() > 3000) {
				System.out.println(func.getInfo());
				encontrouFuncionario = true;
				}
			}
		}
	if(!encontrouFuncionario) {
		System.out.println("Nenhum funcionário com salário acima de R$3000 foi encontrado.");
	    }
	}
	private static void calcularMaiorBonus() {
		System.out.println("\n---------------- RELATORIO: FUNCIONARIO COM MAIOR BÔNUS ----------------");
		
		Funcionario funcionarioVencedor = null;
		double maiorBonus = -1;
		
		for(Pessoa p : pessoas) {
			if(p instanceof Funcionario) {
				Funcionario func = (Funcionario) p;
				
				if(func.getBonus() > maiorBonus) {
					maiorBonus = func.getBonus();
					funcionarioVencedor = func;
					
				}	
			}
		}
		if(funcionarioVencedor != null) {
			System.out.println("O Funcionario com Maior bônus é:");
			System.out.println(funcionarioVencedor.getInfo());
		}else {
			System.out.println("Nenhum funcionário cadastrado para verificar o bônus.");
		}
	}
}
