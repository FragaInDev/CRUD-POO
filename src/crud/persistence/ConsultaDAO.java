package crud.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.model.Consulta;

public class ConsultaDAO implements  IConsultaDAO {

	public final static String URL = "jdbc:mariadb://localhost:3306/clinica_medica";
	public final static String USER = "root";
	public final static String PASSWORD = "123456";
	private Connection con;

	public ConsultaDAO() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void criar(Consulta co) {
		String sql = "INSERT INTO consulta (id, pacienteCpf, medicoCrm, clinicaID, data, hora, observacao) VALUES(?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, co.getId());
			ps.setString(2, co.getPaciente());
			ps.setString(3, co.getMedico());
			ps.setInt(4, co.getClinica());
			ps.setString(5, co.getData());
			ps.setString(6, co.getHora());
			ps.setString(7, co.getObservacao());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Consulta> pesquisarPorId(int id) {
		List<Consulta> lista = new ArrayList<>();
		String sql = "SELECT * FROM consulta WHERE CONVERT(id, varchar(60)) LIKE '%" + id + "%'";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Consulta co = new Consulta();
				co.setId(rs.getInt("id"));
				co.setPaciente(rs.getString("pacienteCpf"));
				co.setMedico(rs.getString("medicoCrm"));
				co.setClinica(rs.getInt("clinicaID"));
				co.setData(rs.getString("data"));
				co.setHora(rs.getString("hora"));
				co.setObservacao(rs.getString("observacao"));
				lista.add(co);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public void apagar(Consulta co) {
		String sql = "DELETE FROM consulta WHERE id= ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, co.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void atualizar(Consulta co) {
		String sql = "UPDATE consulta SET pacienteCpf= ?, medicoCrm= ?, clinicaID= ?, data= ?, hora= ?, observacao= ? WHERE id= ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, co.getPaciente());
			ps.setString(2, co.getMedico());
			ps.setInt(3, co.getClinica());
			ps.setString(4, co.getData());
			ps.setString(5, co.getHora());
			ps.setString(6, co.getObservacao());
			ps.setInt(7, co.getId());
			ps.execute();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}