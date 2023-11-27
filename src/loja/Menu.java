package loja;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import loja.model.MovelCadeira;
import loja.model.MovelMesa;
import loja.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		MovelCadeira cadeira1 = new MovelCadeira(12, "Java Cadeira de Jantar, Azul", 300.00f, 180.00f, 1, 46.0f);
		cadeira1.visualizar();
		
		MovelMesa mesa1 = new MovelMesa(41, "Gen Mesa de Centro, Verde", 175.90f, 100.00f, 2, 1);
		mesa1.visualizar();
		
		while (true) {

			int opcao;

			// Menu
			System.out.print(Cores.TEXT_RESET);
			System.out.println("========================================");
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("|                                      |");
			System.out.println("|                 MENU                 |");
			System.out.println("|                                      |");
			System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
			System.out.println("|                                      |");
			System.out.println("|  1 - Cadastrar Produto               |");
			System.out.println("|  2 - Listar Todos os Produtos        |");
			System.out.println("|  3 - Buscar Produto por Número       |");
			System.out.println("|  4 - Atualizar Dados do Produto      |");
			System.out.println("|  5 - Apagar Produto                  |");
			System.out.println("|  0 - Sair                            |");
			System.out.println("|                                      |");
			System.out.println("└──────────────────────────────────────┘");
			System.out.print("\n→ Digite uma opção: ");

			try {
				opcao = leia.nextInt();
				leia.nextLine(); // Limpa o buffer
			} catch (InputMismatchException e) {
				opcao = 99;
			}

			if (opcao == 0) {
				sobre();
				System.exit(0);
			}

			switch (opcao) {

			case 1:

				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|            CRIAR PRODUTO             |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.println("| // TODO                              |");
				System.out.println("└──────────────────────────────────────┘");

				keyPress();
				break;

			case 2:

				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|       LISTAR TODOS OS PRODUTOS       |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.println("| // TODO                              |");
				System.out.println("└──────────────────────────────────────┘");

				keyPress();
				break;

			case 3:

				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|  BUSCAR DADOS DO PRODUTO POR NÚMERO  |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.println("| // TODO                              |");
				System.out.println("└──────────────────────────────────────┘");

				keyPress();
				break;

			case 4:

				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|      ATUALIZAR DADOS DO PRODUTO      |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.println("| // TODO                              |");
				System.out.println("└──────────────────────────────────────┘");

				keyPress();
				break;

			case 5:

				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|            APAGAR PRODUTO            |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.println("| // TODO                              |");
				System.out.println("└──────────────────────────────────────┘");
				keyPress();
				break;

			default:

				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_RED_BACKGROUND_BRIGHT);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|           OPÇÃO INVÁLIDA!            |");
				System.out.println("└──────────────────────────────────────┘");

				keyPress();
				break;

			}

		}

	}

	public static void sobre() {
		System.out.println(Cores.TEXT_RESET);
		System.out.println("========================================");
		System.out.println(Cores.TEXT_BLACK_BOLD + Cores.ANSI_WHITE_BACKGROUND);
		System.out.println("┌──────────────────────────────────────┐");
		System.out.println("| Projeto Desenvolvido por:            |");
		System.out.println("| Gabriel Sponda Freitas Bettarello    |");
		System.out.println("| github.com/gabrielsponda             |");
		System.out.println("└──────────────────────────────────────┘");
	}

	public static void keyPress() {

		try {
			System.out.println(Cores.TEXT_RESET);
			System.out.println("========================================");
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
			System.out.println("Pressione qualquer tecla para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida.");
		}
		
	}

}