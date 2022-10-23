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
public interface CalculoCompra {
    int IVA = 19;
    int DESCUENTO_CARNE = 20;
    int DESCUENTO_BEBESTIBLE = 12;
    
    void precioFinalProducto(Producto p, int t);
    void totalProductos();
}
