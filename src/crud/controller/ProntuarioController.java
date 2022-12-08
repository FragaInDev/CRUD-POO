package crud.controller;

import java.util.List;

import crud.model.Prontuario;
import crud.persistence.ProntuarioDAO;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProntuarioController {
    private IntegerProperty id = new SimpleIntegerProperty();
    private StringProperty paciente = new SimpleStringProperty("");
    private StringProperty medico = new SimpleStringProperty("");
    private IntegerProperty exame = new SimpleIntegerProperty();
    private IntegerProperty consulta = new SimpleIntegerProperty();
    private IntegerProperty medicamento = new SimpleIntegerProperty();
    private StringProperty data = new SimpleStringProperty("");

    private ProntuarioDAO prDao = new ProntuarioDAO();
    private ObservableList<Prontuario> lista = FXCollections.observableArrayList();

    public Prontuario getPron(){
        Prontuario pr = new Prontuario();
        pr.setId(id.get());
        pr.setPaciente(paciente.get());
        pr.setMedico(medico.get());
        pr.setExame(exame.get());
        pr.setConsulta(consulta.get());
        pr.setMedicamento(medicamento.get());
        pr.setData(data.get());
        return pr;
    }

    public void setPron(Prontuario pr){
        id.set(pr.getId());
        paciente.set(pr.getPaciente());
        medico.set(pr.getMedico());
        exame.set(pr.getExame());
        consulta.set(pr.getConsulta());
        medicamento.set(pr.getMedicamento());
        data.set(pr.getData());
    }

    public void adicionar(){
        prDao.create(getPron());
    }

    public void pesquisar(){
        List<Prontuario> tempLista = prDao.pesquisaPorId(id.get());
        lista.clear();
        lista.addAll(tempLista); 
    }

    public void editar(){
        prDao.update(getPron());
    }

    public void excluir(){
        prDao.delete(getPron());
    }

    public void limpaCampos(){
        id.set(0);
        paciente.set("");
        medico.set("");
        exame.set(0);
        consulta.set(0);
        medicamento.set(0);
        data.set("");
    }

    public IntegerProperty idProperty(){
        return id;
    }

    public StringProperty pacienteProperty(){
        return paciente;
    }

    public StringProperty medicoProperty(){
        return medico;
    }

    public IntegerProperty exameProperty(){
        return exame;
    }

    public IntegerProperty consultaProperty(){
        return consulta;
    }

    public IntegerProperty medicamentoProperty(){
        return medicamento;
    }

    public StringProperty dataProperty(){
        return data;
    }


    public ObservableList<Prontuario> getLista() {
        return lista;
    }
}
