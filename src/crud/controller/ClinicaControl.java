package controller;

import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import model.Clinica;
import persistence.ClinicaDaoImp;
import persistence.IClinicaDao;

public class ClinicaControl {
    private IntegerProperty idProperty = new SimpleIntegerProperty(0);
    private StringProperty nomeProperty = new SimpleStringProperty("");
    private StringProperty telefoneProperty = new SimpleStringProperty("");
    private StringProperty emailProperty = new SimpleStringProperty("");
    private StringProperty ruaProperty = new SimpleStringProperty("");
    private IntegerProperty numEndProperty = new SimpleIntegerProperty(0);
    private StringProperty cepProperty = new SimpleStringProperty("");
    private StringProperty bairroProperty = new SimpleStringProperty("");

    private IClinicaDao clinicaDao = new ClinicaDaoImp();

    private ObservableList<Clinica> lista = FXCollections.observableArrayList();

    public Clinica getEntity() {
        Clinica c = new Clinica();
        c.setId(idProperty.get());
        c.setNome(nomeProperty.get());
        c.setTelefone(telefoneProperty.get());
        c.setEmail(emailProperty.get());
        c.setRua(ruaProperty.get());
        c.setNumEnd(numEndProperty.get());
        c.setCep(cepProperty.get());
        c.setBairro(bairroProperty.get());

        return c;
    }

    public void adicionar() {
        Clinica c = getEntity();
        clinicaDao.criarClinica(c);
    }

    public void limpar() {

        nomeProperty.set("");
        idProperty.set(0);
        bairroProperty.set("");
        cepProperty.set("");
        numEndProperty.set(0);
        emailProperty.set("");
        telefoneProperty.set("");
        ruaProperty.set("");

    }

    public void pesquisar(){
        List<Clinica> tempList = clinicaDao.pesquisarClinica(nomeProperty.get());
        lista.clear();
        lista.addAll(tempList);
    }

    public void excluir() {
        Clinica c = getEntity();
        clinicaDao.excluirClinica(c);
    }

    public void alterar() {
        Clinica c = getEntity();
        clinicaDao.Alterar(c);
    }

    public ObservableList<Clinica> getLista() {
        return lista;
    }

    public IntegerProperty getIdProperty() {
        return idProperty;
    }

    public StringProperty getNomeProperty() {
        return nomeProperty;
    }

    public StringProperty getTelefoneProperty() {
        return telefoneProperty;
    }

    public StringProperty getEmailProperty() {
        return emailProperty;
    }

    public StringProperty getRuaProperty() {
        return ruaProperty;
    }

    public IntegerProperty getNumEndProperty() {
        return numEndProperty;
    }

    public StringProperty getCepProperty() {
        return cepProperty;
    }

    public StringProperty getBairroProperty() {
        return bairroProperty;
    }



  

}
