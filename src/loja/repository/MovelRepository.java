package loja.repository;

import loja.model.Movel;

public interface MovelRepository {

	// CRUD
	public void procurarPorCodigo(int codigo);

	public void listarTodos();

	public void cadastrar(Movel movel);

	public void atualizar(Movel movel);

	public void deletar(int codigo);
	
}
