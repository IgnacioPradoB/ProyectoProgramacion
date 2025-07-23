public class Usuario {
    String nombre_completo;
    String nombre_usuario;
    String contrasena;
    String rol;
    String estado_de_cuenta;
    boolean tiene_clases;

    public Usuario(String nombre_completo, String nombre_usuario, String contrasena, String rol, boolean tiene_clases) {
        this.nombre_completo = nombre_completo;
        this.nombre_usuario = nombre_usuario;
        this.contrasena = contrasena;
        this.rol = rol;
        this.estado_de_cuenta = "Activo";
        this.tiene_clases = tiene_clases;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getEstado_de_cuenta() {
        return estado_de_cuenta;
    }

    public void setEstado_de_cuenta(String estado_de_cuenta) {
        this.estado_de_cuenta = estado_de_cuenta;
    }

    public boolean isTiene_clases() {
        return tiene_clases;
    }

    public void setTiene_clases(boolean tiene_clases) {
        this.tiene_clases = tiene_clases;
    }

    public String obtenerInformacion() {
        return "Nombre: " + nombre_completo + "\n" +
               "Usuario: " + nombre_usuario + "\n" +
               "Rol: " + rol + "\n" +
               "Estado: " + estado_de_cuenta + "\n" +
               "¿Tiene clases este mes?: " + (tiene_clases ? "Sí" : "No") + "\n" +
               "-----------------------------\n";
    }
}
