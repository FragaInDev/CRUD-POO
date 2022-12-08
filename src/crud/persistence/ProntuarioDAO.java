package crud.persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crud.model.Prontuario;

public class ProntuarioDAO implements IProntuarioDAO{

    public static final String URL = "jdbc:mariadb://localhost:3306/clinica";
    public static final String USER = "root";
    public static final String PASSWORD = "123456";
    private Connection con;

    public ProntuarioDAO() {
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        
    }

    @Override
    public void create(Prontuario p) {
        String sql = "INSERT INTO prontuario VALUES(?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.setString(2, p.getPaciente());
            ps.setString(3, p.getMedico());
            ps.setInt(4, p.getExame());
            ps.setInt(5, p.getConsulta());
            ps.setInt(6, p.getMedicamento());
            ps.setString(7, p.getData());

            ps.execute();
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }

    @Override
    public void update(Prontuario p) {
        String sql = "UPDATE prontuario SET pacienteCpf= ?, medicoCrm= ?, exameID= ?, consultaID= ?, medicamentoID= ?, data= ? WHERE id= ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(7, p.getId());
            ps.setString(1, p.getPaciente());
            ps.setString(2, p.getMedico());
            ps.setInt(3, p.getExame());
            ps.setInt(4, p.getConsulta());
            ps.setInt(5, p.getMedicamento());
            ps.setString(6, p.getData());

            ps.execute();
            ps.close();
        } catch (SQLException er) {
            er.printStackTrace();
        }
    }

    @Override
    public void delete(Prontuario p) {
        String sql = "DELETE FROM prontuario WHERE id= ?";
        try{
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, p.getId());
            ps.execute();
            ps.close(); 
        } catch (SQLException er) {
            er.printStackTrace();
        }
        
    }


    @Override
    public List<Prontuario> pesquisaPorId(int id) {
        List<Prontuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM prontuario WHERE CONVERT(id, varchar(60)) LIKE '%"+id+"%'";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Prontuario p = new Prontuario();
                p.setId(rs.getInt("id"));
                p.setPaciente(rs.getString("pacienteCpf"));
                p.setMedico(rs.getString("medicoCrm"));
                p.setExame(rs.getInt("exameID"));
                p.setConsulta(rs.getInt("consultaID"));
                p.setMedicamento(rs.getInt("medicamentoID"));
                p.setData(rs.getString("data"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
    
}
