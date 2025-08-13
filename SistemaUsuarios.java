import javax.swing.JOptionPane;

public class SistemaUsuarios {

    private Usuario[] listaUsuarios = new Usuario[50];
    private int cantUsuarios = 0;

    private Especialidad[] listaEspecialidades = new Especialidad[50];
    private int cantEspecialidades = 0;

    private TallerCocina[] listaTalleres = new TallerCocina[50];
    private int cantTalleres = 0;

    private Estudiante[] listaEstudiantes = new Estudiante[50];
    private int cantEstudiantes = 0;

    private RegistroAsistencia[] listaAsistencias = new RegistroAsistencia[100];
    private int cantAsistencias = 0;

  

    public void agregarUsuario() {
        JOptionPane.showMessageDialog(null, "Agregar nuevo usuario...");
        String nombre = JOptionPane.showInputDialog("Nombre completo:");
        String usuario = JOptionPane.showInputDialog("Nombre de usuario:");
        String clave = JOptionPane.showInputDialog("Contraseña:");
        String rol = JOptionPane.showInputDialog("Rol (Padre / Chef / Administrativo):");
        String clases = JOptionPane.showInputDialog("¿Tiene clases este mes? (1 = Sí / 0 = No):");

        if (nombre == null || usuario == null || clave == null || rol == null || clases == null) {
            JOptionPane.showMessageDialog(null, "Datos incompletos. No se registró el usuario.");
            return;
        }

        boolean tieneClases = clases.charAt(0) == '1';

        if (cantUsuarios >= listaUsuarios.length) {
            JOptionPane.showMessageDialog(null, "Capacidad máxima de usuarios alcanzada.");
            return;
        }

        Usuario u = new Usuario();
        u.setNombre_completo(nombre);
        u.setNombre_usuario(usuario);
        u.setContrasena(clave);
        u.setRol(rol);
        u.setTiene_clases(tieneClases);
        listaUsuarios[cantUsuarios] = u;
        cantUsuarios++;

        JOptionPane.showMessageDialog(null, "Usuario agregado correctamente.\nTotal registrados: " + cantUsuarios);
    }

    public void mostrarUsuarios() {
        String texto = "Total de usuarios registrados: " + cantUsuarios + "\n\n";
        if (cantUsuarios == 0) {
            texto += "No hay usuarios registrados.\n";
        } else {
            for (int i = 0; i < cantUsuarios; i++) {
                texto += listaUsuarios[i].obtenerInformacion() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    public void inactivarUsuario() {
        String buscado = JOptionPane.showInputDialog("Ingrese el nombre de usuario a inactivar:");
        if (buscado == null) return;

        for (int i = 0; i < cantUsuarios; i++) {
            if (igualCadena(listaUsuarios[i].getNombre_usuario(), buscado)) {
                if (!listaUsuarios[i].isTiene_clases()) {
                    listaUsuarios[i].setEstado_de_cuenta("Inactivo");
                    JOptionPane.showMessageDialog(null, "Usuario inactivado.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede inactivar. Tiene clases este mes.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
    }



    public void agregarEspecialidad() {
        if (cantEspecialidades >= listaEspecialidades.length) {
            JOptionPane.showMessageDialog(null, "Capacidad máxima de especialidades alcanzada.");
            return;
        }
        String id = JOptionPane.showInputDialog("ID de especialidad:");
        String nombre = JOptionPane.showInputDialog("Nombre de especialidad:");
        String descripcion = JOptionPane.showInputDialog("Descripción:");

        if (id == null || nombre == null || descripcion == null) {
            JOptionPane.showMessageDialog(null, "Datos incompletos.");
            return;
        }

        for (int i = 0; i < cantEspecialidades; i++) {
            if (igualCadena(listaEspecialidades[i].getId(), id)) {
                JOptionPane.showMessageDialog(null, "Especialidad con ese ID ya existe.");
                return;
            }
        }

        Especialidad e = new Especialidad();
        e.setId(id);
        e.setNombre(nombre);
        e.setDescripcion(descripcion);
        listaEspecialidades[cantEspecialidades] = e;
        cantEspecialidades++;

        JOptionPane.showMessageDialog(null, "Especialidad agregada correctamente.");
    }

    public void mostrarEspecialidades() {
        String texto = "Especialidades Culinarias:\n";
        if (cantEspecialidades == 0) {
            texto += "No hay especialidades registradas.\n";
        } else {
            for (int i = 0; i < cantEspecialidades; i++) {
                Especialidad e = listaEspecialidades[i];
                texto += e.getId() + " - " + e.getNombre() + ": " + e.getDescripcion() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    

    public void agregarTaller() {
        if (cantTalleres >= listaTalleres.length) {
            JOptionPane.showMessageDialog(null, "Capacidad máxima de talleres alcanzada.");
            return;
        }

        String nombreTaller = JOptionPane.showInputDialog("Nombre del taller:");
        String especialidad = JOptionPane.showInputDialog("Especialidad (ID):");
        String descripcion = JOptionPane.showInputDialog("Descripción:");

        if (nombreTaller == null || especialidad == null || descripcion == null) {
            JOptionPane.showMessageDialog(null, "Datos incompletos.");
            return;
        }

        boolean existeEsp = false;
        for (int i = 0; i < cantEspecialidades; i++) {
            if (igualCadena(listaEspecialidades[i].getId(), especialidad)) {
                existeEsp = true;
                break;
            }
        }
        if (!existeEsp) {
            JOptionPane.showMessageDialog(null, "Especialidad no existe. Agrega primero la especialidad.");
            return;
        }

        TallerCocina t = new TallerCocina();
        t.setNombreTaller(nombreTaller);
        t.setEspecialidad(especialidad);
        t.setDescripcion(descripcion);
        listaTalleres[cantTalleres] = t;
        cantTalleres++;

        JOptionPane.showMessageDialog(null, "Taller agregado correctamente.");
    }

    public void mostrarTalleres() {
    String texto = "Talleres de Cocina:\n";
    if (cantTalleres == 0) {
        texto += "No hay talleres registrados.\n";
    } else {
        for (int i = 0; i < cantTalleres; i++) {
            TallerCocina t = listaTalleres[i];
            String estado = t.isActivo() ? "Activo" : "Inactivo";
            texto += t.getNombreTaller() + " - Especialidad ID: " + t.getEspecialidad() +
                    "\nDescripción: " + t.getDescripcion() + "\nEstado: " + estado + "\n\n";
        }
    }
    JOptionPane.showMessageDialog(null, texto);
}

   
    public void inactivarTaller() {
        String nombreTaller = JOptionPane.showInputDialog("Ingrese el nombre del taller a inactivar:");
        if (nombreTaller == null) return;

        for (int i = 0; i < cantTalleres; i++) {
            TallerCocina t = listaTalleres[i];
            if (igualCadena(t.getNombreTaller(), nombreTaller)) {
                if (t.isActivo()) {
                    t.inactivar();
                    JOptionPane.showMessageDialog(null, "Taller inactivado correctamente.");
                } else {
                    JOptionPane.showMessageDialog(null, "El taller ya está inactivo.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Taller no encontrado.");
    }

    

    public void agregarEstudiante() {
        if (cantEstudiantes >= listaEstudiantes.length) {
            JOptionPane.showMessageDialog(null, "Capacidad máxima de estudiantes alcanzada.");
            return;
        }

        String nombre = JOptionPane.showInputDialog("Nombre:");
        String apellido = JOptionPane.showInputDialog("Apellido:");
        String provincia = JOptionPane.showInputDialog("Provincia:");
        String direccion = JOptionPane.showInputDialog("Dirección:");
        String telefono = JOptionPane.showInputDialog("Teléfono:");
        String correo = JOptionPane.showInputDialog("Correo electrónico:");
        String encargado = JOptionPane.showInputDialog("Encargado (nombre usuario):");
        String taller = JOptionPane.showInputDialog("Taller asignado (nombre taller):");

        if (nombre == null || apellido == null || provincia == null || direccion == null || telefono == null || correo == null ||
                encargado == null || taller == null) {
            JOptionPane.showMessageDialog(null, "Datos incompletos.");
            return;
        }

        boolean encargadoExiste = false;
        for (int i = 0; i < cantUsuarios; i++) {
            if (igualCadena(listaUsuarios[i].getNombre_usuario(), encargado)) {
                encargadoExiste = true;
                break;
            }
        }
        if (!encargadoExiste) {
            JOptionPane.showMessageDialog(null, "Encargado no existe.");
            return;
        }

        boolean tallerExiste = false;
        for (int i = 0; i < cantTalleres; i++) {
            if (igualCadena(listaTalleres[i].getNombreTaller(), taller)) {
                tallerExiste = true;
                break;
            }
        }
        if (!tallerExiste) {
            JOptionPane.showMessageDialog(null, "Taller no existe.");
            return;
        }

        Estudiante e = new Estudiante();
        e.setNombre(nombre);
        e.setApellido(apellido);
        e.setProvincia(provincia);
        e.setDireccion(direccion);
        e.setTelefono(telefono);
        e.setCorreo(correo);
        e.setEncargado(encargado);
        e.setTaller(taller);
        e.setActivo(true);

        listaEstudiantes[cantEstudiantes] = e;
        cantEstudiantes++;

        JOptionPane.showMessageDialog(null, "Estudiante agregado correctamente.");
    }

    public void mostrarEstudiantes() {
        if (cantEstudiantes == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados.");
            return;
        }

        int total = cantEstudiantes;
        int pagina = 0;
        int porPagina = 3;

        while (true) {
            int inicio = pagina * porPagina;
            if (inicio >= total) break;
            int fin = inicio + porPagina;
            if (fin > total) {
                fin = total;
            }

            String texto = "Estudiantes (Mostrando " + (inicio + 1) + " a " + fin + " de " + total + ")\n\n";
            for (int i = inicio; i < fin; i++) {
                Estudiante e = listaEstudiantes[i];
                texto = texto + "Nombre: " + e.getNombre() + " " + e.getApellido() + "\n" +
                        "Provincia: " + e.getProvincia() + "\n" +
                        "Dirección: " + e.getDireccion() + "\n" +
                        "Teléfono: " + e.getTelefono() + "\n" +
                        "Correo: " + e.getCorreo() + "\n" +
                        "Encargado: " + e.getEncargado() + "\n" +
                        "Taller: " + e.getTaller() + "\n" +
                        "Estado: " + (e.isActivo() ? "Activo" : "Inactivo") + "\n\n";
            }

            JOptionPane.showMessageDialog(null, texto);
            pagina++;
        }
    }

    public void inactivarEstudiante() {
        String buscado = JOptionPane.showInputDialog("Ingrese el nombre completo del estudiante a inactivar (nombre apellido):");
        if (buscado == null) return;

        for (int i = 0; i < cantEstudiantes; i++) {
            Estudiante e = listaEstudiantes[i];
            String nombreCompleto = e.getNombre() + " " + e.getApellido();
            if (igualCadena(nombreCompleto, buscado)) {
                if (e.isActivo()) {
                    e.setActivo(false);
                    JOptionPane.showMessageDialog(null, "Estudiante inactivado.");
                } else {
                    JOptionPane.showMessageDialog(null, "El estudiante ya está inactivo.");
                }
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
    }

    

    public void agregarAsistencia() {
        if (cantAsistencias >= listaAsistencias.length) {
            JOptionPane.showMessageDialog(null, "Capacidad máxima de asistencias alcanzada.");
            return;
        }

        String fecha = JOptionPane.showInputDialog("Fecha (dd/mm/yyyy):");
        String hora = JOptionPane.showInputDialog("Hora (HH:mm):");
        String nombreEst = JOptionPane.showInputDialog("Nombre completo del estudiante:");

        if (fecha == null || hora == null || nombreEst == null) {
            JOptionPane.showMessageDialog(null, "Datos incompletos.");
            return;
        }

        Estudiante estSeleccionado = null;
        for (int i = 0; i < cantEstudiantes; i++) {
            Estudiante e = listaEstudiantes[i];
            String nombreCompleto = e.getNombre() + " " + e.getApellido();
            if (igualCadena(nombreCompleto, nombreEst)) {
                estSeleccionado = e;
                break;
            }
        }
        if (estSeleccionado == null) {
            JOptionPane.showMessageDialog(null, "Estudiante no encontrado.");
            return;
        }

        RegistroAsistencia ra = new RegistroAsistencia();
        ra.setFecha(fecha);
        ra.setHora(hora);
        ra.setEstudiante(estSeleccionado);
        listaAsistencias[cantAsistencias] = ra;
        cantAsistencias++;

        JOptionPane.showMessageDialog(null, "Asistencia registrada.");
    }

    public void mostrarAsistencias() {
        String texto = "Asistencias registradas:\n";
        if (cantAsistencias == 0) {
            texto += "No hay asistencias registradas.\n";
        } else {
            for (int i = 0; i < cantAsistencias; i++) {
                RegistroAsistencia ra = listaAsistencias[i];
                texto += "Fecha: " + ra.getFecha() + ", Hora: " + ra.getHora() +
                        ", Estudiante: " + ra.getEstudiante().getNombre() + " " + ra.getEstudiante().getApellido() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    

    public boolean igualCadena(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) return false;
        }
        return true;
    }
}
