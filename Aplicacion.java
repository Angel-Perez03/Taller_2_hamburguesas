import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Aplicacion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del archivo de ingredientes:");
        String nombreArchivoIngredientes = scanner.nextLine();

        System.out.println("Ingrese el nombre del archivo de menú:");
        String nombreArchivoMenu = scanner.nextLine();

        System.out.println("Ingrese el nombre del archivo de combos:");
        String nombreArchivoCombos = scanner.nextLine();

        // Luego puedes pasar estos nombres de archivo a tu objeto Restaurante para cargar la información.
        Restaurante restaurante = new Restaurante();
        restaurante.cargarInformacionRestaurante(
                new File(nombreArchivoIngredientes),
                new File(nombreArchivoMenu),
                new File(nombreArchivoCombos)
        );

        // Solicitar al usuario el nombre del cliente
        System.out.print("Ingrese el nombre del cliente: ");
        String nombreCliente = scanner.nextLine();

        // Solicitar al usuario la dirección del cliente
        System.out.print("Ingrese la dirección del cliente: ");
        String direccionCliente = scanner.nextLine();

        // Inicializar un pedido con los datos proporcionados por el usuario
        Pedido pedido = new Pedido(nombreCliente, direccionCliente);

        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Iniciar Pedido");
            System.out.println("2. Cerrar y Guardar Pedido");
            System.out.println("3. Consultar Pedido en Curso");
            System.out.println("4. Mostrar Menú Base");
            System.out.println("5. Mostrar Ingredientes");
            System.out.println("6. Cargar Información del Restaurante");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    restaurante.iniciarPedido(nombreCliente, direccionCliente);
                    System.out.println("Pedido iniciado.");
                    break;
                    case 2:
                        restaurante.cerrarYGuardarPedido();
                        System.out.println("Pedido cerrado y guardado.");
                        break;
                        case 3:
                            Pedido pedidoEnCurso = restaurante.getPedidoEnCurso();
                            if (pedidoEnCurso != null) {
                                System.out.println("Pedido en curso:");
                                System.out.println("Nombre del cliente: " + pedidoEnCurso.getNombreCliente());
                                System.out.println("Dirección de entrega: " + pedidoEnCurso.getDireccionCliente());
                            } else {
                                System.out.println("No hay pedido en curso.");
                            }
                            break;
                        case 4:
                            ArrayList<ProductoMenu> menuBase = restaurante.getMenuBase();
                            System.out.println("Menú Base:");
                            for (Producto producto : menuBase) {
                                System.out.println(producto.getNombre() + " - $" + producto.getPrecio());
                            }
                            break;
                        case 5:
                            ArrayList<Ingrediente> ingredientes = restaurante.getIngredientes();
                            System.out.println("Ingredientes Disponibles:");
                            for (Ingrediente ingrediente : ingredientes) {
                                System.out.println(ingrediente.getNombre() + " - $" + ingrediente.getCostoAdicional());
                            }
                            break;
                        case 6:
                            System.out.print("Ingrese el nombre del archivo de ingredientes: ");
                            String archivoIngredientes = scanner.nextLine();
                            System.out.print("Ingrese el nombre del archivo del menú: ");
                            String archivoMenu = scanner.nextLine();
                            System.out.print("Ingrese el nombre del archivo de combos: ");
                            String archivoCombos = scanner.nextLine();
                            restaurante.cargarInformacionRestaurante(new File(archivoIngredientes), new File(archivoMenu), new File(archivoCombos));
                            System.out.println("Información del restaurante cargada.");
                            break;
                        case 7:
                            System.out.println("Saliendo del programa.");
                            System.exit(0);
                        default:
                            System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}