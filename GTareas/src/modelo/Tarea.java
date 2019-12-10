package modelo;

import dao.DAOTarea;

public class Tarea {
	
	private int id;
	private String titulo;
	private String descripcion;
	private int importante;
	private String fecha_inicio;
	private String fecha_fin;
	private int categoria;
	private int depende;
	
	public Tarea() {
		titulo = "";
		descripcion = "";
		fecha_inicio = "";
		fecha_fin = "";
	}
	
	public Tarea(int id, String titulo, String descripcion, int categoria, int importante, String fecha_inicio, String fecha_fin,
			 int depende) {
		this.id = id;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.importante = importante;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.categoria = categoria;
		this.depende = depende;
	}
	
	public Tarea(String titulo, String descripcion, int categoria, int importante, String fecha_inicio, String fecha_fin,
			int depende) {
		
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.importante = importante;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.categoria = categoria;
		this.depende = depende;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getImportante() {
		return importante;
	}
	public void setImportante(int importante) {
		this.importante = importante;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_fin() {
		return fecha_fin;
	}
	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getDepende() {
		return depende;
	}
	public void setDepende(int depende) {
		this.depende = depende;
	}
	
	public void insertar() {
		try {
			DAOTarea.getInstance().insertarTarea(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void buscarID(int id) {
		Tarea t = null;
		
		try {
			t = DAOTarea.getInstance().buscarID(id);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		if (t != null) {
			this.id = t.getId();
			this.titulo = t.getTitulo();
			this.descripcion = t.getDescripcion();
			this.categoria = t.getCategoria();
			this.importante = t.getImportante();
			this.depende = t.getDepende();
		}
	}
	
	public String imprimirTabla() {
		
		String txt = "";
		
		txt += "<tr><td>"+ getId() +"</td>";
		txt += "<td>"+ getTitulo() +"</td>";
		txt += "<td>"+ getDescripcion() +"</td>";
		txt += "<td>"+ getCategoria() +"</td>";
		txt += "<td>"+ getFecha_inicio() +"</td>";
		txt += "<td>"+ getFecha_fin() +"</td>";
		txt += "<td><a href=\"AltaTarea?option=edit&id="+this.id+"\">Editar</a></td>";
		txt += "<td><a href=\"AltaTarea?option=delete&id="+this.id+"\">Borrar</a></td>";
		
		return txt;
	}
	
	public void update() {
		try {
			DAOTarea.getInstance().update(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void borrar() {
		try {
			DAOTarea.getInstance().delete(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() { //los métodos de impresión siempre al final
		return "Tarea [id=" + id + ", titulo=" + titulo + ", descripcion=" + descripcion + ", importante=" + importante
				+ ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin + ", categoria=" + categoria
				+ ", depende=" + depende + "]";
	}
	
}