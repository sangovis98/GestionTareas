package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.PreparedStatement;

import conexion.DBConnection;
import modelo.Tarea;

public class DAOTarea {
	
	private Connection con = null;
	public static DAOTarea instance = null;
	
	public DAOTarea() throws SQLException, ClassNotFoundException {
		con = DBConnection.getConnection();
	}

	public static DAOTarea getInstance() throws SQLException, ClassNotFoundException {
		if (instance == null)
			instance = new DAOTarea();
		return instance;
	}
	
	public void insertarTarea(Tarea t) throws SQLException {
		PreparedStatement ps = (PreparedStatement) con.prepareStatement
				("INSERT INTO tareaTest (titulo, descripcion, categoria,"
				+ "importancia, fecha_inicio, fecha_fin, depende)" + "VALUES" + "(?,?,?,?,?,?,?)");
		
		ps.setString(1, t.getTitulo());
		ps.setString(2, t.getDescripcion());
		ps.setInt(3, t.getCategoria());
		ps.setInt(4, t.getImportante());
		ps.setString(5, t.getFecha_inicio());
		ps.setString(6, t.getFecha_fin());
		ps.setInt(7,  t.getDepende());
		
		ps.executeUpdate();
		ps.close();
	}
	
	public ArrayList<Tarea> listaTareas() throws SQLException {
		ArrayList<Tarea> resultadoLista = new ArrayList<Tarea>();
		
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM tareaTest");
		ResultSet rs = ps.executeQuery();
			
		while (rs.next()) {
			Tarea t = new Tarea (
					rs.getInt(1),
					rs.getString(2),
					rs.getString(3), 
					rs.getInt(4),
					rs.getInt(5),
					rs.getString(6),
					rs.getString(7),
					rs.getInt(8));
			resultadoLista.add(t);
		}
		
		rs.close();
		ps.close();
		return resultadoLista;
	}
	
	public Tarea buscarID(int id) throws SQLException {
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("SELECT * FROM tareaTest WHERE id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		Tarea result = null;
		
		if (rs.next()) {
			result = new Tarea(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
					rs.getString(6), rs.getString(7), rs.getInt(8));
		}
		rs.close();
		ps.close();
		return result;
	}

	public void update(Tarea t) throws SQLException {
		PreparedStatement ps = (PreparedStatement) con.prepareStatement("UPDATE tareaTest SET titulo = ?, descripcion = ?,"
				+ " categoria = ?, importancia = ?, fecha_inicio = ?, fecha_fin = ?, depende = ? WHERE id = ?");
		
		ps.setString(1, t.getTitulo());
		ps.setString(2, t.getDescripcion());
		ps.setInt(3, t.getCategoria());
		ps.setInt(4, t.getImportante());
		ps.setString(5, t.getFecha_inicio());
		ps.setString(6, t.getFecha_fin());
		ps.setInt(7,  t.getDepende());
		ps.setInt(8, t.getId());
		
		ps.executeUpdate();
		ps.close();
	}
	
	
	public void delete(int id) throws SQLException {

		PreparedStatement ps = (PreparedStatement) con.prepareStatement("DELETE FROM tareaTest WHERE id = ?");
		ps.setInt(1, id);
		ps.executeUpdate();
		ps.close();
	}

}
