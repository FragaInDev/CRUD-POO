package crud.persistence;

import java.util.List;

import crud.model.Especialidade;

public interface IEspecialidadeDAO {

    void create(Especialidade e);
    void update(Especialidade e);
    void delete(Especialidade e);
    List<Especialidade> pesquisarPorNome(String nome);
}
