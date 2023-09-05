import java.util.ArrayList;

public class Pedido {
    private int numerosPedidos;
    private int idPedido;
    private String nombreCliente;
    private String direccionCliente;
    private ArrayList<Producto> itemsPedido;

    public Pedido(String nombreCliente, String direccionCliente) {
        this.nombreCliente = nombreCliente;
        this.direccionCliente = direccionCliente;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void agregarPedido(Producto itemPedido){
        itemsPedido.add(itemPedido);
    }
    private double getPrecioNetoPedido(){
        double Precio = 0;
        for (int i=0; i<itemsPedido.size();i++){
            Precio = Precio +itemsPedido.get(i).getPrecio();
        }
        return Precio;
    }
    private int getPrecioIvaPedido(){
        int iva= Integer.parseInt(String.valueOf(getPrecioNetoPedido()*.19));
        return iva;
    }
    private double getPrecioTotalPedido(){
        double Total = getPrecioNetoPedido() + getPrecioIvaPedido();
        return Total;
    }
    private String GenerarTextoFactura() {
        return "El pedido de " + nombreCliente + "a la dirección " + direccionCliente + " tuvo un valor de: " + getPrecioTotalPedido() + " el cual fue un valor de" + getPrecioNetoPedido() + " sobre el pedido, y un valor de iva el cual fue:" + getPrecioIvaPedido();
    }

    public int getId() {
        return idPedido;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }
}
