public class ContaCorrente extends Conta {
    public ContaCorrente(Cliente cliente, int agencia, int numero) {
        super(cliente, agencia, numero);
    }

    @Override
    public void sacar(double valor) {
        super.sacar(valor);

        double taxaSaque = 0.25;

        double operacaoTaxa = (taxaSaque / 100) * valor;
        double valorFinal = valor - operacaoTaxa;
        System.out.println("Taxa de serviço aplicada, valor descontado: " + operacaoTaxa + "\nValor de saque: " + valorFinal);
    }
}
