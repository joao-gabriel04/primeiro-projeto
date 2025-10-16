public class Teste implements TaxaDesconto {


    @Override
    public void taxa(double valor) {
        double taxaSaque = 0.25;

        double operacaoTaxa = (taxaSaque / 100) * valor;
        double valorFinal = valor - operacaoTaxa;
        System.out.println("Taxa de serviço aplicada, valor descontado: " + operacaoTaxa + "\nValor de saque: " + valorFinal);
    }
}
