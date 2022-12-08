package crud.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.model.Paciente;

public class PacienteDao implements IPacienteDao {

    public static final String URL = "jdbc:mariadb://localhost:3306/clinica_medica";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    private Connection con;

    public PacienteDao() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void criarPaciente(Paciente p) {
        String sql = "INSERT INTO paciente" + "(cpf, nome, telefone, dataNasc) " + "VALUES ('" + p.getCpf() +"', '"+ p.getNome() +"', '"+ p.getTelefone() +"', '"+ p.getDataNascimento() +"')";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Paciente> pesquisarPaciente(String nome) {
        List<Paciente> lista = new ArrayList<>();

        String sql = "SELECT * FROM paciente " 
        + "WHERE nome LIKE '%" + nome + "%'";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Paciente p = new Paciente();
                p.setCpf(rs.getString("cpf"));
                p.setNome(rs.getString("nome"));
                p.setTelefone(rs.getString("telefone"));
                p.setDataNascimento(rs.getString("dataNasc"));      

                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void excluirPaciente(Paciente p) {

        String sql = "DELETE FROM paciente " 
        + "WHERE cpf = "+ p.getCpf();  
        
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void AlterarPaciente(Paciente p) {

        String sql = "UPDATE paciente "
        + "SET telefone = '"+ p.getTelefone() +"', nome = '"+ p.getNome() +"', dataNasc = '"+ p.getDataNascimento() +"' WHERE cpf = "+ p.getCpf();

        try {
           PreparedStatement pstmt = con.prepareStatement(sql);
           pstmt.executeUpdate();
       } catch (SQLException e) {
           e.printStackTrace();
       }
        
    }
    
}
