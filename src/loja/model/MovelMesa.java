package loja.model;

public class MovelMesa extends Movel {

	private int formatoTampo;

	public MovelMesa(int codigo, String nome, float preco, float custo, int categoria, int formatoTampo) {
		super(codigo, nome, preco, custo, categoria);
		this.formatoTampo = formatoTampo;
	}

	public int getFormatoTampo() {
		return formatoTampo;
	}

	public void setFormatoTampo(int formatoTampo) {
		this.formatoTampo = formatoTampo;
	}
	
	@Override
	public void visualizar() {
		
		String formatoTampo;
		
		switch (this.getFormatoTampo()) {
		case 1 -> formatoTampo = "Redondo";
		case 2 -> formatoTampo = "Quadrado";
		case 3 -> formatoTampo = "Retangular";
		default -> throw new IllegalArgumentException("Formato inexistente!");
		}
		
		super.visualizar();
		 System.out.printf("| Formato do tampo: %-19s|\n", formatoTampo);
		System.out.println("└──────────────────────────────────────┘");
	}

}
