package ec.edu.uce.GUI;

import ec.edu.uce.dominio.GarantiaPrestamo;
import ec.edu.uce.dominio.PrestamoItem;
import ec.edu.uce.util.Validaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class subMenuGestionarGarantia {
    private static ArrayList<GarantiaPrestamo> listaGarantias = new ArrayList<>();
    private static ArrayList<PrestamoItem> listaPrestamos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void gestionarGarantia() {
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión de Garantía de Préstamo ---");
            System.out.println("1. Crear garantía");
            System.out.println("2. Modificar garantía");
            System.out.println("3. Eliminar garantía");
            System.out.println("4. Buscar garantía por código de préstamo");
            System.out.println("5. Listar garantías");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearGarantia();
                    break;
                case 2:
                    modificarGarantia();
                    break;
                case 3:
                    eliminarGarantia();
                    break;
                case 4:
                    buscarGarantia();
                    break;
                case 5:
                    listarGarantias();
                    break;
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void crearGarantia() {
        System.out.println("\n--- Crear Nueva Garantía ---");
        System.out.print("Ingrese el código del préstamo: ");
        String codigoPrestamo = scanner.nextLine();
        if (!Validaciones.validarExistenciaPrestamo(codigoPrestamo, listaPrestamos)) {
            System.out.println("Préstamo no encontrado.");
            return;
        }

        System.out.print("Ingrese el monto de garantía: ");
        double montoGarantia = scanner.nextDouble();
        if (!Validaciones.validarMontoGarantia(montoGarantia)) {
            System.out.println("El monto de garantía debe ser mayor que 0.");
            return;
        }

        System.out.print("Ingrese la fecha de registro (dd/MM/yyyy): ");
        String fechaRegistroStr = scanner.nextLine();
        Date fechaRegistro = new Date();  // Convertir la fecha desde el string ingresado

        System.out.print("Ingrese el estado de la garantía (activa/eliminada): ");
        String estado = scanner.nextLine();
        if (!Validaciones.validarEstadoGarantia(estado)) {
            System.out.println("Estado no válido.");
            return;
        }

        GarantiaPrestamo garantia = new GarantiaPrestamo(codigoPrestamo, montoGarantia, fechaRegistro, estado);
        listaGarantias.add(garantia);
        System.out.println("Garantía registrada exitosamente.");
    }

    private static void modificarGarantia() {
        System.out.print("\nIngrese el código del préstamo para modificar la garantía: ");
        String codigoPrestamo = scanner.nextLine();

        for (GarantiaPrestamo garantia : listaGarantias) {
            if (garantia.getCodigoPrestamo().equals(codigoPrestamo)) {
                System.out.println("Garantía encontrada: " + garantia);

                // Modificar atributos (monto, estado, etc.)
                System.out.print("Ingrese el nuevo estado de la garantía: ");
                String estado = scanner.nextLine();
                if (!Validaciones.validarEstadoGarantia(estado)) {
                    System.out.println("Estado no válido.");
                    return;
                }

                garantia.setEstado(estado);
                System.out.println("Garantía modificada exitosamente.");
                return;
            }
        }

        System.out.println("Garantía no encontrada.");
    }

    private static void eliminarGarantia() {
        System.out.print("\nIngrese el código del préstamo para eliminar la garantía: ");
        String codigoPrestamo = scanner.nextLine();

        for (int i = 0; i < listaGarantias.size(); i++) {
            if (listaGarantias.get(i).getCodigoPrestamo().equals(codigoPrestamo)) {
                listaGarantias.remove(i);
                System.out.println("Garantía eliminada exitosamente.");
                return;
            }
        }

        System.out.println("Garantía no encontrada.");
    }

    private static void buscarGarantia() {
        System.out.print("\nIngrese el código del préstamo para buscar la garantía: ");
        String codigoPrestamo = scanner.nextLine();

        for (GarantiaPrestamo garantia : listaGarantias) {
            if (garantia.getCodigoPrestamo().equals(codigoPrestamo)) {
                System.out.println("Garantía encontrada: " + garantia);
                return;
            }
        }

        System.out.println("Garantía no encontrada.");
    }

    private static void listarGarantias() {
        System.out.println("\n--- Listado de Garantías ---");
        if (listaGarantias.isEmpty()) {
            System.out.println("No hay garantías registradas.");
            return;
        }

        for (GarantiaPrestamo garantia : listaGarantias) {
            System.out.println(garantia);
        }
    }
}
