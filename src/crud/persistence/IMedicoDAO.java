package crud.persistence;

import java.util.List;

import crud.model.Medico;

public interface IMedicoDAO {

    void create(Medico m);
    void update(Medico m);
    void delete(Medico m);
    List<Medico> pesquisarPorNome(String nome);
}