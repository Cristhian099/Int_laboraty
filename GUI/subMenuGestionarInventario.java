package ec.edu.uce.GUI;
import ec.edu.uce.dominio.Item;
import ec.edu.uce.util.Validaciones;
import java.util.ArrayList;
import java.util.Scanner;

public class subMenuGestionarInventario {
    private static ArrayList<Item> listaItems = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);

    public static void gestionarInventario() {
        int opcion;
        do {
            System.out.println("\n--- Menú Gestión de Inventario ---");
            System.out.println("1. Crear nuevo ítem");
            System.out.println("2. Modificar ítem");
            System.out.println("3. Eliminar ítem");
            System.out.println("4. Buscar ítem por código");
            System.out.println("5. Listar ítems");
            System.out.println("6. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearItem();
                    break;
                case 2:
                    modificarItem();
                    break;
                case 3:
                    eliminarItem();
                    break;
                case 4:
                    buscarItem();
                    break;
                case 5:
                    listarItems();
                    break;
                case 6:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 6);
    }

    private static void crearItem() {
        System.out.println("\n--- Crear Nuevo Ítem ---");
        System.out.print("Ingrese el nombre del ítem: ");
        String nombre = scanner.nextLine();
        if (!Validaciones.validarNombreItem(nombre)) {
            System.out.println("Error: El nombre del ítem no es válido.");
            return;
        }

        System.out.print("Ingrese el código del ítem: ");
        String codigo = scanner.nextLine();
        if (!Validaciones.validarCodigoItem(codigo)) {
            System.out.println("Error: El código del ítem no es válido.");
            return;
        }

        System.out.print("Ingrese el estado del ítem: ");
        String estado = scanner.nextLine();
        if (!Validaciones.validarEstadoItem(estado)) {
            System.out.println("Error: El estado del ítem no es válido.");
            return;
        }

        System.out.print("Ingrese la cantidad del ítem: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();  // Consumir el salto de línea
        if (!Validaciones.validarCantidadPositiva(cantidad)) {
            System.out.println("Error: La cantidad no es válida.");
            return;
        }

        Item item = new Item(nombre, codigo, estado, cantidad);
        listaItems.add(item);
        System.out.println("Ítem creado exitosamente.");
    }

    private static void modificarItem() {
        if (listaItems.isEmpty()) {
            System.out.println("No hay ítems disponibles para modificar.");
            return;
        }

        System.out.print("\nIngrese el código del ítem a modificar: ");
        String codigo = scanner.nextLine();

        if (!Validaciones.validarExistenciaItem(codigo, listaItems)) {
            System.out.println("Ítem no encontrado.");
            return;
        }

        for (Item item : listaItems) {
            if (item.getCodigo().equals(codigo)) {
                System.out.println("Ítem encontrado: " + item);

                System.out.print("Ingrese el nuevo nombre del ítem: ");
                String nombre = scanner.nextLine();
                if (!Validaciones.validarNombreItem(nombre)) {
                    System.out.println("Error: El nombre del ítem no es válido.");
                    return;
                }

                System.out.print("Ingrese el nuevo estado del ítem: ");
                String estado = scanner.nextLine();
                if (!Validaciones.validarEstadoItem(estado)) {
                    System.out.println("Error: El estado del ítem no es válido.");
                    return;
                }

                System.out.print("Ingrese la nueva cantidad del ítem: ");
                int cantidad = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea
                if (!Validaciones.validarCantidadPositiva(cantidad)) {
                    System.out.println("Error: La cantidad no es válida.");
                    return;
                }

                item.setNombre(nombre);
                item.setEstado(estado);
                item.setCantidad(cantidad);
                System.out.println("Ítem modificado exitosamente.");
                return;
            }
        }
    }

    private static void eliminarItem() {
        if (listaItems.isEmpty()) {
            System.out.println("No hay ítems disponibles para eliminar.");
            return;
        }

        System.out.print("\nIngrese el código del ítem a eliminar: ");
        String codigo = scanner.nextLine();

        if (!Validaciones.validarExistenciaItem(codigo, listaItems)) {
            System.out.println("Ítem no encontrado.");
            return;
        }

        for (int i = 0; i < listaItems.size(); i++) {
            if (listaItems.get(i).getCodigo().equals(codigo)) {
                listaItems.remove(i);
                System.out.println("Ítem eliminado exitosamente.");
                return;
            }
        }
    }

    private static void buscarItem() {
        if (listaItems.isEmpty()) {
            System.out.println("No hay ítems disponibles para buscar.");
            return;
        }

        System.out.print("\nIngrese el código del ítem a buscar: ");
        String codigo = scanner.nextLine();

        if (!Validaciones.validarExistenciaItem(codigo, listaItems)) {
            System.out.println("Ítem no encontrado.");
            return;
        }

        for (Item item : listaItems) {
            if (item.getCodigo().equals(codigo)) {
                System.out.println("Ítem encontrado: " + item);
                return;
            }
        }
    }

    private static void listarItems() {
        if (listaItems.isEmpty()) {
            System.out.println("No hay ítems registrados.");
        } else {
            System.out.println("\n--- Listado de Ítems ---");
            for (Item item : listaItems) {
                System.out.println(item);
            }
        }
    }
}
