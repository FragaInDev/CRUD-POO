package crud.persistence;

import java.util.List;

import crud.model.Consulta;

public interface IConsultaDAO {
    void criar(Consulta co);

	void atualizar(Consulta co);

	void apagar(Consulta co);

	List<Consulta> pesquisarPorId(int id);
}
