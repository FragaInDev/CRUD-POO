package crud.model;

import java.sql.Time;
import java.sql.Date;

public class Exame {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private Clinica clinica;
    private Date data;
    private Time hora;
    private String diagnostico;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }
    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public Clinica getClinica() {
        return clinica;
    }
    public void setClinica(Clinica clinica) {
        this.clinica = clinica;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }

    public Time getHora() {
        return hora;
    }
    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDiagnostico() {
        return diagnostico;
    }
    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}