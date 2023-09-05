public class ProductoMenu implements Producto {
    private String nombre;
    private double precioBase;

    public ProductoMenu(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }


    @Override
    public double getPrecio() {
        return precioBase;
    }

    @Override
    public String getNombre() {
        return nombre;
    }

    @Override
    public String generarTextoFactura() {
        return nombre+" "+precioBase;
    }
}
