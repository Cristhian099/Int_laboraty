package ec.edu.uce.GUI;

import ec.edu.uce.dominio.Usuario;
import ec.edu.uce.util.Validaciones;

import java.util.ArrayList;
import java.util.Scanner;

public class subMenuRegistrarUsuario {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void registrarUsuario() {
        int opcion;
        do {
            System.out.println("\n--- Menú Registrar Usuario ---");
            System.out.println("1. Registrar nuevo usuario");
            System.out.println("2. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    crearUsuario();
                    break;
                case 2:
                    System.out.println("Regresando al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 2);
    }

    private static void crearUsuario() {
        System.out.println("\n--- Registrar Nuevo Usuario ---");
        System.out.print("Ingrese el nombre del usuario: ");
        String nombre = scanner.nextLine();

        if (!Validaciones.validarNombre(nombre)) {
            System.out.println("El nombre no puede estar vacío.");
            return;
        }

        // Verificar que el nombre de usuario no esté repetido
        if (Validaciones.verificarUsuarioExistente(nombre, listaUsuarios)) {
            System.out.println("El usuario ya existe.");
            return;
        }

        System.out.print("Ingrese el tipo de usuario (estudiante, docente, administrador): ");
        String tipoUsuario = scanner.nextLine();

        if (!Validaciones.validarTipoUsuario(tipoUsuario)) {
            System.out.println("Tipo de usuario no válido. Los tipos válidos son: estudiante, docente, administrador.");
            return;
        }

        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        if (!Validaciones.validarContrasena(contrasena)) {
            System.out.println("La contraseña no puede estar vacía.");
            return;
        }

        System.out.print("Ingrese el correo electrónico: ");
        String correo = scanner.nextLine();

        if (!Validaciones.validarCorreo(correo)) {
            System.out.println("Correo electrónico no válido.");
            return;
        }

        // Crear el nuevo usuario
        Usuario nuevoUsuario = new Usuario(nombre, tipoUsuario, contrasena, correo);
        listaUsuarios.add(nuevoUsuario);
        System.out.println("Usuario registrado exitosamente: " + nuevoUsuario);
    }
}
