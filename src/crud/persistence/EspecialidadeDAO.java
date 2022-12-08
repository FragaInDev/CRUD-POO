package crud.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.model.Especialidade;

public class EspecialidadeDAO implements IEspecialidadeDAO {
    public static final String URL = "jdbc:mariadb://localhost:3306/clinica_medica";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    private Connection con;

    public EspecialidadeDAO() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void create(Especialidade e) {
        String sql = "INSERT INTO especialidade (id, nome) VALUES (?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, e.getId());
            ps.setString(2, e.getNome());
            ps.execute();
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }

    @Override
    public List<Especialidade> pesquisarPorNome(String nome) {
        List<Especialidade> lista = new ArrayList<>();
        String sql = "SELECT * FROM especialidade WHERE nome LIKE '%"+ nome +"%'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Especialidade e = new Especialidade();
                e.setId(rs.getInt("id"));
                e.setNome(rs.getString("nome"));
                lista.add(e);
            }
        } catch (SQLException er) {
            er.printStackTrace();
        }
        return lista;
    }

    @Override
    public void update(Especialidade e){
        String sql = "UPDATE especialidade SET nome= ? WHERE id= ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, e.getNome());
            ps.setInt(2, e.getId());
            ps.execute();
            ps.close(); 
        } catch (SQLException er) {
            er.printStackTrace();
        }
       
    }

    @Override
    public void delete(Especialidade e) {
        String sql = "DELETE FROM especialidade WHERE id= ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, e.getId());
            ps.execute();
            ps.close(); 
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }
    
}
