package conta_bancaria.model;

public class ContaPoupanca extends Conta {

	// definir atributo aniversario
	private int aniversario;

	public ContaPoupanca(int numero, int agencia, int tipo, String titular, float saldo, int aniversario) {
		super(numero, agencia, tipo, titular, saldo);

		this.aniversario = aniversario;
	}

	// método Get e Set
	public int getAniversario() {
		return aniversario;
	}

	public void setAniversario(int aniversario) {
		this.aniversario = aniversario;
	}

	// sobrescrita
	@Override
	public void visualizar() {

		super.visualizar();
		System.out.printf("Aniversário da conta: %d%n", this.aniversario);

	}

}
