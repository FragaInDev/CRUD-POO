package persistence;

import java.util.List;

import model.Clinica;

public interface IClinicaDao {
    
    public void criarClinica(Clinica c);
    public List <Clinica> pesquisarClinica(String nome);
    public void excluirClinica(Clinica c);
    public void Alterar(Clinica c);
}
