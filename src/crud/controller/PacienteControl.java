package controller;

import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Paciente;
import persistence.IPacienteDao;
import persistence.PacienteDao;

public class PacienteControl {
    private StringProperty cpfProperty = new SimpleStringProperty("");
    private StringProperty nomeProperty = new SimpleStringProperty("");
    private StringProperty telefoneProperty = new SimpleStringProperty("");
    private StringProperty dataNascProperty = new SimpleStringProperty("");

    private ObservableList<Paciente> lista = FXCollections.observableArrayList();
    private IPacienteDao pacienteDao = new PacienteDao();

    public Paciente getEntity() {

        Paciente p = new Paciente();
        p.setCpf(cpfProperty.get());
        p.setNome(nomeProperty.get());
        p.setTelefone(telefoneProperty.get());
        p.setDataNascimento(dataNascProperty.get());

        return p;
    }

    public void adicionar() {
        Paciente p = getEntity();
        pacienteDao.criarPaciente(p);
    }

    public void limpar() {

        cpfProperty.set("");
        nomeProperty.set("");
        telefoneProperty.set("");
        dataNascProperty.set("");

    }

    public void pesquisar(){
        List<Paciente> tempList = pacienteDao.pesquisarPaciente(nomeProperty.get());
        lista.clear();
        lista.addAll(tempList);
    }

    public void excluir() {
        Paciente p = getEntity();
        pacienteDao.excluirPaciente(p);
    }

    public void alterar() {
        Paciente p = getEntity();
        pacienteDao.AlterarPaciente(p);
    }
    

    public ObservableList<Paciente> getLista() {
        return lista;
    }

    public StringProperty getCpfProperty() {
        return cpfProperty;
    }

    public StringProperty getNomeProperty() {
        return nomeProperty;
    }

    public StringProperty getTelefoneProperty() {
        return telefoneProperty;
    }

    public StringProperty getDataNascProperty() {
        return dataNascProperty;
    }

}
