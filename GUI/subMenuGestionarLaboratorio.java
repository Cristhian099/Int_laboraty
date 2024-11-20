package ec.edu.uce.GUI;
import ec.edu.uce.dominio.Laboratorio;
import ec.edu.uce.util.Validaciones;
import java.util.ArrayList;
import java.util.Scanner;


public class subMenuGestionarLaboratorio {
    private static ArrayList<Laboratorio> listaLaboratorios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void gestionarLaboratorio() {
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión de Laboratorio ---");
            System.out.println("1. Registrar nuevo laboratorio");
            System.out.println("2. Listar laboratorios");
            System.out.println("3. Buscar laboratorio por código");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarLaboratorio();
                    break;
                case 2:
                    listarLaboratorios();
                    break;
                case 3:
                    buscarLaboratorio();
                    break;
                case 4:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void registrarLaboratorio() {
        System.out.println("\n--- Registrar Nuevo Laboratorio ---");
        System.out.print("Ingrese el nombre: ");
        String nombre = scanner.nextLine();
        if (!Validaciones.validarNombre(nombre)) {
            System.out.println("Error: El nombre no es válido.");
            return;
        }

        System.out.print("Ingrese el código: ");
        String codigo = scanner.nextLine();
        if (!Validaciones.validarCodigo(codigo)) {
            System.out.println("Error: El código no es válido.");
            return;
        }

        System.out.print("Ingrese la ubicación: ");
        String ubicacion = scanner.nextLine();
        if (!Validaciones.validarUbicacion(ubicacion)) {
            System.out.println("Error: La ubicación no es válida.");
            return;
        }

        System.out.print("Ingrese la capacidad máxima: ");
        int capacidad = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        if (!Validaciones.validarCapacidad(capacidad)) {
            System.out.println("Error: La capacidad no es válida.");
            return;
        }

        Laboratorio laboratorio = new Laboratorio(nombre, codigo, ubicacion, capacidad);
        listaLaboratorios.add(laboratorio);
        System.out.println("Laboratorio registrado exitosamente.");
    }

    private static void listarLaboratorios() {
        System.out.println("\n--- Listado de Laboratorios ---");
        if (listaLaboratorios.isEmpty()) {
            System.out.println("No hay laboratorios registrados.");
        } else {
            for (Laboratorio lab : listaLaboratorios) {
                System.out.println(lab);
            }
        }
    }

    private static void buscarLaboratorio() {
        System.out.print("\nIngrese el código del laboratorio a buscar: ");
        String codigo = scanner.nextLine();

        for (Laboratorio lab : listaLaboratorios) {
            if (lab.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Laboratorio encontrado: " + lab);
                return;
            }
        }
        System.out.println("Laboratorio no encontrado.");
    }
}
