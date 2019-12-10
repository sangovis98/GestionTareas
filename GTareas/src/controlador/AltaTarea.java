<>package controlador;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Tarea;
import java.sql.*;

/**
 * Servlet implementation class AltaTarea
 */
@WebServlet("/AltaTarea")
public class AltaTarea extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AltaTarea() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		
		if(request.getParameter("option") != null) {
			if(request.getParameter("option").equals("edit")) {
				RequestDispatcher rd = request.getRequestDispatcher("altasTareas.jsp");
				rd.forward(request, response);
				return;
			}
			
			if(request.getParameter("option").equals("delete")) {
				Tarea t = new Tarea();
				t.buscarID(Integer.parseInt(request.getParameter("id")));
				t.borrar();
				RequestDispatcher rd = request.getRequestDispatcher("listaTareas.jsp");
				rd.forward(request, response);
				return;
			}
		}
		
		String titulo = request.getParameter("titulo");
		String descripcion = request.getParameter("descripcion");
		int categoria = Integer.parseInt(request.getParameter("categoria"));
		int importancia = Integer.parseInt(request.getParameter("importancia"));
		String fecha_inicio = request.getParameter("fecha_inicio");
		String fecha_fin = request.getParameter("fecha_fin");
		int dependencia = Integer.parseInt(request.getParameter("dependencia"));
		
			Tarea t = new Tarea();
			t.setTitulo(titulo);
			t.setDescripcion(descripcion);
			t.setCategoria(categoria);
			t.setImportante(importancia);
			t.setFecha_inicio(fecha_inicio);
			t.setFecha_fin(fecha_fin);
			t.setDepende(dependencia);
				
		if(request.getParameter("id").equals("0")) {
			t.insertar();
			RequestDispatcher rd = request.getRequestDispatcher("listaTareas.jsp");
			rd.forward(request, response);
			return;
		} else {				
			t.setId(Integer.parseInt(request.getParameter("id")));
			t.update();
			RequestDispatcher rd = request.getRequestDispatcher("listaTareas.jsp");
			rd.forward(request, response);
			return;
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
