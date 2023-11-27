package loja;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

import loja.controller.MovelController;
import loja.model.Movel;
import loja.model.MovelCadeira;
import loja.model.MovelMesa;
import loja.util.Cores;

public class Menu {

	static Scanner leia = new Scanner(System.in);

	public static void main(String[] args) {
		
		MovelController moveis = new MovelController();

		int opcao, codigo, categoria, estoque, quantidade;
		String nome;
		float preco, custo;
		
		while (true) {

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
			System.out.println("|  3 - Buscar Produto por Código       |");
			System.out.println("|  4 - Atualizar Dados do Produto      |");
			System.out.println("|  5 - Apagar Produto                  |");
			System.out.println("|  6 - Vender Produto                  |");
			System.out.println("|  7 - Comprar Produto                 |");
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
				System.out.println("| Forneça as informações necessárias.  |");
				System.out.println("└──────────────────────────────────────┘");
				
				System.out.print("\n→ Digite o código do produto: ");
				codigo = leia.nextInt();
				
				System.out.print("\n→ Digite o nome do produto: ");
				leia.skip("\\R");
				nome = leia.nextLine();
				
				System.out.print("\n→ Digite o preço de venda do produto: ");
				preco = leia.nextFloat();
				
				System.out.print("\n→ Digite o custo de aquisição do produto: ");
				custo = leia.nextFloat();
				
				System.out.print("\n→ Para a categoria, digite 1 para cadeira ou 2 para mesa: ");
				categoria = leia.nextInt();
				
				System.out.print("\n→ Digite a quantidade de itens em estoque do produto: ");
				estoque = leia.nextInt();

				switch (categoria) {
				
				case 1 -> {
					System.out.print("\n→ Digite a altura do assento: ");
					float alturaAssento = leia.nextFloat();
					moveis.cadastrar(new MovelCadeira(codigo, nome, preco, custo, categoria, alturaAssento, estoque));
				}
				
				case 2 -> {
					System.out.println("\n→ Para o formato do tampo, digite 1 para redondo, 2 para quadrado e 3 para retangular: ");
					int formatoTampo = leia.nextInt();
					moveis.cadastrar(new MovelMesa(codigo, nome, preco, custo, categoria, formatoTampo, estoque));
				}
				
				default -> throw new IllegalArgumentException("Categoria inválida!");
				
				}

				keyPress();
				break;

			case 2:

				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|       LISTAR TODOS OS PRODUTOS       |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.printf("|        Total de produtos: %02d         |\n", moveis.getQuantidadeCodigos());
				System.out.println("└──────────────────────────────────────┘");
				
				moveis.listarTodos();

				keyPress();
				break;

			case 3:

				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|  BUSCAR DADOS DO PRODUTO POR NÚMERO  |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.println("| Informe o código do produto.         |");
				System.out.println("└──────────────────────────────────────┘");

				System.out.print("\n→ Digite o código do produto: ");
				codigo = leia.nextInt();
				moveis.procurarPorCodigo(codigo);
				
				keyPress();
				break;

			case 4:

				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|      ATUALIZAR DADOS DO PRODUTO      |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.println("| Informe o código do produto.         |");
				System.out.println("└──────────────────────────────────────┘");
				
				System.out.print("\n→ Digite o código do produto: ");
				codigo = leia.nextInt();
				
				Optional<Movel> movel = moveis.buscarNaCollection(codigo);
				
				if (moveis.buscarNaCollection(codigo).isPresent()) {
					System.out.println(Cores.TEXT_RESET);
					System.out.println("----------------------------------------");
					System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
					System.out.println("┌──────────────────────────────────────┐");
					System.out.println("|             NOVOS DADOS              |");
					System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
					System.out.println("| Forneça as informações necessárias.  |");
					System.out.println("└──────────────────────────────────────┘");

					System.out.print("\n→ Digite o nome do produto: ");
					leia.skip("\\R");
					nome = leia.nextLine();
					
					System.out.print("\n→ Digite o preço de venda do produto: ");
					preco = leia.nextFloat();
					
					System.out.print("\n→ Digite o custo de aquisição do produto: ");
					custo = leia.nextFloat();
					
					System.out.print("\n→ Digite a quantidade de itens em estoque do produto: ");
					estoque = leia.nextInt();
					
					categoria = movel.get().getCategoria();
					
					switch (categoria) {
					
					case 1 -> {
						System.out.print("\n→ Digite a altura do assento: ");
						float alturaAssento = leia.nextFloat();
						moveis.atualizar(new MovelCadeira(codigo, nome, preco, custo, categoria, alturaAssento, estoque));
					}
					
					case 2 -> {
						System.out.println("\n→ Para o formato do tampo, digite 1 para redondo, 2 para quadrado e 3 para retangular: ");
						int formatoTampo = leia.nextInt();
						moveis.atualizar(new MovelMesa(codigo, nome, preco, custo, categoria, formatoTampo, estoque));
					}
					
					default -> throw new IllegalArgumentException("Categoria inválida!");
					
					}

				} else {
					System.out.println(Cores.TEXT_RESET);
					System.out.println("----------------------------------------");
					System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_RED_BACKGROUND_BRIGHT);
					System.out.println("┌──────────────────────────────────────┐");
					System.out.println("|       PRODUTO NÃO ENCONTRADO!        |");
					System.out.println("└──────────────────────────────────────┘");
				}

				keyPress();
				break;
				
			case 5:
				
				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|            APAGAR PRODUTO            |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.println("| Informe o código do produto.         |");
				System.out.println("└──────────────────────────────────────┘");
				
				System.out.print("\n→ Digite o código do produto: ");
				codigo = leia.nextInt();
				moveis.deletar(codigo);
				
				keyPress();
				break;

			case 6:

				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|            VENDER PRODUTO            |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.println("| Informe o código do produto.         |");
				System.out.println("└──────────────────────────────────────┘");
				
				System.out.print("\n→ Digite o código do produto: ");
				codigo = leia.nextInt();
				
				System.out.print("\n→ Digite a quantidade a ser vendida: ");
				quantidade = leia.nextInt();
				
				moveis.vender(codigo, quantidade);
				
				keyPress();
				break;
				
			case 7:
				
				System.out.println(Cores.TEXT_RESET);
				System.out.println("========================================");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|           COMPRAR PRODUTO            |");
				System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
				System.out.println("| Informe o código do produto.         |");
				System.out.println("└──────────────────────────────────────┘");
				
				System.out.print("\n→ Digite o código do produto: ");
				codigo = leia.nextInt();
				
				System.out.print("\n→ Digite a quantidade a ser comprada: ");
				quantidade = leia.nextInt();
				
				moveis.comprar(codigo, quantidade);
				
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