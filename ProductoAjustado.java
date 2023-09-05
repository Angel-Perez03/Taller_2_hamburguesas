import java.util.ArrayList;

public class ProductoAjustado implements Producto {
    private ProductoMenu base;
    private ArrayList<Ingrediente> agregados;
    private ArrayList<Ingrediente> eliminados;

    public ProductoAjustado(ProductoMenu base, ArrayList<Ingrediente> agregados, ArrayList<Ingrediente> eliminados) {
        this.base = base;
        this.agregados = agregados;
        this.eliminados = eliminados;
    }
    @Override
    public String getNombre(){
        return base.getNombre();
    }

    @Override
    public double getPrecio() {
        double precio= base.getPrecio();
        double precioTotal=0;
        for(int i = 0;i<agregados.size();i++) {
            precioTotal = precioTotal + agregados.get(i).getCostoAdicional();
        }
        for (int j = 0; j < eliminados.size(); j++) {
            precioTotal = precioTotal - eliminados.get(j).getCostoAdicional();
        }
        return precio+precioTotal;
    }

    @Override
    public String generarTextoFactura() {
        return "El total de su factura es de: ";
    }
}
