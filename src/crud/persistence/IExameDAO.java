package crud.persistence;

import java.util.List;

import crud.model.Exame;

public interface IExameDAO {

    void create(Exame ex);
    void update(Exame ex);
    void delete(Exame ex);
    List<Exame> pesquisarPorId(Integer id);
}
