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
public class Carne extends Producto {
    
    private String tipoCorte;

    public Carne() {
    }

    public Carne(String tipoCorte, String nombre, int codigo, int precio, int cantidad, int subtotal) {
        super(nombre, codigo, precio, cantidad, subtotal);
        this.tipoCorte = tipoCorte;
    }
    
    /**
     * @return the tipoCorte
     */
    public String getTipoCorte() {
        return tipoCorte;
    }

    /**
     * @param tipoCorte the tipoCorte to set
     */
    public void setTipoCorte(String tipoCorte) {
        this.tipoCorte = tipoCorte;
    }
    
    
    
    
}
