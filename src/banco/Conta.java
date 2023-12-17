package banco;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Conta {

    // Definindo atributos da classe
    private int numeroConta;
    private BigDecimal saldo;
    private ArrayList transacoes;

    private Banco banco;
    private ArrayList<Cliente> clientes;

    // Construtor vazio que inicializa o saldo com zero e lista de transações
    public Conta() {
        this.saldo = BigDecimal.ZERO;
        this.transacoes = new ArrayList<>();
        clientes = new ArrayList<Cliente>();
    }

    // Definindo método sacarValor
    public void sacarValor(BigDecimal valor) throws ContaException {
        if(valor.signum() == -1){
            throw new IllegalArgumentException("Não foi possível realizar a operação, informe um valor positivo.");
        }

        if(valor.compareTo(saldo) <= 0){
            saldo = saldo.subtract(valor);
            String msg  = ("Saque realizado no valor de R$"+valor);
            transacoes.add(msg);
            System.out.println(msg);
        }else{
            throw new ContaException("Saldo insuficiente. Seu saldo: R$"+saldo);
        }
    }

    // Definindo método depositarValor
    public void depositarValor(BigDecimal valor){
        if(valor.signum() == -1){
            throw new IllegalArgumentException("Não foi possível realizar a operação, informe um valor positivo.");
        }
        saldo = saldo.add(valor);
        String msg = "Depósito realizado no valor de R$" + valor;
        transacoes.add(msg);
        System.out.println(msg);
    }

    // Adicionando Cliente vinculado a conta
    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    // Retornando quantidade de Clientes da conta
    public int quantidadeClientes(){
        return clientes.size();
    }

    //  -- Getters e Setters --
    public Cliente getCliente(int posicao){
        return clientes.get(posicao);
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public ArrayList getTransacoes() {
        return transacoes;
    }

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }
}