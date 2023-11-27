package loja.repository;

import loja.model.Movel;

public interface MovelRepository {

	// CRUD
	public void cadastrar(Movel movel);
	
	public void listarTodos();
	
	public void procurarPorCodigo(int codigo);

	public void atualizar(Movel movel);

	public void deletar(int codigo);
	
}
