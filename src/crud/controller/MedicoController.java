package crud.controller;

import java.util.List;

import crud.model.Medico;
import crud.persistence.MedicoDAO;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MedicoController {

     private StringProperty crm = new SimpleStringProperty("");
     private StringProperty nome = new SimpleStringProperty("");
     private IntegerProperty especialidade = new SimpleIntegerProperty(0);

     private MedicoDAO mDao = new MedicoDAO();

     private ObservableList<Medico> listaMed = FXCollections.observableArrayList();

     public Medico getMed(){
            Medico m = new Medico();
            m.setCrm(crm.get());
            m.setNome(nome.get());
            m.setEspecialidade(especialidade.get());
            return m;
        }

        public void setMed(Medico m){
            crm.set(m.getCrm());
            nome.set(m.getNome());
            especialidade.set(m.getEspecialidade());
        }

        public void adicionar(){
            mDao.create(getMed());
        }

        public void pesquisar(){
            List<Medico> tempLista = mDao.pesquisarPorNome(nome.get());
            listaMed.clear();
            listaMed.addAll(tempLista);
        }

        public void editar(){
            mDao.update(getMed());
        }

        public void excluir(){
            mDao.delete(getMed());
        }

        public void limpaCampos(){
            crm.set("");
            especialidade.set(0);
            nome.set("");
        }

        public StringProperty crmProperty(){
            return crm;
        }

        public IntegerProperty especialidadeProperty(){
            return especialidade;
        }

        public StringProperty nomeProperty(){
            return nome;
        }

        public ObservableList<Medico> getLista() {
            return listaMed;
        }
    }
