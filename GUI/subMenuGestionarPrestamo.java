package ec.edu.uce.GUI;

import ec.edu.uce.dominio.Item;
import ec.edu.uce.dominio.PrestamoItem;
import ec.edu.uce.util.Validaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class subMenuGestionarPrestamo {
    private static ArrayList<PrestamoItem> listaPrestamos = new ArrayList<>();
    private static ArrayList<Item> listaItems = new ArrayList<>();
    private static ArrayList<String> listaUsuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void gestionarPrestamo() {
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión de Préstamo de Ítems ---");
            System.out.println("1. Crear préstamo");
            System.out.println("2. Modificar préstamo");
            System.out.println("3. Eliminar préstamo");
            System.out.println("4. Buscar préstamo por código de ítem");
            System.out.println("5. Listar préstamos");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearPrestamo();
                    break;
                case 2:
                    modificarPrestamo();
                    break;
                case 3:
                    eliminarPrestamo();
                    break;
                case 4:
                    buscarPrestamo();
                    break;
                case 5:
                    listarPrestamos();
                    break;
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void crearPrestamo() {
        System.out.println("\n--- Crear Nuevo Préstamo ---");
        System.out.print("Ingrese el código del ítem: ");
        String codigoItem = scanner.nextLine();
        if (!Validaciones.validarExistenciaItem(codigoItem, listaItems)) {
            System.out.println("Ítem no encontrado.");
            return;
        }

        System.out.print("Ingrese el código del usuario: ");
        String codigoUsuario = scanner.nextLine();
        if (!Validaciones.validarExistenciaUsuario(codigoUsuario, listaUsuarios)) {
            System.out.println("Usuario no encontrado.");
            return;
        }

        System.out.print("Ingrese la fecha de préstamo (dd/MM/yyyy): ");
        String fechaPrestamoStr = scanner.nextLine();
        Date fechaPrestamo = new Date(); // Convertir la fecha desde el string ingresado

        System.out.print("Ingrese la fecha de devolución (dd/MM/yyyy): ");
        String fechaDevolucionStr = scanner.nextLine();
        Date fechaDevolucion = new Date(); // Convertir la fecha desde el string ingresado

        if (!Validaciones.validarFechas(fechaPrestamo, fechaDevolucion)) {
            System.out.println("La fecha de devolución debe ser posterior a la fecha de préstamo.");
            return;
        }

        System.out.print("Ingrese el estado del préstamo (Activo/Devuelto/Retrasado): ");
        String estado = scanner.nextLine();
        if (!Validaciones.validarEstadoPrestamo(estado)) {
            System.out.println("Estado no válido.");
            return;
        }

        PrestamoItem prestamo = new PrestamoItem(codigoItem, codigoUsuario, fechaPrestamo, fechaDevolucion, estado);
        listaPrestamos.add(prestamo);
        System.out.println("Préstamo creado exitosamente.");
    }

    private static void modificarPrestamo() {
        System.out.print("\nIngrese el código del ítem del préstamo a modificar: ");
        String codigoItem = scanner.nextLine();

        for (PrestamoItem prestamo : listaPrestamos) {
            if (prestamo.getCodigoItem().equals(codigoItem)) {
                System.out.println("Préstamo encontrado: " + prestamo);

                // Modificar atributos (fecha, estado, etc.)
                System.out.print("Ingrese el nuevo estado del préstamo: ");
                String estado = scanner.nextLine();
                if (!Validaciones.validarEstadoPrestamo(estado)) {
                    System.out.println("Estado no válido.");
                    return;
                }

                prestamo.setEstado(estado);
                System.out.println("Préstamo modificado exitosamente.");
                return;
            }
        }

        System.out.println("Préstamo no encontrado.");
    }

    private static void eliminarPrestamo() {
        System.out.print("\nIngrese el código del ítem del préstamo a eliminar: ");
        String codigoItem = scanner.nextLine();

        for (int i = 0; i < listaPrestamos.size(); i++) {
            if (listaPrestamos.get(i).getCodigoItem().equals(codigoItem)) {
                listaPrestamos.remove(i);
                System.out.println("Préstamo eliminado exitosamente.");
                return;
            }
        }

        System.out.println("Préstamo no encontrado.");
    }

    private static void buscarPrestamo() {
        System.out.print("\nIngrese el código del ítem a buscar: ");
        String codigoItem = scanner.nextLine();

        for (PrestamoItem prestamo : listaPrestamos) {
            if (prestamo.getCodigoItem().equals(codigoItem)) {
                System.out.println("Préstamo encontrado: " + prestamo);
                return;
            }
        }

        System.out.println("Préstamo no encontrado.");
    }

    private static void listarPrestamos() {
        System.out.println("\n--- Listado de Préstamos ---");
        if (listaPrestamos.isEmpty()) {
            System.out.println("No hay préstamos registrados.");
            return;
        }

        for (PrestamoItem prestamo : listaPrestamos) {
            System.out.println(prestamo);
        }
    }
}
