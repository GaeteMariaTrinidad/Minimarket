/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package minimarket;

/**
 *
 * @author Trinidad Gaete
 */
public class Bebestible extends Producto{
    private int cantidadMLitros;

    public Bebestible() {
    }

    public Bebestible(int cantidadMLitros, String nombre, int codigo, int precio, int cantidad, int subtotal) {
        super(nombre, codigo, precio, cantidad, subtotal);
        this.cantidadMLitros = cantidadMLitros;
    }
    
    
    /**
     * @return the cantidadMLitros
     */
    public int getCantidadMLitros() {
        return cantidadMLitros;
    }

    /**
     * @param cantidadMLitros the cantidadMLitros to set
     */
    public void setCantidadMLitros(int cantidadMLitros) {
        this.cantidadMLitros = cantidadMLitros;
    }
    
    
    
}
