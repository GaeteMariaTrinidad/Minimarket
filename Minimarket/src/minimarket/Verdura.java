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
public class Verdura extends Producto {

    private String valorNutricional;

    public Verdura() {
    }

    public Verdura(String valorNutricional, String nombre, int codigo, int precio, int cantidad) {
        super(nombre, codigo, precio, cantidad);
        this.valorNutricional = valorNutricional;
    }
    
    /**
     * @return the valorNutricional
     */
    public String getValorNutricional() {
        return valorNutricional;
    }

    /**
     * @param valorNutricional the valorNutricional to set
     */
    public void setValorNutricional(String valorNutricional) {
        this.valorNutricional = valorNutricional;
    }
    
}
