package crud.controller;

import java.util.List;

import crud.model.Especialidade;
import crud.persistence.EspecialidadeDAO;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EspecialidadeController {
    private IntegerProperty id = new SimpleIntegerProperty(0);
    private StringProperty nome = new SimpleStringProperty("");

    private EspecialidadeDAO eDao = new EspecialidadeDAO();

    private ObservableList<Especialidade> lista = FXCollections.observableArrayList();

    public Especialidade getEspec(){
        Especialidade e = new Especialidade();
        e.setId(id.get());
        e.setNome(nome.get());
        return e;
    }

    public void setEspec(Especialidade e){
        id.set(e.getId());
        nome.set(e.getNome());
    }

    public void adicionar(){
        eDao.create(getEspec());
    }

    public void pesquisar(){
        List<Especialidade> tempLista = eDao.pesquisarPorNome(nome.get());
        lista.clear();
        lista.addAll(tempLista);
    }

    public void editar(){
        eDao.update(getEspec());
    }

    public void excluir(){
        eDao.delete(getEspec());
    }

    public void limpaCampos(){
        id.set(0);
        nome.set("");
    }

    public IntegerProperty idProperty(){
        return id;
    }

    public StringProperty nomeProperty(){
        return nome;
    }

    public ObservableList<Especialidade> getLista() {
        return lista;
    }
}
