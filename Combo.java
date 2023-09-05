import java.util.ArrayList;

public class Combo implements Producto {
    private double descuento;
    private String nombreCombo;
    private ArrayList<Producto> itemsCombo;

    public Combo (String nombreCombo, double descuento){
        this.nombreCombo=nombreCombo;
        this.descuento=descuento;
        this.itemsCombo=new ArrayList<Producto>();
    }
    public void agregarItemAcombo(Producto itemCombo){
        itemsCombo.add(itemCombo);
    }

    @Override
    public double getPrecio() {
        double precioTotal=0;
        for(int i=0;i<itemsCombo.size();i++){
            precioTotal=precioTotal+itemsCombo.get(i).getPrecio();
        }
        return precioTotal;
    }

    @Override
    public String getNombre() {
        return nombreCombo;
    }

    @Override
    public String generarTextoFactura() {
        return null;
    }
}
