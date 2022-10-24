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
    double IVA = 0.19;
    double DESCUENTO_CARNE = 0.20;
    double DESCUENTO_BEBESTIBLE = 0.12;
    
    void precioFinalProducto(Producto p, int t);
    void totalProductos();
}
