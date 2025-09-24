package conta_bancaria.model;

public class ContaCorrente extends Conta { 
	
	//definir atributo limite
		private float limite;
	
	//ContaCorrente é uma herança (subclasse) da classe Conta
		//java não aceita herança múltipla (mais de uma classe)
	
	public ContaCorrente(int numero, int agencia, int tipo, String titular, float saldo, float limite) {
		super(numero, agencia, tipo, titular, saldo); //limite nao foi acrescentado automaticamente pq é específico da classe ContaCorrente
	this.limite = limite;
	}

	public float getLimite() {
		return limite;
	}

	public void setLimite(float limite) {
		this.limite = limite;
	}
	
	@Override
	public boolean sacar(float valor) {
		if(this.getSaldo() + this.getLimite() < valor) {
			System.out.println("\nSaldo Insuficiente!");
			return false;
		}
		
		this.setSaldo(this.getSaldo() - valor);
		return true;
	}
	
	//cria uma 'cópia' do método visualizar de Conta
	@Override //anotação pra indicar que o método está sendo sobrescrito (boas práticas)
	//método (visualizar) foi sobrescrito da superclasse (conta)
	public void visualizar() {
		super.visualizar();
		System.out.printf("Limite da conta: R$ %.2f%n", this.limite);
	}
	

	


	
	
}
