<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="dojo.Alumno" %>
<%
    Alumno alumno = (Alumno) request.getAttribute("alumno");
    boolean edit = (alumno != null);
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title><%= edit ? "Editar Alumno" : "Nuevo Alumno" %></title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body class="p-4">
<div class="container">
    <h1><%= edit ? "Editar Alumno" : "Nuevo Alumno" %></h1>
    <form action="AlumnoServlet" method="post">
        <% if (edit) { %>
            <input type="hidden" name="id" value="<%= alumno.getId() %>">
        <% } %>
        <input type="text" name="nombre" placeholder="Nombre" class="form-control mb-2" value="<%= edit ? alumno.getNombre() : "" %>" required>
        <input type="text" name="apellido" placeholder="Apellido" class="form-control mb-2" value="<%= edit ? alumno.getApellido() : "" %>" required>
        <input type="number" name="edad" placeholder="Edad" class="form-control mb-2" value="<%= edit ? alumno.getEdad() : "" %>">
        <input type="text" name="cinturon" placeholder="Cinturón" class="form-control mb-2" value="<%= edit ? alumno.getCinturon() : "" %>">
        <input type="text" name="telefono" placeholder="Teléfono" class="form-control mb-2" value="<%= edit ? alumno.getTelefono() : "" %>">
        <input type="email" name="correo" placeholder="Correo" class="form-control mb-2" value="<%= edit ? alumno.getCorreo() : "" %>">
        <input type="date" name="fecha" class="form-control mb-2" value="<%= edit ? alumno.getFechaInscripcion() : "" %>">
        <button type="submit" class="btn btn-success">Guardar</button>
        <a href="AlumnoServlet" class="btn btn-secondary">Cancelar</a>
    </form>
</div>
</body>
</html>
