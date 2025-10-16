package AtividadePOOHeranca;

public class Pessoa {
	private String nome;
	private String cpf;
	
	public Pessoa (String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}
		
		// Getters
	    public String getNome() {
	        return nome;
	    }

	    public String getCpf() {
	        return cpf;
	    }

	    // Método que pode ser sobrescrito pelas subclasses
	    public String getInfo() {
	        return "Nome: " + nome + " | CPF: " + formatarCPF();
	    }
	    private String formatarCPF() {
	    	String cpfSemFormaro = this.cpf;
	    	
	    	String parte1 = cpfSemFormaro.substring(0, 3);
	    	String parte2 = cpfSemFormaro.substring(3, 6);
	    	String parte3 = cpfSemFormaro.substring(6, 9);
	    	String parte4 = cpfSemFormaro.substring(9, 11);
	    	
	    		return parte1 + "." + parte2 + "." + parte3 + "-" + parte4;
	    	
	    }
		
	}
	


