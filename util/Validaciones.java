package ec.edu.uce.util;
import ec.edu.uce.dominio.Item;
import ec.edu.uce.dominio.PrestamoItem;
import ec.edu.uce.dominio.Usuario;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.ArrayList;
public class Validaciones {


//Validaciones para registrar usuario


        // Verificar que el nombre no esté vacío
        public static boolean validarNombre(String nombre) {
            return !nombre.trim().isEmpty();
        }

        // Verificar que el tipo de usuario sea válido
        public static boolean validarTipoUsuario(String tipoUsuario) {
            return tipoUsuario.equals("estudiante") || tipoUsuario.equals("docente") || tipoUsuario.equals("administrador");
        }

        // Verificar que la contraseña no esté vacía
        public static boolean validarContrasena(String contrasena) {
            return !contrasena.trim().isEmpty();
        }

        // Verificar si el correo tiene un formato válido
        public static boolean validarCorreo(String correo) {
            String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(correo);
            return matcher.matches();
        }

        // Verificar si el nombre de usuario ya existe en la lista de usuarios
        public static boolean verificarUsuarioExistente(String nombre, ArrayList<Usuario> listaUsuarios) {
            for (Usuario usuario : listaUsuarios) {
                if (usuario.getNombre().equals(nombre)) {
                    return true;  // El usuario ya existe
                }
            }
            return false;
        }


//Validaciones para gestionar facultad

    // Validar que el código de la facultad sea alfanumérico y no vacío
    public static boolean validarCodigo(String codigo) {
        return codigo != null && Pattern.matches("[A-Za-z0-9]+", codigo);
    }

    // Validar que el teléfono tenga un formato correcto (ejemplo: 09xxxxxxxx)
    public static boolean validarTelefono(String telefono) {
        return telefono != null && Pattern.matches("\\d{10}", telefono);
    }

    // Validar que la dirección no esté vacía
    public static boolean validarDireccion(String direccion) {
        return direccion != null && !direccion.trim().isEmpty();
    }
//Validaciones para gestionar laboratorios


    public static boolean validarUbicacion(String ubicacion) {
        return ubicacion != null && !ubicacion.trim().isEmpty();
    }

    public static boolean validarCapacidad(int capacidad) {
        return capacidad > 0;
    }
//Validaciones para gestionar inventario

        // Validar nombre del ítem: no debe ser vacío ni tener caracteres no permitidos
        public static boolean validarNombreItem(String nombre) {
            return nombre != null && !nombre.trim().isEmpty() && nombre.matches("^[a-zA-Z0-9 ]+$");
        }

        // Validar código del ítem: debe ser alfanumérico de 4 a 10 caracteres
        public static boolean validarCodigoItem(String codigo) {
            return codigo != null && !codigo.trim().isEmpty() && codigo.matches("^[A-Za-z0-9]{4,10}$");
        }

        // Validar estado del ítem: solo puede ser "Nuevo", "Usado" o "Dañado"
        public static boolean validarEstadoItem(String estado) {
            return estado != null && !estado.trim().isEmpty() &&
                    (estado.equalsIgnoreCase("Nuevo") || estado.equalsIgnoreCase("Usado") || estado.equalsIgnoreCase("Dañado"));
        }

        // Validar cantidad del ítem: debe ser mayor a cero
        public static boolean validarCantidadPositiva(int cantidad) {
            return cantidad > 0;
        }


//Gestionar prestamo de item


        // Verificar si el código de ítem existe
        public static boolean validarExistenciaItem(String codigo, ArrayList<Item> listaItems) {
            for (Item item : listaItems) {
                if (item.getCodigo().equals(codigo)) {
                    return true;
                }
            }
            return false;
        }

        // Verificar si el código de usuario existe
        public static boolean validarExistenciaUsuario(String codigoUsuario, ArrayList<String> listaUsuarios) {
            return listaUsuarios.contains(codigoUsuario);
        }

        // Verificar si la fecha de devolución es posterior a la fecha de préstamo
        public static boolean validarFechas(Date fechaPrestamo, Date fechaDevolucion) {
            return fechaDevolucion.after(fechaPrestamo);
        }

        // Verificar que el estado sea uno de los valores válidos ("Activo", "Devuelto", "Retrasado")
        public static boolean validarEstadoPrestamo(String estado) {
            return estado.equals("Activo") || estado.equals("Devuelto") || estado.equals("Retrasado");
        }


//Gestionar garantia de prestamos

        // Verificar si el código de préstamo existe
        public static boolean validarExistenciaPrestamo(String codigoPrestamo, ArrayList<PrestamoItem> listaPrestamos) {
            for (PrestamoItem prestamo : listaPrestamos) {
                if (prestamo.getCodigoItem().equals(codigoPrestamo)) {
                    return true;
                }
            }
            return false;
        }

        // Verificar si el monto de garantía es válido (mayor que 0)
        public static boolean validarMontoGarantia(double montoGarantia) {
            return montoGarantia > 0;
        }

        // Verificar que el estado de la garantía sea válido
        public static boolean validarEstadoGarantia(String estado) {
            return estado.equals("activa") || estado.equals("eliminada");
        }

//Gestionar Devolucion de items

        // Verificar si el monto de cobro es válido (mayor que 0)
        public static boolean validarMontoCobro(double montoCobro) {
            return montoCobro >= 0;
        }







}

