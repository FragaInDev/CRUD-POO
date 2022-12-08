package crud.persistence;

import java.util.List;

import crud.model.Clinica;

public interface IClinicaDao {
    
    public void criarClinica(crud.model.Clinica c);
    public List <Clinica> pesquisarClinica(String nome);
    public void excluirClinica(Clinica c);
    public void Alterar(Clinica c);
}
