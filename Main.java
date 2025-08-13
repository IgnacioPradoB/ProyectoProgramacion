import javax.swing.JOptionPane;

public class Main {
    public static void main(String[] args) {
        SistemaUsuarios sistema = new SistemaUsuarios();
        int opcionPrincipal = 0;

        do {
            String entrada = JOptionPane.showInputDialog(
                "=== Sistema ChefJoven ===\n" +
                "1. Gestión de Usuarios del Sistema\n" +
                "2. Catálogos Culinarios\n" +
                "3. Registro de Clases y Asistencia\n" +
                "4. Salir\n" +
                "Ingrese opción:"
            );
            if (entrada == null) break;
            try {
                opcionPrincipal = Integer.parseInt(entrada);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Opción inválida.");
                continue;
            }

            switch (opcionPrincipal) {
                case 1:
                    int opUsuarios = 0;
                    do {
                        String menuU = JOptionPane.showInputDialog(
                            "== Gestión de Usuarios ==\n" +
                            "1. Agregar usuario\n" +
                            "2. Mostrar usuarios\n" +
                            "3. Inactivar usuario\n" +
                            "4. Volver al menú principal\n" +
                            "Ingrese opción:"
                        );
                        if (menuU == null) break;
                        try {
                            opUsuarios = Integer.parseInt(menuU);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Opción inválida.");
                            continue;
                        }
                        switch (opUsuarios) {
                            case 1:
                                sistema.agregarUsuario();
                                break;
                            case 2:
                                sistema.mostrarUsuarios();
                                break;
                            case 3:
                                sistema.inactivarUsuario();
                                break;
                            case 4:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                    } while (opUsuarios != 4);
                    break;

                case 2:
                    int opCatalogos = 0;
                    do {
                        String menuC = JOptionPane.showInputDialog(
                            "== Catálogos Culinarios ==\n" +
                            "1. Agregar especialidad\n" +
                            "2. Mostrar especialidades\n" +
                            "3. Agregar taller\n" +
                            "4. Mostrar talleres\n" +
                            "5. Agregar estudiante\n" +
                            "6. Mostrar estudiantes\n" +
                            "7. Inactivar estudiante\n" +    
                            "8. Volver al menú principal\n" +
                            "Ingrese opción:"
                        );
                        if (menuC == null) break;
                        try {
                            opCatalogos = Integer.parseInt(menuC);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Opción inválida.");
                            continue;
                        }
                        switch (opCatalogos) {
                            case 1:
                                sistema.agregarEspecialidad();
                                break;
                            case 2:
                                sistema.mostrarEspecialidades();
                                break;
                            case 3:
                                sistema.agregarTaller();
                                break;
                            case 4:
                                sistema.mostrarTalleres();
                                break;
                            case 5:
                                sistema.agregarEstudiante();
                                break;
                            case 6:
                                sistema.mostrarEstudiantes();
                                break;
                            case 7:
                                sistema.inactivarEstudiante(); 
                                break;
                            case 8:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                    } while (opCatalogos != 8);
                    break;

                case 3:
                    int opAsistencia = 0;
                    JOptionPane.showMessageDialog(null, "Costo mensual de participación: ¢18.000,00");
                    do {
                        String menuA = JOptionPane.showInputDialog(
                            "== Registro de Clases y Asistencia ==\n" +
                            "1. Agregar asistencia\n" +
                            "2. Mostrar asistencias\n" +
                            "3. Inactivar taller\n" +
                            "4. Volver al menú principal\n" +
                            "Ingrese opción:"
                        );
                        if (menuA == null) break;
                        try {
                            opAsistencia = Integer.parseInt(menuA);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Opción inválida.");
                            continue;
                        }
                        switch (opAsistencia) {
                            case 1:
                                sistema.agregarAsistencia();
                                break;
                            case 2:
                                sistema.mostrarAsistencias();
                                break;
                            case 3:
                                sistema.inactivarTaller();
                                break;
                            case 4:
                                break;
                            default:
                                JOptionPane.showMessageDialog(null, "Opción inválida.");
                        }
                    } while (opAsistencia != 4);
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema.");
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida.");
            }
        } while (opcionPrincipal != 4);
    }
}
