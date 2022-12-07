package crud.model;

public class Medico {
    private String crm;
    private int especialidade;
    private String nome;

    public String getCrm() {
        return crm;
    }
    public void setCrm(String crm) {
        this.crm = crm;
    }

    public int getEspecialidade() {
        return especialidade;
    }
    public void setEspecialidade(int especialidade) {
        this.especialidade = especialidade;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}
