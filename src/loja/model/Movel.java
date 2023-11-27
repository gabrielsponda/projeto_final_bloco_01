package loja.model;

import loja.util.Cores;

public abstract class Movel {

	// Atributos
	private int codigo;
	private String nome;
	private float preco;
	private float custo;
	private int categoria;
	private int estoque;

	public Movel(int codigo, String nome, float preco, float custo, int categoria, int quantidade) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.custo = custo;
		this.categoria = categoria;
		this.estoque = quantidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public float getCusto() {
		return custo;
	}

	public void setCusto(float custo) {
		this.custo = custo;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int quantidade) {
		this.estoque = quantidade;
	}

	// Método auxiliar
	public void visualizar() {

		String categoria = "";

		switch (this.getCategoria()) {
		case 1 -> categoria = "Cadeira";
		case 2 -> categoria = "Mesa";
		}

		System.out.println(Cores.TEXT_RESET);
		System.out.println("----------------------------------------");
		System.out.println(Cores.TEXT_WHITE_BOLD_BRIGHT + Cores.ANSI_BLUE_BACKGROUND);
		System.out.println("┌──────────────────────────────────────┐");
		System.out.println("|           DADOS DO PRODUTO           |");
		System.out.println("├──────────────────────────────────────┤" + Cores.TEXT_BLACK + Cores.ANSI_WHITE_BACKGROUND);
		System.out.printf("| Código: %-29d|\n", this.getCodigo());
		System.out.printf("| Nome: %-31s|\n", this.getNome());
		System.out.printf("| Preço: %-30.2f|\n", this.getPreco());
		System.out.printf("| Custo: %-30.2f|\n", this.getCusto());
		System.out.printf("| Tipo: %-31s|\n", categoria);
		System.out.printf("| Estoque: %-28s|\n", this.getEstoque());
	}

}