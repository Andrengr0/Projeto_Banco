package banco;

import java.util.ArrayList;

public class Banco {

    // Definindo atributos da classe
    private String nome;
    private int codigo;

    private ArrayList<Cliente> clientes;
    private ArrayList<Conta> contas;

    public Banco(){
        clientes = new ArrayList<Cliente>();
        contas = new ArrayList<Conta>();
    }

    public void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    }

    // -- Definindo Getters e Setters --
    public Cliente getCliente(int posicao){
        return clientes.get(posicao);
    }

    public int quantidadeClientes(){
        return clientes.size();
    }

    public void adicionarConta(Conta conta){
        contas.add(conta);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
}
