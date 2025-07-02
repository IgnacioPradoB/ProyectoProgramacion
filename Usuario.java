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

    public String obtenerInformacion() {
        return "Nombre: " + nombre_completo + "\n" +
               "Usuario: " + nombre_usuario + "\n" +
               "Rol: " + rol + "\n" +
               "Estado: " + estado_de_cuenta + "\n" +
               "¿Tiene clases este mes?: " + (tiene_clases ? "Sí" : "No") + "\n" +
               "-----------------------------\n";
    }
}


