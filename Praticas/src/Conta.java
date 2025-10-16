// 'abstract' pois esta classe não deve ser instanciada diretamente.
// Ela serve apenas como um modelo para suas classes filhas.
public abstract class Conta {

    // 'protected' permite que as classes filhas acessem estes atributos diretamente.
    protected int agencia;
    protected int numero;
    protected double saldo;
    protected Cliente cliente;

    public Conta(Cliente cliente, int agencia, int numero) {
        this.cliente = cliente;
        this.agencia = agencia;
        this.numero = numero;
        this.saldo = 0.0; // Toda conta começa com saldo zero
    }

    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
            System.out.println("Saque de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito de R$" + valor + " realizado com sucesso.");
        } else {
            System.out.println("Valor de depósito inválido.");
        }
    }

    public void transferir(double valor, Conta contaDestino) {
        if (valor > 0 && this.saldo >= valor) {
            this.sacar(valor);
            contaDestino.depositar(valor);
            System.out.println("Transferência de R$" + valor + " para a conta " + contaDestino.numero + " realizada.");
        } else {
            System.out.println("Transferência não realizada. Saldo insuficiente ou valor inválido.");
        }
    }

    public void imprimirExtrato() {
        System.out.println("--- Extrato da Conta ---");
        System.out.println("Cliente: " + this.cliente.getNome());
        System.out.println("Agência: " + this.agencia);
        System.out.println("Número: " + this.numero);
        System.out.printf("Saldo: R$ %.2f\n", this.saldo);
        System.out.println("------------------------");
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }
}