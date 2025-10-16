package AtividadePOOHeranca;

import java.util.ArrayList;
import java.util.Scanner;


public class SistemaApp {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Pessoa> pessoas = new ArrayList<>();

    public static void main(String[] args) {
        boolean executando = true;
        System.out.println("----- SISTEMA DE PESSOAS -----");
        
        while (executando) {
            mostrarMenu();
            String opcao = scanner.nextLine();

            switch (opcao) {
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

    public static void mostrarMenu() {
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
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("É Aluno (A) ou Funcionário (F)? ");
        String tipo = scanner.nextLine().trim().toUpperCase();

        if (tipo.equals("A")) {
        	System.out.print("Quantas notas deseja cadastrar para este aluno? ");
            int qtdNotas = Integer.parseInt(scanner.nextLine());
            
            double[] notasDoAluno = new double[qtdNotas];
            
            for(int i = 0; i < qtdNotas; i++) {
            	System.out.println("Digite a nota " + (i + 1) + ": ");
            	notasDoAluno[i] = Double.parseDouble(scanner.nextLine());
            }
            

            pessoas.add(new Aluno(nome, cpf, notasDoAluno));
            System.out.println("Aluno cadastrado com Sucesso!");

        } else if (tipo.equals("F")) {
            System.out.print("Digite o Salário Base: ");
            double salario = Double.parseDouble(scanner.nextLine());

            System.out.print("Digite valor do Bônus: ");
            double bonus = Double.parseDouble(scanner.nextLine());

            pessoas.add(new Funcionario(nome, cpf, salario, bonus));

        } else {
            System.out.println("Tipo inválido, Pessoa não cadastrada.");
        }
    }

    private static void listarPessoas() {
        if (pessoas.isEmpty()) {
            System.out.println("Nenhuma pessoa cadastrada!");
        } else {
            System.out.println("\n========== Lista de Pessoas ==========");
            for (Pessoa p : pessoas) {
                System.out.println(p.getInfo());
            }
        }
    }

    private static void removerPessoa() {
        System.out.print("Digite o CPF da pessoa que deseja remover: ");
        String cpf = scanner.nextLine();

        Pessoa pessoaParaRemover = null;
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpf)) {
                pessoaParaRemover = p;
                break;
            }
        }
        
        if (pessoaParaRemover != null) {
            pessoas.remove(pessoaParaRemover);
            System.out.println("Pessoa removida com sucesso");
        } else {
            System.out.println("Nenhuma pessoa encontrada com esse CPF!");
        }
    }

    private static void buscarPessoaPeloCPF() {
        System.out.print("Digite o CPF da pessoa que deseja buscar: ");
        String cpf = scanner.nextLine();

        boolean encontrada = false;
        for (Pessoa p : pessoas) {
            if (p.getCpf().equals(cpf)) {
                System.out.println("Pessoa encontrada:");
                System.out.println(p.getInfo());
                encontrada = true;
                break;
            }
        }
        
        // CORRIGIDO - A verificação agora é feita DEPOIS do 'for'
        if (!encontrada) {
            System.out.println("Nenhuma pessoa encontrada com esse CPF!");
        }
    }

    private static void mostrarBoletimGeral() {
        System.out.println("\n--- Boletim Geral dos Alunos ---");
        boolean encontrouAluno = false;
        
        
        System.out.println("\n🟩 Alunos Aprovados:");
        boolean encontrouAprovados = false;
        for (Pessoa p : pessoas) {
            if (p instanceof Aluno) {
            	encontrouAluno = true;
                Aluno aluno = (Aluno) p;
                if (aluno.getMedia() >= 60.0) {
                    System.out.println(aluno.getInfo());
                    encontrouAprovados = true;
                }
            }
        }

        if (!encontrouAprovados && encontrouAluno) { // Só mostra se houver alunos, mas nenhum aprovado
            System.out.println("Nenhum aluno aprovado.");
        }
        System.out.println("\n🟩 Alunos Reprovados:");
        boolean encontrouReprovado = false;
        for(Pessoa p : pessoas) {
        	if(p instanceof Aluno) {
        		Aluno aluno = (Aluno) p;
        		if(aluno.getMedia() < 60.0) {
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
    	System.out.println("\n-------- Relario: Funcionários com Salário > R$3000 ---");
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
    private static void calcularMaiorBonus(){
    	System.out.println("\n------ Relatorio: Funcionario com Maior Bônus----");
    	// 1. Variáveis de memória para guardar o "campeão"
    	Funcionario funcionarioVencedor = null;
    	double maiorBonus = -1; // Começamos com -1 para garantir que o primeiro bônus válido seja maior
    	
    	// 2. Percorre a lista
    	for(Pessoa p : pessoas) {
    		if(p instanceof Funcionario) {
    			Funcionario func = (Funcionario) p;
    			
    			 // 3. Compara o bônus do funcionário atual com o maior já visto
    			if(func.getBonus() > maiorBonus) {
    				
    				maiorBonus = func.getBonus();// Atualiza o valor do maior bônus
    				funcionarioVencedor = func; // Guarda o funcionário vencedor
    				
    			}
    			
    		}
    		
    	}
    	 // 5. No final, verifica se encontramos um vencedor
    	if(funcionarioVencedor != null) {
    		System.out.println("O Funcionario com maior bônus é:");
    		System.out.println(funcionarioVencedor.getInfo());
    	}else {
    		System.out.println("Nenhum funcionário cadastrado para verificar o bônus.");
    	}
    	
    }
} 