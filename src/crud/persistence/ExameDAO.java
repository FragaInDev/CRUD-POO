package crud.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.model.Exame;

public class ExameDAO implements IExameDAO{
	public static final String URL = "jdbc:mariadb://localhost:3306/clinica_medica";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    private Connection con;
    
    public ExameDAO() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
    }

	@Override public void create(Exame ex){
		String sql = "INSERT INTO exame (id, pacienteCpf, medicoCrm, clinicaId, data, hota, diagnostico) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ex.getId());
            ps.setString(2, ex.getPaciente());
            ps.setString(3, ex.getMedico());
            ps.setInt(4, ex.getClinica());
            ps.setString(5, ex.getData());
            ps.setString(6, ex.getHora());
            ps.setString(7, ex.getDiagnostico());
            ps.execute();
        } catch (SQLException er) {
            er.printStackTrace();
        }
	}

	@Override public void update(Exame ex){
		String sql = "UPDATE exame SET diagnostico= ? WHERE id= ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ex.getId());
            ps.setString(2, ex.getPaciente());
            ps.setString(3, ex.getMedico());
            ps.setInt(4, ex.getClinica());
            ps.setString(5, ex.getData());
            ps.setString(6, ex.getHora());
            ps.setString(7, ex.getDiagnostico());
            ps.execute();
            ps.close(); 
        } catch (SQLException er) {
            er.printStackTrace();
        }
	}

	@Override public void delete(Exame ex){
		String sql = "DELETE FROM exame WHERE id= ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, ex.getId());
            ps.execute();
            ps.close(); 
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }


	@Override public List<Exame> pesquisarPorId(Integer id){
		List<Exame> lista = new ArrayList<>();
        String sql = "SELECT * FROM exame WHERE CONVERT(id, varchar(60)) LIKE '%"+id+"%'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Exame ex = new Exame();
                ex.setId(rs.getInt("id"));
                ex.setPaciente(rs.getString("pacienteCpf"));
                ex.setMedico(rs.getString("medicoCrm"));
                ex.setClinica(rs.getInt("clinicaID"));
                ex.setData(rs.getString("data"));
                ex.setHora(rs.getString("hora"));
                ex.setDiagnostico(rs.getString("diagnostico"));                
                lista.add(ex);
            }
        } catch (SQLException er) {
            er.printStackTrace();
        }
        return lista;
	}

}