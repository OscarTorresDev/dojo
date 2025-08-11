<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.*, dojo.Alumno" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Alumnos Dojo</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="p-4">
<div class="container">
    <h1>Alumnos del Dojo</h1>
    <a href="formAlumno.jsp" class="btn btn-primary mb-3">Nuevo Alumno</a>
    <table class="table table-bordered">
        <tr>
            <th>ID</th><th>Nombre</th><th>Apellido</th><th>Edad</th><th>Cinturón</th><th>Teléfono</th><th>Correo</th><th>Fecha</th><th>Acciones</th>
        </tr>
        <%
            List<Alumno> lista = (List<Alumno>) request.getAttribute("listaAlumnos");
            if (lista != null) {
                for (Alumno a : lista) {
        %>
        <tr>
            <td><%= a.getId() %></td>
            <td><%= a.getNombre() %></td>
            <td><%= a.getApellido() %></td>
            <td><%= a.getEdad() %></td>
            <td><%= a.getCinturon() %></td>
            <td><%= a.getTelefono() %></td>
            <td><%= a.getCorreo() %></td>
            <td><%= a.getFechaInscripcion() %></td>
            <td>
                <a href="AlumnoServlet?action=edit&id=<%= a.getId() %>" class="btn btn-warning btn-sm">Editar</a>
                <a href="AlumnoServlet?action=delete&id=<%= a.getId() %>" class="btn btn-danger btn-sm" onclick="return confirm('¿Eliminar este alumno?')">Eliminar</a>
            </td>
        </tr>
        <%      }
            }
        %>
    </table>
</div>
</body>
</html>
