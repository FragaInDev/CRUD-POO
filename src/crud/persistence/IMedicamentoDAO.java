package crud.persistence;

import java.util.List;

import crud.model.Medicamento;

public interface IMedicamentoDAO {
    void criar(Medicamento me);

	void atualizar(Medicamento me);

	void apagar(Medicamento me);

	List<Medicamento> pesquisarPorNome(String nome);
}
