package bancoOperacoes;

import banco.Banco;
import banco.Cliente;
import banco.Conta;
import banco.ContaException;

import java.math.BigDecimal;
import java.util.Date;

public class App {
    public static void main(String[] args) throws ContaException {

        Banco banco1 = new Banco();
        banco1.setNome("Nubank");
        banco1.setCodigo(1234);


        Conta conta1 = new Conta();
        conta1.setNumeroConta(222222);
        conta1.setBanco(banco1);

        Cliente cliente1 = new Cliente();
        cliente1.setNome("Roberto");
        cliente1.setCPF("122.222.222-39");
        cliente1.setDataNascimento(new Date());

        Cliente cliente2 = new Cliente();
        cliente2.setNome("Maria");
        cliente2.setCPF("122.111.111-23");
        cliente2.setDataNascimento(new Date());


        cliente1.setBanco(banco1);
        cliente1.setConta(conta1);
        banco1.adicionarCliente(cliente1);

        cliente2.setBanco(banco1);
        cliente2.setConta(conta1);
        banco1.adicionarCliente(cliente2);

        conta1.adicionarCliente(cliente1);
        conta1.adicionarCliente(cliente2);

        conta1.depositarValor(BigDecimal.valueOf(150));
        conta1.depositarValor(BigDecimal.valueOf(100));
        conta1.sacarValor(BigDecimal.valueOf(50));


        System.out.println("Clientes do nubank: ");
        for(int i=0; i<banco1.quantidadeClientes(); i++){
            System.out.println(banco1.getCliente(i).getNome());
        }

        System.out.println("---------------------------------");

        System.out.println("Clientes da conta 1");
        for(int i=0; i<conta1.quantidadeClientes(); i++){
            System.out.println(conta1.getCliente(i).getNome());
        }

        System.out.println("---------------------------------");

        System.out.print("Transações na conta1: \n");
        for(int i=0; i<conta1.getTransacoes().size(); i++){
            System.out.println(conta1.getTransacoes().get(i));
        }

    }
}
