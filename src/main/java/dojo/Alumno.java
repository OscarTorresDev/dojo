package dojo;

public class Alumno {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String cinturon;
    private String telefono;
    private String correo;
    private String fechaInscripcion; // YYYY-MM-DD

    public Alumno() {}

    public Alumno(int id, String nombre, String apellido, int edad, String cinturon, String telefono, String correo, String fechaInscripcion) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.cinturon = cinturon;
        this.telefono = telefono;
        this.correo = correo;
        this.fechaInscripcion = fechaInscripcion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }

    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getCinturon() { return cinturon; }
    public void setCinturon(String cinturon) { this.cinturon = cinturon; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    public String getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(String fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }
}
