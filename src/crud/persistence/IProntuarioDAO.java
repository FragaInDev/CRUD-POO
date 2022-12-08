package crud.persistence;

import java.util.List;

import crud.model.Prontuario;

public interface IProntuarioDAO {
    void create(Prontuario p);
    void update(Prontuario p);
    void delete(Prontuario p);
    List<Prontuario> pesquisaPorId(int id);
}
