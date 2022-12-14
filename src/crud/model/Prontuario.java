package crud.model;


public class Prontuario {
    private int id;
    private String nome;
    private String pacienteCPF;
    private String medicoCRM;
    private int consultaID;
    private int exameID;
    private int medicamentoID;
    private String data;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPaciente() {
        return pacienteCPF;
    }
    public void setPaciente(String pacienteCPF) {
        this.pacienteCPF = pacienteCPF;
    }

    public String getMedico() {
        return medicoCRM;
    }
    public void setMedico(String medicoCRM) {
        this.medicoCRM = medicoCRM;
    }

    public int getConsulta() {
        return consultaID;
    }
    public void setConsulta(int consultaID) {
        this.consultaID = consultaID;
    }

    public int getExame() {
        return exameID;
    }
    public void setExame(int exameID) {
        this.exameID = exameID;
    }

    public int getMedicamento() {
        return medicamentoID;
    }
    public void setMedicamento(int medicamentoID) {
        this.medicamentoID = medicamentoID;
    }

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
