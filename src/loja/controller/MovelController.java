package loja.controller;

import java.util.ArrayList;
import java.util.Optional;

import loja.model.Movel;
import loja.repository.MovelRepository;
import loja.util.Cores;

public class MovelController implements MovelRepository {

	private ArrayList<Movel> listaMoveis = new ArrayList<Movel>();
	
	private int quantidadeCodigos = 0;

	public int getQuantidadeCodigos() {
		return quantidadeCodigos;
	}

	public void setQuantidadeCodigos(int quantidadeCodigos) {
		this.quantidadeCodigos = quantidadeCodigos;
	}

	@Override
	public void cadastrar(Movel movel) {
		listaMoveis.add(movel);
		System.out.println(Cores.TEXT_RESET);
		System.out.println("----------------------------------------");
		System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_GREEN_BACKGROUND_BRIGHT);
		System.out.println("┌──────────────────────────────────────┐");
		System.out.printf("|    CÓDIGO %02d CRIADO COM SUCESSO!     |\n", movel.getCodigo());
		System.out.println("└──────────────────────────────────────┘");
		this.setQuantidadeCodigos(quantidadeCodigos + 1);
	}

	@Override
	public void listarTodos() {
		for (var movel : listaMoveis) {
			movel.visualizar();
		}
	}

	@Override
	public void procurarPorCodigo(int codigo) {
		Optional<Movel> movel = buscarNaCollection(codigo);

		if (movel.isPresent()) {
			movel.get().visualizar();
		} else {
			System.out.println(Cores.TEXT_RESET);
			System.out.println("----------------------------------------");
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_RED_BACKGROUND_BRIGHT);
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("|       PRODUTO NÃO ENCONTRADO!        |");
			System.out.println("└──────────────────────────────────────┘");
		}

	}

	@Override
	public void atualizar(Movel movel) {
		Optional<Movel> movelProcurado = buscarNaCollection(movel.getCodigo());

		if (movelProcurado.isPresent()) {
			listaMoveis.set(listaMoveis.indexOf(movelProcurado.get()), movel);
			System.out.println(Cores.TEXT_RESET);
			System.out.println("----------------------------------------");
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_GREEN_BACKGROUND_BRIGHT);
			System.out.println("┌──────────────────────────────────────┐");
			System.out.printf("|  CÓDIGO %02d ATUALIZADO COM SUCESSO!   |\n", movel.getCodigo());
			System.out.println("└──────────────────────────────────────┘");
		} else {
			System.out.println(Cores.TEXT_RESET);
			System.out.println("----------------------------------------");
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_RED_BACKGROUND_BRIGHT);
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("|       PRODUTO NÃO ENCONTRADO!        |");
			System.out.println("└──────────────────────────────────────┘");
		}

	}

	@Override
	public void deletar(int codigo) {
		Optional<Movel> movel = buscarNaCollection(codigo);

		if (movel.isPresent()) {
			if (listaMoveis.remove(movel.get()) == true) {
				System.out.println(Cores.TEXT_RESET);
				System.out.println("----------------------------------------");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_GREEN_BACKGROUND_BRIGHT);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.printf("|   CÓDIGO %02d DELETADO COM SUCESSO!    |\n", codigo);
				System.out.println("└──────────────────────────────────────┘");
				this.setQuantidadeCodigos(quantidadeCodigos - 1);
			}
		} else {
			System.out.println(Cores.TEXT_RESET);
			System.out.println("----------------------------------------");
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_RED_BACKGROUND_BRIGHT);
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("|       PRODUTO NÃO ENCONTRADO!        |");
			System.out.println("└──────────────────────────────────────┘");
		}
	}
	
	@Override
	public void vender(int codigo, int quantidade) {
		Optional<Movel> movel = buscarNaCollection(codigo);
		
		if (movel.isPresent()) {
			if (movel.get().getEstoque() < quantidade) {
				System.out.println(Cores.TEXT_RESET);
				System.out.println("----------------------------------------");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_RED_BACKGROUND_BRIGHT);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.println("|        PRODUTO SEM ESTOQUE!          |");
				System.out.println("└──────────────────────────────────────┘");
			} else {
				System.out.println(Cores.TEXT_RESET);
				System.out.println("----------------------------------------");
				System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_GREEN_BACKGROUND_BRIGHT);
				System.out.println("┌──────────────────────────────────────┐");
				System.out.printf("|%02d UNIDADES DO PRODUTO %02d COMPRADOS!|\n", quantidade, codigo);
				System.out.println("└──────────────────────────────────────┘");
				movel.get().setEstoque(movel.get().getEstoque() + quantidade);
			}
		} else {
			System.out.println(Cores.TEXT_RESET);
			System.out.println("----------------------------------------");
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_RED_BACKGROUND_BRIGHT);
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("|       PRODUTO NÃO ENCONTRADO!        |");
			System.out.println("└──────────────────────────────────────┘");
		}
	}

	@Override
	public void comprar(int codigo, int quantidade) {
		Optional<Movel> movel = buscarNaCollection(codigo);
		
		if (movel.isPresent()) {
			System.out.println(Cores.TEXT_RESET);
			System.out.println("----------------------------------------");
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_GREEN_BACKGROUND_BRIGHT);
			System.out.println("┌──────────────────────────────────────┐");
			System.out.printf("|%02d UNIDADES DO PRODUTO %02d COMPRADOS!|\n", quantidade, codigo);
			System.out.println("└──────────────────────────────────────┘");
			movel.get().setEstoque(movel.get().getEstoque() + quantidade);
		} else {
			System.out.println(Cores.TEXT_RESET);
			System.out.println("----------------------------------------");
			System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_RED_BACKGROUND_BRIGHT);
			System.out.println("┌──────────────────────────────────────┐");
			System.out.println("|       PRODUTO NÃO ENCONTRADO!        |");
			System.out.println("└──────────────────────────────────────┘");
		}
	}

	// Métodos auxiliares
	public Optional<Movel> buscarNaCollection(int codigo) {
		for (var movel : listaMoveis) {
			if (movel.getCodigo() == codigo)
				return Optional.of(movel);
		}
		return Optional.empty();
	}


}
