package loja.model;

public class MovelCadeira extends Movel {

		private float alturaAssento;
		
		public MovelCadeira(int codigo, String nome, float preco, float custo, int categoria, float alturaAssento) {
			super(codigo, nome, preco, custo, categoria);
			this.alturaAssento = alturaAssento;
		}

		public float getAlturaAssento() {
			return alturaAssento;
		}

		public void setAlturaAssento(float alturaAssento) {
			this.alturaAssento = alturaAssento;
		}
		
		@Override
		public void visualizar() {
			super.visualizar();
			 System.out.printf("| Altura do Assento (cm): %-13s|\n", this.getAlturaAssento());
			System.out.println("└──────────────────────────────────────┘");
		}
	
}
