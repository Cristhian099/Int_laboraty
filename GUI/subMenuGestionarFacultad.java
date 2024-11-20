package ec.edu.uce.GUI;

import ec.edu.uce.dominio.Facultad;
import ec.edu.uce.util.Validaciones;

import java.util.ArrayList;
import java.util.Scanner;

public class subMenuGestionarFacultad {
    private static ArrayList<Facultad> listaFacultades = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void gestionarFacultad() {
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión de Facultad ---");
            System.out.println("1. Registrar nueva facultad");
            System.out.println("2. Listar facultades");
            System.out.println("3. Buscar facultad por código");
            System.out.println("4. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarFacultad();
                    break;
                case 2:
                    listarFacultades();
                    break;
                case 3:
                    buscarFacultad();
                    break;
                case 4:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void registrarFacultad() {
        System.out.println("\n--- Registrar Nueva Facultad ---");
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

        System.out.print("Ingrese la dirección: ");
        String direccion = scanner.nextLine();
        if (!Validaciones.validarDireccion(direccion)) {
            System.out.println("Error: La dirección no es válida.");
            return;
        }

        System.out.print("Ingrese el teléfono: ");
        String telefono = scanner.nextLine();
        if (!Validaciones.validarTelefono(telefono)) {
            System.out.println("Error: El teléfono no es válido.");
            return;
        }

        Facultad facultad = new Facultad(nombre, codigo, direccion, telefono);
        listaFacultades.add(facultad);
        System.out.println("Facultad registrada exitosamente.");
    }

    private static void listarFacultades() {
        System.out.println("\n--- Listado de Facultades ---");
        if (listaFacultades.isEmpty()) {
            System.out.println("No hay facultades registradas.");
        } else {
            for (Facultad facultad : listaFacultades) {
                System.out.println(facultad);
            }
        }
    }

    private static void buscarFacultad() {
        System.out.print("\nIngrese el código de la facultad a buscar: ");
        String codigo = scanner.nextLine();

        for (Facultad facultad : listaFacultades) {
            if (facultad.getCodigo().equalsIgnoreCase(codigo)) {
                System.out.println("Facultad encontrada: " + facultad);
                return;
            }
        }
        System.out.println("Facultad no encontrada.");
    }
}
