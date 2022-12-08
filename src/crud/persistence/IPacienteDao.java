package persistence;

import java.util.List;

import model.Paciente;

public interface IPacienteDao {

    public void criarPaciente(Paciente p);
    public List <Paciente> pesquisarPaciente(String nome);
    public void excluirPaciente(Paciente p);
    public void AlterarPaciente(Paciente p);
    
}
