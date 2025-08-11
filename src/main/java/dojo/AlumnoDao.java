package dojo;

import java.sql.*;
import java.util.*;

public class AlumnoDao {

    public void insertar(Alumno a) {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = ConexionDao.obtenerConexion();
            String sql = "INSERT INTO alumnos(nombre,apellido,edad,cinturon,telefono,correo,fecha_inscripcion) VALUES(?,?,?,?,?,?,?)";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getApellido());
            stmt.setInt(3, a.getEdad());
            stmt.setString(4, a.getCinturon());
            stmt.setString(5, a.getTelefono());
            stmt.setString(6, a.getCorreo());
            if (a.getFechaInscripcion() != null && !a.getFechaInscripcion().isEmpty()) {
                stmt.setDate(7, java.sql.Date.valueOf(a.getFechaInscripcion()));
            } else {
                stmt.setNull(7, java.sql.Types.DATE);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionDao.cerrarConexion(conn);
        }
    }

    public List<Alumno> listar() {
        List<Alumno> lista = new ArrayList<>();
        Connection conn = null;
        try {
            conn = ConexionDao.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM alumnos");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                lista.add(new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("cinturon"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("fecha_inscripcion")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionDao.cerrarConexion(conn);
        }
        return lista;
    }

    public Alumno obtenerPorId(int id) {
        Connection conn = null;
        Alumno a = null;
        try {
            conn = ConexionDao.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM alumnos WHERE id=?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                a = new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getString("cinturon"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("fecha_inscripcion")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionDao.cerrarConexion(conn);
        }
        return a;
    }

    public void actualizar(Alumno a) {
        Connection conn = null;
        try {
            conn = ConexionDao.obtenerConexion();
            String sql = "UPDATE alumnos SET nombre=?, apellido=?, edad=?, cinturon=?, telefono=?, correo=?, fecha_inscripcion=? WHERE id=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, a.getNombre());
            stmt.setString(2, a.getApellido());
            stmt.setInt(3, a.getEdad());
            stmt.setString(4, a.getCinturon());
            stmt.setString(5, a.getTelefono());
            stmt.setString(6, a.getCorreo());
            if (a.getFechaInscripcion() != null && !a.getFechaInscripcion().isEmpty()) {
                stmt.setDate(7, java.sql.Date.valueOf(a.getFechaInscripcion()));
            } else {
                stmt.setNull(7, java.sql.Types.DATE);
            }
            stmt.setInt(8, a.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionDao.cerrarConexion(conn);
        }
    }

    public void eliminar(int id) {
        Connection conn = null;
        try {
            conn = ConexionDao.obtenerConexion();
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM alumnos WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexionDao.cerrarConexion(conn);
        }
    }
}
