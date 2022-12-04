package crud.model;

public class Medico {
    private String crm;
    private Especialidade especialidade;
    private String nome;

    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    public Especialidade getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
