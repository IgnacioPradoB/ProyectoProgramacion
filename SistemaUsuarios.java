import javax.swing.JOptionPane;

public class SistemaUsuarios {
    static Usuario[] lista = new Usuario[50];
    static int cantidad = 0;

    public static void agregar() {
        JOptionPane.showMessageDialog(null, "Agregando nuevo usuario...");

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

        lista[cantidad] = new Usuario(nombre, usuario, clave, rol, tieneClases);
        cantidad++;

        JOptionPane.showMessageDialog(null, "Usuario agregado correctamente.\nTotal registrados: " + cantidad);
    }

    public static void mostrar() {
        String texto = "Total de usuarios registrados: " + cantidad + "\n\n";

        if (cantidad == 0) {
            texto += "No hay usuarios registrados.\n";
        } else {
            for (int i = 0; i < cantidad; i++) {
                texto += lista[i].obtenerInformacion();
            }
        }

        JOptionPane.showMessageDialog(null, texto);
    }

    public static void inactivar() {
        String buscado = JOptionPane.showInputDialog("Ingrese el nombre de usuario a inactivar:");

        for (int i = 0; i < cantidad; i++) {
            if (coincide(lista[i].nombre_usuario, buscado)) {
                if (!lista[i].tiene_clases) {
                    lista[i].estado_de_cuenta = "Inactivo";
                    JOptionPane.showMessageDialog(null, "Usuario inactivado.");
                } else {
                    JOptionPane.showMessageDialog(null, "No se puede inactivar. Tiene clases este mes.");
                }
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "Usuario no encontrado.");
    }

    public static boolean coincide(String a, String b) {
        int i = 0;
        while (i < a.length() && i < b.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                return false;
            }
            i++;
        }
        return a.length() == b.length();
    }   
}
