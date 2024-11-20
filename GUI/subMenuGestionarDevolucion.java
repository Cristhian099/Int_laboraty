package ec.edu.uce.GUI;

import ec.edu.uce.dominio.DevolucionItem;
import ec.edu.uce.dominio.PrestamoItem;
import ec.edu.uce.util.Validaciones;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class subMenuGestionarDevolucion {
    private static ArrayList<DevolucionItem> listaDevoluciones = new ArrayList<>();
    private static ArrayList<PrestamoItem> listaPrestamos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void gestionarDevolucion() {
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión de Devolución de Ítems ---");
            System.out.println("1. Crear devolución");
            System.out.println("2. Modificar devolución");
            System.out.println("3. Eliminar devolución");
            System.out.println("4. Buscar devolución por código de préstamo");
            System.out.println("5. Listar devoluciones");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearDevolucion();
                    break;
                case 2:
                    modificarDevolucion();
                    break;
                case 3:
                    eliminarDevolucion();
                    break;
                case 4:
                    buscarDevolucion();
                    break;
                case 5:
                    listarDevoluciones();
                    break;
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void crearDevolucion() {
        System.out.println("\n--- Crear Nueva Devolución ---");
        System.out.print("Ingrese el código del préstamo: ");
        String codigoPrestamo = scanner.nextLine();
        if (!Validaciones.validarExistenciaPrestamo(codigoPrestamo, listaPrestamos)) {
            System.out.println("Préstamo no encontrado.");
            return;
        }

        System.out.print("Ingrese la fecha de devolución (dd/MM/yyyy): ");
        String fechaDevolucionStr = scanner.nextLine();
        Date fechaDevolucion = new Date();  // Convertir la fecha desde el string ingresado

        System.out.print("Ingrese el estado del ítem (dañado/en buen estado): ");
        String estadoItem = scanner.nextLine();
        if (!Validaciones.validarEstadoItem(estadoItem)) {
            System.out.println("Estado no válido.");
            return;
        }

        double montoCobro = 0;
        if (estadoItem.equals("dañado")) {
            System.out.print("Ingrese el monto de cobro por daño: ");
            montoCobro = scanner.nextDouble();
            if (!Validaciones.validarMontoCobro(montoCobro)) {
                System.out.println("El monto de cobro debe ser mayor o igual a 0.");
                return;
            }
        }

        DevolucionItem devolucion = new DevolucionItem(codigoPrestamo, fechaDevolucion, estadoItem, montoCobro);
        listaDevoluciones.add(devolucion);
        System.out.println("Devolución registrada exitosamente.");
    }

    private static void modificarDevolucion() {
        System.out.print("\nIngrese el código del préstamo para modificar la devolución: ");
        String codigoPrestamo = scanner.nextLine();

        for (DevolucionItem devolucion : listaDevoluciones) {
            if (devolucion.getCodigoPrestamo().equals(codigoPrestamo)) {
                System.out.println("Devolución encontrada: " + devolucion);

                // Modificar atributos (estado, monto de cobro, etc.)
                System.out.print("Ingrese el nuevo estado del ítem: ");
                String estadoItem = scanner.nextLine();
                if (!Validaciones.validarEstadoItem(estadoItem)) {
                    System.out.println("Estado no válido.");
                    return;
                }

                devolucion.setEstadoItem(estadoItem);

                if (estadoItem.equals("dañado")) {
                    System.out.print("Ingrese el nuevo monto de cobro por daño: ");
                    double montoCobro = scanner.nextDouble();
                    if (!Validaciones.validarMontoCobro(montoCobro)) {
                        System.out.println("El monto de cobro debe ser mayor o igual a 0.");
                        return;
                    }
                    devolucion.setMontoCobro(montoCobro);
                }

                System.out.println("Devolución modificada exitosamente.");
                return;
            }
        }

        System.out.println("Devolución no encontrada.");
    }

    private static void eliminarDevolucion() {
        System.out.print("\nIngrese el código del préstamo para eliminar la devolución: ");
        String codigoPrestamo = scanner.nextLine();

        for (int i = 0; i < listaDevoluciones.size(); i++) {
            if (listaDevoluciones.get(i).getCodigoPrestamo().equals(codigoPrestamo)) {
                listaDevoluciones.remove(i);
                System.out.println("Devolución eliminada exitosamente.");
                return;
            }
        }

        System.out.println("Devolución no encontrada.");
    }

    private static void buscarDevolucion() {
        System.out.print("\nIngrese el código del préstamo para buscar la devolución: ");
        String codigoPrestamo = scanner.nextLine();

        for (DevolucionItem devolucion : listaDevoluciones) {
            if (devolucion.getCodigoPrestamo().equals(codigoPrestamo)) {
                System.out.println("Devolución encontrada: " + devolucion);
                return;
            }
        }

        System.out.println("Devolución no encontrada.");
    }

    private static void listarDevoluciones() {
        if (listaDevoluciones.isEmpty()) {
            System.out.println("No hay devoluciones registradas.");
        } else {
            System.out.println("\n--- Listado de Devoluciones ---");
            for (DevolucionItem devolucion : listaDevoluciones) {
                System.out.println(devolucion);
            }
        }
    }
}

