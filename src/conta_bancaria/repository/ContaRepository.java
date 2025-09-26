package conta_bancaria.repository;

import conta_bancaria.model.Conta;

public interface ContaRepository { // a interface ja é abstrata por natureza, entao nao precisa colocar o abstract

	// Métodos do CRUD

	public void listarTodas(); 
	public void cadastrar(Conta conta);
	public void atualizar(Conta conta);
	public void procurarPorNumero(int numero);
	public void deletar(int numero);

	// Métodos bancários

	public void sacar(int numero, float valor); //sabendo o numero, já se sabe qual o saldo
	public void depositar(int numero, float valor);
	public void transferir(int numeroOrigem, int numeroDestino, float valor);

}
