package ec.edu.uce.GUI;
import java.util.Scanner;

public class Menu {

    //Constructor
    public Menu(){
        System.out.println("Se ha instanciado la clase Menu");
    }

    //Metodo para mostrar menú y capturar la opcion del usuario
public static void mostrarMenu() {

        Scanner scanner = new Scanner (System.in);
        int opcion;
do {

    System.out.println("****************************");
    System.out.println("BIENVENIDO AL MENU PRINCIPAL");
    System.out.println("1. Registrar usuario");
    System.out.println("2. Gestionar Facultad");
    System.out.println("3. Gestionar laboratorio");
    System.out.println("4. Gestionar Inventario");
    System.out.println("5. Gestionar Prestamo de items");
    System.out.println("6. Gestionar garantia de prestamo");
    System.out.println("7. Gestionar devolucion de items");
    System.out.println("8. Salir");
    System.out.println("Seleccione una opción ");


    opcion= scanner.nextInt();

    // Limpiar el buffer
    scanner.nextLine();

switch (opcion){

    //Llamar a cada submenu
    case 1:
        subMenuRegistrarUsuario.registrarUsuario();
        break;
    case 2:
        subMenuGestionarFacultad.gestionarFacultad();
        break;
    case 3:
        subMenuGestionarLaboratorio.gestionarLaboratorio();
        break;
    case 4:
        subMenuGestionarInventario.gestionarInventario();
        break;
    case 5:
        subMenuGestionarPrestamo.gestionarPrestamo();
        break;
    case 6:
        subMenuGestionarGarantia.gestionarGarantia();
        break;
    case 7:
        subMenuGestionarDevolucion.gestionarDevolucion();
        break;
    case 8:
        System.out.println("Saliendo del sistema.¡Hasta luego!");
        break;
    default:
        System.out.println("Error");
        System.out.println("Elija una opción valida");
        break;
}
} while (opcion !=8);
scanner.close();

}
}



