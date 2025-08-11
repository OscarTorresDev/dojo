package dojo;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/AlumnoServlet")
public class AlumnoServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        AlumnoDao dao = new AlumnoDao();

        if (action == null) {
            // Listar
            List<Alumno> lista = dao.listar();
            request.setAttribute("listaAlumnos", lista);
            request.getRequestDispatcher("alumnos.jsp").forward(request, response);
        } 
        else if (action.equals("edit")) {
            int id = Integer.parseInt(request.getParameter("id"));
            Alumno a = dao.obtenerPorId(id);
            request.setAttribute("alumno", a);
            request.getRequestDispatcher("formAlumno.jsp").forward(request, response);
        } 
        else if (action.equals("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            dao.eliminar(id);
            response.sendRedirect("AlumnoServlet");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AlumnoDao dao = new AlumnoDao();
        String idStr = request.getParameter("id");

        Alumno a = new Alumno();
        a.setNombre(request.getParameter("nombre"));
        a.setApellido(request.getParameter("apellido"));
        a.setEdad(Integer.parseInt(request.getParameter("edad")));
        a.setCinturon(request.getParameter("cinturon"));
        a.setTelefono(request.getParameter("telefono"));
        a.setCorreo(request.getParameter("correo"));
        a.setFechaInscripcion(request.getParameter("fecha"));

        if (idStr == null || idStr.isEmpty()) {
            // Nuevo
            dao.insertar(a);
        } else {
            // Editar
            a.setId(Integer.parseInt(idStr));
            dao.actualizar(a);
        }

        response.sendRedirect("AlumnoServlet");
    }
}
