package conta_bancaria;

import java.util.Scanner;

import conta_bancaria.model.Conta;
import conta_bancaria.util.Cores;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;
		
		// Instanciar objetos da classe Conta
		
		Conta c1 = new Conta(1, 123, 1, "Cintia Dourado", 500000.00f);
		
		Conta c2 = new Conta(1, 123, 2, "Priscila Lins", 500000.00f);
		
		System.out.println("O saldo da conta é: " + c1.getSaldo());
		
		c1.setSaldo(600000.00f);
		
		System.out.println("O saldo da conta é: " + c1.getSaldo());
		
		c1.visualizar();
		
		c2.visualizar();
		
		//sacar
		System.out.println(c1.sacar(1000));
		System.out.println("O saldo da conta é: " + c1.getSaldo());
		
		System.out.println(c2.sacar(1000000));
		System.out.println("O saldo da conta é: " + c2.getSaldo());
		
		//depositar
		
		c1.depositar(5000); //não tem sys out porque é void
		System.out.println("O saldo da conta é: " + c1.getSaldo());
		

		while (true) {
			
			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "********************************************************");
			System.out.println("********************************************************");
			System.out.println("                                                        ");
			System.out.println("                   BANCO DIGIPAY                        ");
			System.out.println("                                                        ");
			System.out.println("********************************************************");
			System.out.println("                                                        ");
			System.out.println("                1 - Criar Conta                         ");
			System.out.println("                2 - Listas todas as Contas              ");
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
			System.out.println("                                                        "+ Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 0) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco DigiPay - A sua Independência começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Criar conta\n");
				break;
			case 2:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Listar todas as contas\n");
				break;
			case 3:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Consultar dados da conta - por número\n");
				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Atualizar dados da conta\n");
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Apagar a conta");
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Saque\n");
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Depósito\n");
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE_BOLD + "Transferência entre contas\n");
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\n Opção Inválida!\n" + Cores.TEXT_RESET);
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
}
