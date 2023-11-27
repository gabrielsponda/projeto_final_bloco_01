package loja.repository;

import loja.model.Movel;

public interface MovelRepository {

	// CRUD
	public void cadastrar(Movel movel);
	
	public void listarTodos();
	
	public void procurarPorCodigo(int codigo);

	public void atualizar(Movel movel);

	public void deletar(int codigo);
	
	// Métodos logísticos
	public void vender(int codigo, int quantidade);
	
	public void comprar(int codigo, int quantidade);
	
}
