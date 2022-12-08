package crud.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.model.Clinica;

public class ClinicaDaoImp implements IClinicaDao{
    public static final String URL = "jdbc:mariadb://localhost:3306/clinica_medica";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    private Connection con;
    
    public ClinicaDaoImp() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException |SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void criarClinica(Clinica c) {
        String sql = "INSERT INTO clinica" + "(id, nome, telefone, email, rua, bairro, cep, numEnd) " + "VALUES (" + c.getId() +", '"+ c.getNome() +"', '"+ c.getTelefone() +"', '"+ c.getEmail() +"', '"+ c.getRua() +"', '"+ c.getBairro() +"', '"+c.getCep() +"', "+ c.getNumEnd() +")";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public List<Clinica> pesquisarClinica(String nome) {

        List<Clinica> lista = new ArrayList<>();

        String sql = "SELECT * FROM clinica " 
        + "WHERE nome LIKE '%" + nome + "%'";

        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            
            while (rs.next()) {
                Clinica c = new Clinica();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setTelefone(rs.getString("telefone"));
                c.setEmail(rs.getString("email"));
                c.setRua(rs.getString("rua"));
                c.setBairro(rs.getString("bairro"));
                c.setCep(rs.getString("cep"));
                c.setNumEnd(rs.getInt("numEnd"));
               

                lista.add(c);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public void excluirClinica(Clinica c) {
        String sql = "DELETE FROM clinica " 
        + "WHERE id = "+ c.getId();  
        
        try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }

    @Override
    public void Alterar(Clinica c) {

        String sql = "UPDATE clinica "
         + "SET nome = '"+ c.getNome() +"', telefone = '"+ c.getTelefone() +"', email = '"+ c.getEmail() +"', rua = '"+ c.getRua() +"', bairro = '"+ c.getBairro() +"', cep = '"+c.getCep() +"', numEnd = "+ c.getNumEnd() + " WHERE id = "+ c.getId();

         try {
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    
}
