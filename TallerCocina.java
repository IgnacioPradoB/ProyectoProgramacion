public class TallerCocina {
    private String nombreTaller;
    private String especialidad;
    private String descripcion;
    private boolean activo;

    public TallerCocina(String nombreTaller, String especialidad, String descripcion) {
        this.nombreTaller = nombreTaller;
        this.especialidad = especialidad;
        this.descripcion = descripcion;
        this.activo = true;
    }

    // Getters y Setters
    public String getNombreTaller() {
        return nombreTaller;
    }

    public void setNombreTaller(String nombreTaller) {
        this.nombreTaller = nombreTaller;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void inactivar() {
        this.activo = false;
    }
}
