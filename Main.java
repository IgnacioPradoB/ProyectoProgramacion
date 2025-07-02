import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        int opcion = 0;

        do {
            String entrada = JOptionPane.showInputDialog(null,
                "===== Usuarios ChefJoven =====\n" +
                "1. Agregar usuario\n" +
                "2. Mostrar usuarios\n" +
                "3. Inactivar usuario\n" +
                "4. Salir\n\n" +
                "Ingrese su opción:"
            );

            if (entrada == null || entrada.equals("")) {
                continue;
            }

            opcion = entrada.charAt(0) - '0';

            switch (opcion) {
                case 1:
                    SistemaUsuarios.agregar();
                    break;
                case 2:
                    SistemaUsuarios.mostrar();
                    break;
                case 3:
                    SistemaUsuarios.inactivar();
                    break;
                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcion != 4);
    }
}
