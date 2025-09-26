package conta_bancaria;

import java.util.InputMismatchException;
import java.util.Scanner;

import conta_bancaria.controller.ContaController;
import conta_bancaria.model.Conta;
import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;

public class Menu {

	private static final Scanner leia = new Scanner(System.in); // private só pra ser utilizado dentro da classe Menu,
																// static é para não precisar instanciar os objetos
	// final é pra definir uma variável constante

	private static final ContaController contaController = new ContaController(); // cria objeto contaCntroller para ter
																					// acesso a todos
	// os métodos da ContaController

	public static void main(String[] args) {

		int opcao;

		criarContasTeste(); // chamando método para adicionar as contas na coleção

		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "********************************************************");
			// System.out.println("********************************************************");
			System.out.println("                                                        ");
			System.out.println("                   BANCO DIGIPAY                        ");
			System.out.println("                                                        ");
			System.out.println("********************************************************");
			System.out.println("                                                        ");
			System.out.println("                1 - Criar Conta                         ");
			System.out.println("                2 - Listar todas as Contas              ");
			System.out.println("                3 - Buscar Conta por Número             ");
			System.out.println("                4 - Atualizar Dados da Conta            ");
			System.out.println("                5 - Apagar Conta                        ");
			System.out.println("                6 - Sacar                               ");
			System.out.println("                7 - Depositar                           ");
			System.out.println("                8 - Transferir valores entre Contas     ");
			System.out.println("                0 - Sair                                ");
			System.out.println("                                                        ");
			System.out.println("********************************************************");
			System.out.println("Entre com a opção desejada:                             ");
			System.out.println("                                                        " + Cores.TEXT_RESET);

			try {
				opcao = leia.nextInt();
				leia.nextLine();
			} catch (InputMismatchException e) {
				opcao = -1;
				System.out.println("\nDigite um número entre 0 e 8");
				leia.nextLine();
			}

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco DigiPay - A sua Independência começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar conta\n");
				cadastrarConta();
				keypress();
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas\n" + Cores.TEXT_RESET);
				listarContas();
				keypress();
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da conta - por número\n");
				procurarContaPorNumero();

				keypress();
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da conta\n");
				keypress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a conta");
				deletarConta();
				keypress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n");
				keypress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n");
				keypress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas\n");
				keypress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\n Opção Inválida!\n" + Cores.TEXT_RESET);
				keypress();
				break;

			}
		}
	}

	public static void sobre() {
		System.out.println("\n*************************************************");
		System.out.println("\nProjeto Desenvolvido por: Aline Romanini");
		System.out.println("Generation Brasil - AlineSi@genstudents.org");
		System.out.println("https://github.com/alineromanini");
		System.out.println("***********************************************************");
	}

	public static void keypress() {
		System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para continuar");
		leia.nextLine();
	}

	public static void criarContasTeste() {
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Thuany Silva", 1000000.00f, 100000.00f));
		contaController.cadastrar(
				new ContaCorrente(contaController.gerarNumero(), 456, 1, "Marcia Condarco", 1000000.00f, 100000.00f));

	}

	private static void listarContas() {
		contaController.listarTodas(); // método listarContas está chamando método listarTodas
	}

	private static void cadastrarConta() {
		
		System.out.println("Digite o número da conta");
		int numero = leia.nextInt();
		
		System.out.println("Digite o número da agência");
		int agencia = leia.nextInt();
		
		System.out.println("Digite o tipo da conta (1- Conta corrente | 2 - Conta Poupança");
		int tipo = leia.nextInt();
		
		System.out.println("Digite o nome do titular");
		leia.skip("\\R"); 
		String titular = leia.nextLine();
		
		System.out.println("Digite o saldo inicial");
		float saldo = leia.nextFloat();
		
		switch(tipo) {
		case 1 -> {
			System.out.println("Digite o limite inicial: ");
			float limite = leia.nextFloat();
			contaController.cadastrar(new ContaCorrente(contaController.gerarNumero(), agencia, tipo, titular, saldo, limite ));
		}
		
			case 2 -> {
				System.out.println("Digite o aniversário da conta: ");
				int aniversario = leia.nextInt();
						contaController.cadastrar(new ContaPoupanca(contaController.gerarNumero(),agencia, tipo,titular, saldo, aniversario ));
			}
			
			default -> System.out.println(Cores.TEXT_BLACK + "Tipo de conta inválido!" + Cores.TEXT_RESET);
			
			
		}
		

		
	}

	private static void procurarContaPorNumero() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		contaController.procurarPorNumero(numero);

	}

	private static void deletarConta() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Conta conta = contaController.buscarNaCollection(numero);

		if (conta != null) { // valida se a conta existe antes de excluí-la

			System.out.print("\nTem certeza que deseja excluir esta conta? (S/N): ");
			String confirmacao = leia.nextLine();

			if (confirmacao.equalsIgnoreCase("S")) {
				contaController.deletar(numero);
			} else {
				System.out.println("\nOperação cancelada!");
			}

		} else {
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		}
	}
		
	

	private static void atualizarConta() {
		System.out.println("Digite o número da conta: ");
		int numero = leia.nextInt();
		leia.nextLine();

		Conta conta = contaController.buscarNaCollection(numero);

		if (conta != null) {
			int agencia = conta.getAgencia(); //pega o valor atual da colecao
			String titular = conta.getTitular();
			int tipo = conta.getTipo();
			float saldo = conta.getSaldo();
			
			System.out.printf("A Agência atual: %d\nNova Agência (Pressione ENTER para manter o valor atual): ", agencia);
			String entrada = leia.nextLine();
			agencia = entrada.isEmpty() ? agencia : Integer.parseInt(entrada); //if
			
			System.out.printf("O nome do Titular atual: %s\nNovo Titular (Pressione ENTER para manter o valor atual): ", titular);
			entrada = leia.nextLine();
			titular = entrada.isEmpty() ? titular : entrada;
						
			System.out.printf("O Saldo atual: %.2f\nNovo Saldo (Pressione ENTER para manter o valor atual): ", saldo);
			entrada = leia.nextLine();
			saldo = entrada.isEmpty() ? saldo : Float.parseFloat(entrada);
			
			switch(tipo) {
			case 1 ->{
				float limite = ((ContaCorrente) conta).getLimite();//casting pra fazer a conta passar pra conta corrente
				
				
				System.out.printf("O Limite atual é: %.2f\nNovo Limite (Pressione ENTER para manter o valor atual): ", limite);
				entrada = leia.nextLine();
				limite = entrada.isEmpty() ? limite : Float.parseFloat(entrada);
				contaController.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
			}
			case 2 -> {
				
				int aniversario = ((ContaPoupanca) conta).getAniversario();
				
				System.out.printf("O Aniversário atual é: %d\nNovo Aniversário (Pressione ENTER para manter o valor atual): ", aniversario);
				entrada = leia.nextLine();
				aniversario = entrada.isEmpty() ? aniversario : Integer.parseInt(entrada);
				contaController.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
			}
			default -> System.out.println(Cores.TEXT_RED + "Tipo de conta inválido!" + Cores.TEXT_RESET);
			}
 
			
		}else {
			System.out.printf("\nA conta número %d não foi encontrada!", numero);
		}
	

		
		}
	}
