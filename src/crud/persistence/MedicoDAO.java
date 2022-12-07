package crud.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.model.Medico;

public class MedicoDAO implements IMedicoDAO{
	public static final String URL = "jdbc:mariadb://localhost:3306/clinica";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    private Connection con;
    
    public MedicoDAO() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
    }

	@Override public void create(Medico m){
		String sql = "INSERT INTO medico (crm, nome, especialidadeID) VALUES (?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.getCrm());
            ps.setString(2, m.getNome());
            ps.setInt(3, m.getEspecialidade());
            ps.execute();
        } catch (SQLException er) {
            er.printStackTrace();
        }
	}

	@Override public void update(Medico m){
		String sql = "UPDATE medico SET nome= ?, especialidadeID= ?  WHERE crm= ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(3, m.getCrm());
            ps.setString(1, m.getNome());
            ps.setInt(2, m.getEspecialidade());
            ps.execute();
            ps.close(); 
        } catch (SQLException er) {
            er.printStackTrace();
        }
	}

	@Override public void delete(Medico m){
		String sql = "DELETE FROM medico WHERE crm= ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, m.getCrm());
            ps.execute();
            ps.close(); 
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }
	

	@Override public List<Medico> pesquisarPorNome(String nome){
		List<Medico> lista = new ArrayList<>();
        String sql = "SELECT * FROM medico WHERE nome LIKE '%"+ nome +"%'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Medico m = new Medico();
                m.setCrm(rs.getString("crm"));
                m.setEspecialidade(rs.getInt("especialidadeID"));
                m.setNome(rs.getString("nome"));
                lista.add(m);
            }
        } catch (SQLException er) {
            er.printStackTrace();
        }
        return lista;
	}

}