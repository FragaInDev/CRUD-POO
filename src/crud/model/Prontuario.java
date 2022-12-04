package crud.model;

import java.sql.Date;

public class Prontuario {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private Consulta consulta;
    private Exame exame;
    private Medicamento medicamento;
    private Date data;

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

    public Consulta getConsulta() {
        return consulta;
    }
    public void setConsulta(Consulta consulta) {
        this.consulta = consulta;
    }

    public Exame getExame() {
        return exame;
    }
    public void setExame(Exame exame) {
        this.exame = exame;
    }

    public Medicamento getMedicamento() {
        return medicamento;
    }
    public void setMedicamento(Medicamento medicamento) {
        this.medicamento = medicamento;
    }

    public Date getData() {
        return data;
    }
    public void setData(Date data) {
        this.data = data;
    }
}
