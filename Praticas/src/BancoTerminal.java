public class BancoTerminal {

    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("João Gabriel", "121.361.649-29");
        Cliente cliente2 = new Cliente("Maria Souza", "555.666.777-88");

        Conta ccJoao = new ContaCorrente(cliente1, 1001, 1);
        Conta cpMaria = new ContaPoupanca(cliente2, 1001, 2);

        System.out.println("### Contas criadas! ###");
        ccJoao.imprimirExtrato();
        cpMaria.imprimirExtrato();

        System.out.println("\n### Realizando depósitos... ###");
        ccJoao.depositar(500.0);
        cpMaria.depositar(1200.50);

        System.out.println("\n### Saldos após depósito ###");
        ccJoao.imprimirExtrato();
        cpMaria.imprimirExtrato();

        System.out.println("\n### Realizando um saque na conta do João... ###");
        ccJoao.sacar(150.0);

        System.out.println("\n### Realizando uma transferência do João para a Maria... ###");
        ccJoao.transferir(100.0, cpMaria);

        System.out.println("\n### Saldos finais ###");
        ccJoao.imprimirExtrato();
        cpMaria.imprimirExtrato();
    }
}