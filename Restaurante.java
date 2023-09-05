import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class Restaurante {
    private ArrayList<Combo> combos;
    private ArrayList<Pedido> pedidos;
    private int ultimopedido=0;
    private ArrayList<Ingrediente> ingredientes;
    private Pedido pedidoEnCurso;
    private ArrayList<ProductoMenu> menuBase;
    private HashMap<String, ArrayList<String>> combosEspeciales;
    public void iniciarPedido(String nombreCliente, String direccionCliente) {
        Pedido nuevoPedido = new Pedido(nombreCliente, direccionCliente);
        ultimopedido++;
        pedidos.add(nuevoPedido);
    }
    public Pedido consultaPedidoPorId(int idPedido){
        for (Pedido pedido : pedidos) {
            if (pedido.getId() == idPedido) {
                return pedido;
            }
        }
        return null; // Retorna null si no se encuentra el pedido con el ID dado
    }


    public void cargarInformacionRestaurante(File archivoIngredientes, File archivoMenu, File archivoCombos) {
        // Lógica para cargar información desde los archivos especificados
        cargarIngredientes(archivoIngredientes);
        cargarMenu(archivoMenu);
        cargarCombos(archivoCombos);
    }

    private void cargarIngredientes(File archivoIngredientes) {
        ingredientes = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoIngredientes))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes usando un separador (por ejemplo, un punto y coma)
                String[] partes = linea.split(";");

                if (partes.length >= 2) {
                    String nombre = partes[0].trim();
                    double precio = Double.parseDouble(partes[1].trim());

                    // Crear un objeto Ingrediente y agregarlo a la lista de ingredientes
                    Ingrediente ingrediente = new Ingrediente(nombre, (int) precio);
                    ingredientes.add(ingrediente);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarMenu(File archivoMenu) {
        menuBase = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoMenu))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes usando un separador (;)
                String[] partes = linea.split(";");

                if (partes.length >= 2) {
                    String nombre = partes[0].trim();
                    double precio = Double.parseDouble(partes[1].trim());

                    // Crear un objeto Producto y agregarlo al menú base
                    ProductoMenu producto = new ProductoMenu(nombre, precio);
                    menuBase.add(producto);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cargarCombos(File archivoCombos) {
        combosEspeciales = new HashMap<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCombos))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Dividir la línea en partes usando una coma como separador
                String[] partes = linea.split(";");

                if (partes.length >= 2) {
                    String nombreCombo = partes[0].trim();
                    ArrayList<String> productosCombo = new ArrayList<>();

                    // Agregar los elementos restantes como productos del combo
                    for (int i = 1; i < partes.length; i++) {
                        productosCombo.add(partes[i].trim());
                    }

                    combosEspeciales.put(nombreCombo, productosCombo);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void cerrarYGuardarPedido() {
        if (pedidoEnCurso != null) {
            // Agregar el pedido en curso a la lista de pedidos
            pedidos.add(pedidoEnCurso);

            // Realizar otras acciones de guardado, como guardar en un archivo o base de datos

            // Reiniciar el pedido en curso
            pedidoEnCurso = null;
        } else {
            System.out.println("No hay un pedido en curso para cerrar y guardar.");
        }
    }

    public Pedido getPedidoEnCurso() {
        return pedidoEnCurso;
    }
    public ArrayList<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public ArrayList<ProductoMenu> getMenuBase() {
        return menuBase;
    }
}





