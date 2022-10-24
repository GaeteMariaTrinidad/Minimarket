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
//Creación de Subclase Verdura (Hereda atributos de Superclase Producto)
public class Verdura extends Producto {
    
    //Atributo propio de la subclase
    private String valorNutricional;

    //Constructores
    public Verdura() {
    }

    public Verdura(String valorNutricional, String nombre, int codigo, int precio, int cantidad, int subtotal) {
        super(nombre, codigo, precio, cantidad, subtotal);
        this.valorNutricional = valorNutricional;
    }
    
    //Getters & Setters
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
