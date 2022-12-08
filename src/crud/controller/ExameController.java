package crud.controller;

import java.util.List;

import crud.model.Exame;
import crud.persistence.ExameDAO;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ExameController {

	 private IntegerProperty id = new SimpleIntegerProperty(0);
	 private StringProperty paciente = new SimpleStringProperty("");
	 private StringProperty medico = new SimpleStringProperty("");
	 private IntegerProperty clinica = new SimpleIntegerProperty(0);
	 private StringProperty data = new SimpleStringProperty("");
	 private StringProperty hora = new SimpleStringProperty("");
	 private StringProperty diagnostico = new SimpleStringProperty("");

	 private ExameDAO exDao = new ExameDAO();

	 private ObservableList<Exame> listaExam = FXCollections.observableArrayList();
	 
	 public Exame getExam(){
	    Exame ex = new Exame();
	    ex.setId(id.get());
	    ex.setPaciente(paciente.get());
	    ex.setMedico(medico.get());
	    ex.setClinica(clinica.get());
	    ex.setData(data.get());
	    ex.setHora(hora.get());
	    ex.setDiagnostico(diagnostico.get());
	    return ex;
	}

	public void setExam(Exame ex){
	    id.set(ex.getId());
	    medico.set(ex.getMedico());
	    paciente.set(ex.getPaciente());
	    clinica.set(ex.getClinica());
	    data.set(ex.getData());
	    hora.set(ex.getHora());
	    diagnostico.set(ex.getDiagnostico());
	}

	public void adicionar(){
	     exDao.create(getExam());
	}

	public void pesquisar(){
	    List<Exame> tempLista = exDao.pesquisarPorId(id.get());
	    listaExam.clear();
	    listaExam.addAll(tempLista);
	}

	public void editar(){
	    exDao.update(getExam());
	}

	public void excluir(){
	    exDao.delete(getExam());
	}

	public void limpaCampos(){
	    id.set(0);
	    paciente.set("");
	    medico.set("");
	    clinica.set(0);
	    data.set("");
	    hora.set("");
	    diagnostico.set("");
	}

	public IntegerProperty idProperty(){
	    return id;
	}
	    
	public StringProperty medicoProperty(){
	    return medico;
	}

	public StringProperty pacienteProperty(){
	    return paciente;
	}
	    
	public IntegerProperty clinicaProperty(){
	    return clinica;
	}
	    
	public StringProperty dataProperty(){
	    return data;
	}
	    
	public StringProperty horaProperty(){
	    return hora;
	}
	    
	public StringProperty diagnosticoProperty(){
	    return diagnostico;
	}

	public ObservableList<Exame> getLista() {
	    return listaExam;
	}
}
