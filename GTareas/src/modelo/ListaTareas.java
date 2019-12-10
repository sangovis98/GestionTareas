package modelo;

import java.util.ArrayList;

import dao.DAOTarea;

public class ListaTareas {
	
	private ArrayList<Tarea> lista;
	
	public ListaTareas() {}
	
	public ArrayList<Tarea> obtenerTareas() {
		try {
			lista = DAOTarea.getInstance().listaTareas();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	public String imprimirListas() {
		String impresionListas = "";
		impresionListas = "<tr><th>Id</th><th>Título</th><th>Descripción</th><th>Categoría</th><th>Fecha de inicio</th>"
				+ "<th>Fecha de fin</th><th></th><th></th></tr>";
		for(Tarea t : lista) {
			impresionListas += t.imprimirTabla();
		}
		return impresionListas;
	}
}
