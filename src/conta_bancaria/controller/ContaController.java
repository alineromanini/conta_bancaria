
package conta_bancaria.controller;

import java.util.ArrayList;
import java.util.List;

import conta_bancaria.model.Conta;
import conta_bancaria.repository.ContaRepository;

//essa classe foi criada para implementar a interface repository
public class ContaController implements ContaRepository {

	private List<Conta> listaContas = new ArrayList<Conta>();
	int numero = 0;

	@Override
	public void listarTodas() {
		for (var conta : listaContas) {
			conta.visualizar();
		}

	}

	@Override
	public void cadastrar(Conta conta) {
		listaContas.add(conta); // pra adicionar o numero da conta na coleção listaContas
		System.out.println("\n 🙌 Conta cadastrada com sucesso!"); //Windows + . para colocar emoji

	}

	@Override
	public void atualizar(Conta conta) {
		var buscarConta = buscarNaCollection(conta.getNumero());
		
		if(buscarConta != null) {
				listaContas.set(listaContas.indexOf(buscarConta), conta); //o array listaContas altera através da collection set
				//o dado (conta)
				System.out.printf("A conta número: %d foi atualizada com sucesso!\n", conta.getNumero());
		
		} else {
			System.out.printf("A conta número: %d não foi atualizada com sucesso!", conta.getNumero());
		}


	}

	@Override
	public void procurarPorNumero(int numero) {


		var conta = buscarNaCollection(numero);
		if(conta != null) {
			conta.visualizar();
		} else {
			System.out.printf("A conta número: %d nã foi encontrada!\n", numero);
		}

	}

	@Override
	public void deletar(int numero) {
		var conta = buscarNaCollection(numero);
		if(conta != null) {
			if(listaContas.remove(conta) == true){
				System.out.printf("\n A conta número %d foi deletada com sucesso!", numero);
			}
		} else {
			System.out.printf("A conta número: %d nã foi encontrada!\n", numero);
		}

	}

	@Override
	public void sacar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void depositar(int numero, float valor) {
		// TODO Auto-generated method stub

	}

	@Override
	public void transferir(int numeroOrigem, int numeroDestino, float valor) {
		// TODO Auto-generated method stub

	}
	
	//Métodos auxiliares 
	//para gerar os numeros das contas automaticamente
	
	public int gerarNumero() {
		return ++ numero;
	}

	//para comparar conta
	public Conta buscarNaCollection(int numero) {
		for(var conta : listaContas) {
			if(conta.getNumero() == numero) { //vai comparar o numero da conta com os dados da coleção
				return conta; //se for igual vai 
				//exibir a conta
			}
		}
		
		return null; //return pertencente ao FOR e nao ao IF
	}
}
